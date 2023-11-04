package com.PIDEV.demo.repository;

import com.PIDEV.demo.entities.PurchaseOrder;
import com.PIDEV.demo.entities.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Integer> {


    @Query("SELECT s FROM Suggestion s WHERE s.dure BETWEEN :startDate AND :endDate")
    List<Suggestion> findSuggestionBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
