package com.PIDEV.demo.repository;

import com.PIDEV.demo.entities.Geolocalisation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGeolocalisationRepository extends JpaRepository<Geolocalisation, Integer> {
List<Geolocalisation> findAllByIdProduct(Integer productId);
}
