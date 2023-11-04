package com.PIDEV.demo.services;


import com.PIDEV.demo.entities.Deliverer;
import com.PIDEV.demo.entities.Delivery;
import com.PIDEV.demo.entities.RelyPoint;
import com.PIDEV.demo.repository.DelivererRep;
import com.PIDEV.demo.repository.DeliveryRep;
import com.PIDEV.demo.repository.RelyPointRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class DeliveryService implements  IDeliveryService {

    @Autowired
    DeliveryRep deliveryRep;
    @Autowired
    RelyPointRep relyPointRep;
   @Autowired
   DelivererRep delivererRep;
/*
    @Autowired
    UserRep userRep;
    @Autowired
    OrderRep orderRep;*/


    @Override
    public void supprimerDelivery(int idD)
    {
        deliveryRep.deleteById(idD);
    }

    @Override
    public void ajouterDelivery(Delivery d)
    {
        d.setDate(new Date());
        deliveryRep.save(d);
    }

    @Override
    public Delivery modifierDelivery(Delivery d)
    {
        Optional<Delivery> modif=deliveryRep.findById(d.getIdD());
        if (modif.isPresent())
        {
            
            modif.get().setReference(d.getReference());
            return deliveryRep.save(modif.get());

        }else {
            throw new NoSuchElementException("Delivery not found. ");
        }
    }

    @Override
    public List<Delivery> affichageAll()
    {
        return (List<Delivery>) deliveryRep.findAll();
    }

    @Override
    public Delivery afficheDelivery (Integer  idD)
    {
        return deliveryRep.findById(idD).orElse(null);
    }


    @Override
    public void AffecterPointRely (Integer idD, Integer IdRp){
        Delivery delivery = deliveryRep.findById(idD).orElse(null);
        RelyPoint relyPoint = relyPointRep.findById(IdRp).orElse(null);
        delivery.setRelyPoint(relyPoint);
        relyPointRep.save(relyPoint);
    }


    @Override
    public void AffecterDeliverer (Integer idD,Integer id)
    {
        Delivery delivery = deliveryRep.findById(idD).orElse(null);
        Deliverer deliverer = delivererRep.findById(id).orElse(null);
        delivery.setDeliverer(deliverer);
        delivererRep.save(deliverer);
    }


    public int getLivreursDisponibles() {
        return  deliveryRep.findByDisponible(1);
    }


    public int searchDeliveryByReference(String reference) {
        return deliveryRep.findByReference(reference);
    }





}
