package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.Claim;

import javax.transaction.Transactional;
import java.util.List;

public interface IClaimServices {
    Claim addClaim(Claim claim);
    void deleteClaim(Integer id);
    List<Claim> fetchClaimList();
    void updatePost(Claim claim);
    void delete();


    @Transactional
    Claim addAndAssignClaimToDeliveryToUser(Claim claim, Integer idD, Integer id);

    @Transactional
    Claim addAndAssignClaimToPubToUser(Claim claim, Integer idPub, Integer id);


  // Integer countClaimsByDeliverer(Integer id);

    @Transactional
    Claim addAndAssignClaimToComLignToUser(Claim claim, Integer idComLign, Integer id);

    //affichage avec tri par date
    List<Claim> triPub();

    List<Claim> listeReclamationsTratitees();
    List<Claim> listeReclamationsNonTratitees();
    Claim traiterRec(Integer idClaim, Claim reclamation);

    @Transactional
    Claim addAndassignClaimtoUser(Claim claim, Integer idCus);
    //  int nbrdeliverer(Integer idC);











}
