package com.PIDEV.demo.repository;

import com.PIDEV.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
   Optional<Product> findByName(String name) ;
}
