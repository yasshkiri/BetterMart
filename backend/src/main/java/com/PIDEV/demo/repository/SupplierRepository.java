package com.PIDEV.demo.repository;

import com.PIDEV.demo.entities.Customer;
import com.PIDEV.demo.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
