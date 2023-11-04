package com.PIDEV.demo.repository;


import com.PIDEV.demo.entities.Deliverer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelivererRep extends CrudRepository<Deliverer,Integer> {


}
