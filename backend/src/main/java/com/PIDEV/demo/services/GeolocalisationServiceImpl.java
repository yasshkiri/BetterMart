package com.PIDEV.demo.services;


import com.PIDEV.demo.entities.Geolocalisation;
import com.PIDEV.demo.entities.Product;
import com.PIDEV.demo.repository.IGeolocalisationRepository;
import com.PIDEV.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeolocalisationServiceImpl implements GeolocalisationService{

	 @Autowired
	 IGeolocalisationRepository iGeolocalisationRepository;

	 @Autowired
	 ProductRepository iPorudctRepository;
	
	@Override
	public Geolocalisation addGeolocalisation(Geolocalisation g) {
		
		return iGeolocalisationRepository.save(g);
	}


	@Override
	public Geolocalisation getGeolocalisationById(int idGeolocalisation) {
		return  iGeolocalisationRepository.findById(idGeolocalisation).orElse(null);
	}

	@Override
	public List<Geolocalisation> getAllGeolocalisations() {
		return iGeolocalisationRepository.findAll();
	}

	@Override
	public List<Geolocalisation> getAllGeolocalisationsByProductName(String productName) {
		Optional<Product> product=iPorudctRepository.findByName(productName);
		if(product.isPresent())
		return iGeolocalisationRepository.findAllByIdProduct(product.get().getIdProduct());
		else return null;
	}


	@Override
	public void deleteGeolocalisation(int idGeolocalisation) {
       iGeolocalisationRepository.deleteById(idGeolocalisation);		
	}


	@Override
	public Geolocalisation updateGeolocalisationById(Geolocalisation geolocalisation, int idGeolocalisation) {
		Geolocalisation found= iGeolocalisationRepository.findById(idGeolocalisation).orElse(null);
		found.setLocalistaion(geolocalisation.getLocalistaion());
		found.setWarehouse(geolocalisation.getWarehouse());
		iGeolocalisationRepository.saveAndFlush(found);
		return found;
	}

}
