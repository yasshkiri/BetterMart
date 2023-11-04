package com.PIDEV.demo.services;


import com.PIDEV.demo.entities.RelyPoint;

import java.util.List;

public interface IRelyService {

    public void ajouterRelyPoint(RelyPoint p);
    public RelyPoint modifierRelyPoint(RelyPoint p, int idRp);
    void supprimerRelyPoint (int idRp);
    public List<RelyPoint> affichageAllRely();
    public RelyPoint afficheRely (Integer  idRp);
    public Long countD ();
    public List<RelyPoint> findByAddress(String ad);



}
