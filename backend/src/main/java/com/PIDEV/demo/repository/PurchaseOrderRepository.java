package com.PIDEV.demo.repository;


import com.PIDEV.demo.entities.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {

    @Query("SELECT p from PurchaseOrder p WHERE " +

            " p.productName LIKE CONCAT('%',:query, '%')")

    List<PurchaseOrder> rechercheParNomProduit(String query);
}
