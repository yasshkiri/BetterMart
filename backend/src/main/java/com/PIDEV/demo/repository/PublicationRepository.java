package com.PIDEV.demo.repository;

import com.PIDEV.demo.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {


    @Query("SELECT publication from Publication publication"+
            "   GROUP BY (publication.idPub)"+
            "   ORDER BY (publication.datePub) DESC ")
    List<Publication> triPub();



}
