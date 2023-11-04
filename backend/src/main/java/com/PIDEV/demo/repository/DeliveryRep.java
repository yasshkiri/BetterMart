package com.PIDEV.demo.repository;



import com.PIDEV.demo.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRep extends JpaRepository<Delivery, Object> {

    public List<Delivery> findAll();

    @Query("SELECT count(d.deliverer.id) FROM Delivery d WHERE d.deliverer.dispo =:dispo ")
     int findByDisponible(int dispo);

    @Query("select idD from  Delivery  where reference= ?1 ")
    int findByReference(String reference );
    long count();

}
