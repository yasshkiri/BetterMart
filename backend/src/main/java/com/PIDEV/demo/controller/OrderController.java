package com.PIDEV.demo.controller;


import com.PIDEV.demo.entities.CommandLigne;
import com.PIDEV.demo.entities.Facture;
import com.PIDEV.demo.entities.Orderr;
import com.PIDEV.demo.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/Order")
@RequiredArgsConstructor
public class OrderController {

   private final IOrderService os;

    @PostMapping("/add-Order")
    public void addOrder(@RequestBody Orderr o){
        os.ajoutOrder(o);
    }

    @PostMapping("/ProductTolignecommande/{idp}")
    public void affectProductToLigneCommande(@PathVariable("idp")int idP)
    {
        os.affectPreoductLignecommande(idP);
        // return os.FacturesOfOrder(idOrder);//centreCommercialService.listeBoutique(idCentre);
    }

    @PostMapping("/add-Facture/{ido}")
    public void addFacture(@PathVariable("ido")int ido){
        os.addFacture(ido);
    }

    @PostMapping("/addCommandligneToOrder/{idcmd}/{ido}")
    public void addCommandLigneToOrder(@PathVariable("idcmd")int idcmd,@PathVariable("ido")int idO){
        os.AddligneCommandeToOrder(idcmd, idO);
    }

    @PutMapping("/modifyStateOrder")
    public void updateState(){
        os.updateOrderState();
    }
    @GetMapping("/pdf/generate/{id}")
    public void generatePDF(HttpServletResponse response,@PathVariable("id")int id) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.os.export(response,id);//pdfGeneratorService.export(response);
    }
    @GetMapping("/Facture/{id-order}")
    public Facture FactureOfOrder(@PathVariable("id-order")int idOrder) {
        return os.FacturesOfOrder(idOrder);//centreCommercialService.listeBoutique(idCentre);
    }

    @DeleteMapping("/deleteOrder/{idO}")
    public void DeleteOrder(@PathVariable("idO") int ido)
    {
        os.deleteOrder(ido);
    }
    @GetMapping("/Order/{idO}")
    public Set<CommandLigne> AffichOrder(@PathVariable("idO")int idOrder) {
        return os.listLigneCommand(idOrder);// os.FacturesOfOrder(idOrder);//centreCommercialService.listeBoutique(idCentre);
    }


    @GetMapping("/totale-prix/{id-order}")
    public float TotalePrix(@PathVariable("id-order")int idOrder) {
        return os.CalculeTotale(idOrder);
        //.FacturesOfOrder(idOrder);//centreCommercialService.listeBoutique(idCentre);
    }

    @PutMapping("/updateProduct/{id-order}")
    public void UpdateProduct(@PathVariable("id-order") int ido)
    {
        os.updateProduct(ido);
    }
    @DeleteMapping("/deleteCommandeLigne/{idlc}")
    public void DeleteLigneCommande(@PathVariable("idlc") int idlc)
    {
        os.deletelignecommande(idlc);
    }



}
