package com.PIDEV.demo.repository;



import com.PIDEV.demo.entities.RelyPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelyPointRep extends CrudRepository<RelyPoint,Integer> {

    public List<RelyPoint> findAll();
    List<RelyPoint> findAllByAddress(String ad);

}
