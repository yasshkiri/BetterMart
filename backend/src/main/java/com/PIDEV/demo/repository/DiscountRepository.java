package com.PIDEV.demo.repository;

import com.PIDEV.demo.entities.Discount;
import com.PIDEV.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {

    @Query("SELECT p FROM Product p JOIN p.discount d WHERE d.idDiscount = :discountId")
    List<Product> findProductsByDiscountId(@Param("discountId") Integer discountId);



}
