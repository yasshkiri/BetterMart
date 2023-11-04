package com.PIDEV.demo.services;



import com.PIDEV.demo.entities.Delivery;

import java.util.List;

public interface IDeliveryService {


    public void supprimerDelivery(int idD);
    public void ajouterDelivery(Delivery d);
    public Delivery modifierDelivery(Delivery d);
    public List<Delivery> affichageAll();
    public Delivery afficheDelivery (Integer  idD);
    public void AffecterPointRely (Integer idD, Integer IdRp);

    public void AffecterDeliverer (Integer idD,Integer id);

    public int getLivreursDisponibles();


   public int searchDeliveryByReference(String reference);



}
