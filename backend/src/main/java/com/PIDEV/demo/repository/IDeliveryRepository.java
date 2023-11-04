package com.PIDEV.demo.repository;


import com.PIDEV.demo.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery,Integer> {



}
