package com.PIDEV.demo.repository;


import com.PIDEV.demo.entities.Facture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRep extends CrudRepository<Facture,Integer> {



}
