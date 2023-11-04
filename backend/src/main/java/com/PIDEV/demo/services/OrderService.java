package com.PIDEV.demo.services;


import com.PIDEV.demo.entities.CommandLigne;
import com.PIDEV.demo.entities.Facture;
import com.PIDEV.demo.entities.Orderr;
import com.PIDEV.demo.entities.Product;
import com.PIDEV.demo.repository.CommandLigneRep;
import com.PIDEV.demo.repository.FactureRep;
import com.PIDEV.demo.repository.OrderRep;
import com.PIDEV.demo.repository.ProductRepository;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    public void EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    private final OrderRep or;
    private final FactureRep fr;
    private final CommandLigneRep commandLigneRep;
    private final ProductRepository productRep;

    @Override
    public void ajoutOrder(Orderr order) {
        order.setRefer(generateUniqueId());
        order.setState("processing order");
        or.save(order);
        sendmail(order);
    }
    @Override
    public String generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        String uniqueId = uuid.toString().replace("-", "").substring(0, 10);
        return uniqueId;

    }
    @Override
    @Transactional
    public void updateOrderState() {
        LocalDate ld = LocalDate.now().minusDays(10);
        Instant instant = ld.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date d = Date.from(instant);
       List<Orderr> orders = or.findByDateOrderLessThan(d);//FindOrders(d);
        for (Orderr order : orders) {
            order.setState("done");
            or.save(order);
        }
    }
    @Override
    public void addFacture( int ido) {
        Facture facture = new Facture();
        Orderr or1 = or.findById(ido).orElse(null);
        float Tprix=CalculeTotale(ido);
        facture.setTotale(Tprix);
        facture.setOrderr(or1);
        facture.setRef(generateUniqueId());
        fr.save(facture);
    }


    @Override
    public void deleteOrder(int ido) {
        or.deleteById(ido);
    }

    @Override
    public void updateProduct(int idcmd) {
        CommandLigne cmd = commandLigneRep.findById(idcmd).orElse(null);//Product prd= productRep.findById(idPrdct).orElse(null);
        Product prd = cmd.getProduct();



        cmd.setQunt(cmd.getQunt()-1);
        cmd.setPrice((int) (cmd.getPrice()- prd.getPrice()));//cl.setPrice((int) (cl.getQunt() * cl.getProduct().getPrice()));
        commandLigneRep.save(cmd);
    }

    @Override
    public Facture FacturesOfOrder(int ido) {
        Orderr order = or.findById(ido).orElse(null);
        return order.getFacture();
    }


    /**
     *
     * @param ido
     * @return list of command lignes of that specific order
     */
    @Override
    public Set<CommandLigne> listLigneCommand(int ido) {
        Orderr order = or.findById(ido).orElse(null);
        return order.getCommandLignes();
    }

    @Override
    public void deletelignecommande(int idlc) {
        commandLigneRep.deleteById(idlc);
    }

    @Override
    public Facture GetFacture(int id) {
        return fr.findById(id).get();
    }


    /**
     *
     * @param idProduit
     * Add a product
     */

    @Override
    public void affectPreoductLignecommande(int idProduit) {

        Product p=productRep.findById(idProduit).orElse(null);
        CommandLigne cmd = commandLigneRep.findProduct(idProduit);
        if(cmd==null)
        {
            CommandLigne cl = new CommandLigne();
            cl.setProduct(p);
            cl.setQunt(cl.getQunt() + 1);
            cl.setPrice((int) (cl.getQunt() * cl.getProduct().getPrice()));
            commandLigneRep.save(cl);
        }
       else
       {
           cmd.setProduct(p);
        cmd.setQunt(cmd.getQunt()+1);
        cmd.setPrice((int) (cmd.getQunt()*cmd.getProduct().getPrice()));
        commandLigneRep.save(cmd);
       }


    }


    @Override
    public void AddligneCommandeToOrder(int idCmd, int ido) {
        Orderr order = or.findById(ido).orElse(null);
        CommandLigne cmd= commandLigneRep.findById(idCmd).orElse(null);
        cmd.setOrderr(order);
        commandLigneRep.save(cmd);
    }

    @Override
    public float CalculeTotale(int idO) {
      Orderr  order = or.findById(idO).orElse(null);
     float totale = commandLigneRep.findOrder(idO);
     return totale;
    }



    @Override
    public void export(HttpServletResponse response, int id) throws IOException {
        Document document = new Document(PageSize.A4);
        Orderr o1 = GetOrder(id);
        float t1= CalculeTotale(id);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(10);

        Paragraph paragraph = new Paragraph("Your invoice refrance :"+ String.valueOf(o1.getRefer()), fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph paragraph1 = new Paragraph("Order added on :"+ String.valueOf(o1.getDateOrder()), fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_RIGHT);

        Paragraph paragr = new Paragraph("", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE);
        fontTitle.setSize(12);
        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);


        Paragraph paragraph2 = new Paragraph("Totale:"+String.valueOf(t1), fontParagraph);
        paragraph2.setAlignment(Paragraph.JPEG);

        document.add(paragraph);
        document.add(paragr);
        document.add(paragraph1);
        document.add(paragraph2);

        document.close();
    }

    @Override
    public Orderr GetOrder(int id) {
        return or.findById(id).orElse(null);
    }




  /*  @Override
     public void generateQRCodeImage(String text, int id) throws IOException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 350, 350);

        Path path = FileSystems.getDefault().getPath("src/main/resources/images/QRCode.png"+String.valueOf(id)+".png");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }*/


    ///// mail








    public void sendmail(Orderr order) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("dorsafayed816@gmail.com");
        mailSender.setPassword("nvlrwtdvhdzqajfx");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        mailSender.setJavaMailProperties(properties);
        String from = mailSender.getUsername();
        String to = order.getMail();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("New order");
        message.setText("New order has been added" + "\r" + "Reference : " + order.getRefer() +
                "\r" + " Date :" + order.getDateOrder() +
                "\r" + " State :" + order.getState() );

        mailSender.send(message);

    }



}



