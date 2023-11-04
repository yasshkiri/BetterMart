package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.*;
import com.PIDEV.demo.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class ClaimServicesImpl implements IClaimServices {
    @Autowired
    IClaimRepository claimRepository;
    @Autowired
    IDeliveryRepository deliveryRepository;
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    CommandLigneRep commandLigneRepository;
    @Autowired
    CustomerRepository customerRepository;
    //EmailService ES;




    //ajout réclam
    @Override
    public Claim addClaim(Claim claim) {

        return claimRepository.save(claim);
    }

    //supprimer reclam
    @Override
    public void deleteClaim(Integer id) {

        claimRepository.deleteById(id);
    }

    //afficher reclam
    @Override
    public List<Claim> fetchClaimList() {
        return (List<Claim>)
                claimRepository.findAll();
    }

    public Optional<Claim> getPostById(Integer id) {

        return claimRepository.findById(id);
    }

    public void updatePost(Claim claim) {

        claimRepository.save(claim);
    }

    public void delete() {

        claimRepository.deleteAll();
    }


    //ajouter et affecter claim to user about the web app
    @Transactional
    @Override
    public Claim addAndassignClaimtoUser(Claim claim, Integer id) {

        Customer customer = customerRepository.findById(id).orElse(null);
        claim.setCustomer(customer);
        claim.setDateC(new Date());
        return claimRepository.save(claim);
    }


    //ajouter et affecter claim to user to delivery
    @Transactional
    @Override
    public Claim addAndAssignClaimToDeliveryToUser(Claim claim, Integer idD, Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        claim.setCustomer(customer);

        Delivery d = deliveryRepository.findById(idD).orElse(null);
        claim.setDelivery(d);
        claim.setDateC(new Date());
        claimRepository.save(claim);
        return claim;
    }

    //ajouter et affecter claim to user to publication
    @Transactional
    @Override
    public Claim addAndAssignClaimToPubToUser(Claim claim, Integer idPub, Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        claim.setCustomer(customer);
        Publication p = publicationRepository.findById(idPub).orElse(null);
        claim.setPublication(p);
        claim.setDateC(new Date());
        claimRepository.save(claim);
        return claim;
    }


    //ajouter et affecter claim to user to CommLigne
    @Transactional
    @Override
    public Claim addAndAssignClaimToComLignToUser(Claim claim, Integer idComLign, Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        claim.setCustomer(customer);
        CommandLigne commandLigne = commandLigneRepository.findById(idComLign).orElse(null);
        claim.setCommandLigness(commandLigne);
        claim.setDateC(new Date());
        claimRepository.save(claim);
        return claim;
    }



    //affichage avec tri par date
    @Override
    public List<Claim> triPub() { return claimRepository.triPub();
    }







    // public Integer countClaimsByDeliverer(Integer id) {
    //    return claimRepository.countByDelivererId(id);
    //  }


    @Override
    public List<Claim> listeReclamationsTratitees() {
        return claimRepository.reclamationsTraitees();
    }

    @Override
    public List<Claim> listeReclamationsNonTratitees() {
        return claimRepository.reclamationsNonTratitees();
    }

    @Override
    public Claim traiterRec(Integer idClaim, Claim reclamation) {
        reclamation = this.claimRepository.findById(idClaim).get();
        reclamation.setEtat(true);
        return reclamation;

    }







    // @Override
    //public int nbrdeliverer(Integer idC) {
    //  int somme=0;
    // Claim claim = claimRepository.findById(idC).orElse(null);
    //Set<Delivery> deliveries = claim.getDelivery();
    //for (Delivery list : deliveries) {
    //  somme += list.getDeliverer().getId();
    //}
    //return somme;
    //}
   /* private String buildEmail(String name, Boolean etat, String productType , String Description) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirmation de mail</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> un etuiant a été ajouté avec succés à votre equipe   </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">  </p></blockquote>\n nom " + etat + " prenom " + productType + "inscrit en " + Description + " est le nouveau memebre de l'equipe  . <p>Merci.</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }
    private String buildEmail1(String name, Boolean etat, String productType , String Description) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> l'equipe est déjà saturée    </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">  </p></blockquote>\n malheureusement nom "  + etat + " prenom "+ productType+ " inscrit en " +Description + " n'a pas pu nous rejoindre . <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }*/

    }














