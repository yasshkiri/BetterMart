package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.Geolocalisation;


import java.util.List;


public interface GeolocalisationService {
	Geolocalisation addGeolocalisation(Geolocalisation g);
	Geolocalisation getGeolocalisationById(int idGeolocalisation);
	List<Geolocalisation> getAllGeolocalisations();

	List<Geolocalisation> getAllGeolocalisationsByProductName(String productName);
	 void deleteGeolocalisation(int idGeolocalisation);
	 Geolocalisation updateGeolocalisationById(Geolocalisation product, int idGeolocalisation);

}
