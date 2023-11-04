package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.RelyPoint;
import com.PIDEV.demo.repository.DeliveryRep;
import com.PIDEV.demo.repository.RelyPointRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class RelyService implements IRelyService {

   @Autowired
   RelyPointRep relyPointRep;
   @Autowired
   DeliveryRep deliveryRep;
   @Override
   public void ajouterRelyPoint(RelyPoint p)
   {
      relyPointRep.save(p);
   }

   @Override
   public RelyPoint modifierRelyPoint(RelyPoint p, int idRp) {
      Optional<RelyPoint> modif=relyPointRep.findById(idRp);
      if (modif.isPresent())
      {
         RelyPoint r = modif.get();
         r.setAddress(p.getAddress());
         r.setName(p.getName());
         r.setDescription(p.getDescription());
         return relyPointRep.save(r);

      }else {
         throw new NoSuchElementException("Rely not found. ");
      }
   }

   @Override
   public void supprimerRelyPoint(int idRp)
   {
      relyPointRep.deleteById(idRp);
   }

   public List<RelyPoint> affichageAllRely()
   {
      return (List<RelyPoint>) relyPointRep.findAll();
   }

   public RelyPoint afficheRely (Integer  idRp)
   {
      return relyPointRep.findById(idRp).orElse(null);
   }

   @Override
   public Long countD() {
      return deliveryRep.count();
   }

   @Override
   public List<RelyPoint> findByAddress(String ad) {
      return relyPointRep.findAllByAddress(ad);
   }
}
