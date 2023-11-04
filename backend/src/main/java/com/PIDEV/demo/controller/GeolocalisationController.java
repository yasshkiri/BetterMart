package com.PIDEV.demo.controller;

import com.PIDEV.demo.entities.Geolocalisation;
import com.PIDEV.demo.services.GeolocalisationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GeolocalisationController {
    @Autowired
    GeolocalisationService geolocalisationService;


    @PostMapping("/addGeolocalisation")
    public Geolocalisation addGeolocalisation(@Valid @RequestBody Geolocalisation p) {
        return geolocalisationService.addGeolocalisation(p);
    }

    @GetMapping("/getAllGeolocalisation")
    public List<Geolocalisation> getAllGeolocalisations() {
        return geolocalisationService.getAllGeolocalisations();

    }

    @GetMapping("/getGeolocalisationByProductName/{productName}")
    public List<Geolocalisation> getGeolocalisationByProductName(@PathVariable("productName") String productName){
        return geolocalisationService.getAllGeolocalisationsByProductName(productName) ;

    }


    @GetMapping("/getGeolocalisation/{IdGeolocalisation}")
    @ResponseBody
    public Geolocalisation getGeolocalisationById(@PathVariable("IdGeolocalisation") int idGeolocalisation) {
        return geolocalisationService.getGeolocalisationById(idGeolocalisation);
    }

    @DeleteMapping("/deleteGeolocalisation/{idGeolocalisation}")
    @ResponseBody
    void deleteGeolocalisation(@PathVariable("idGeolocalisation") int idGeolocalisation) {
        geolocalisationService.deleteGeolocalisation(idGeolocalisation);
    }

    @PutMapping("/modifyGeolocalisationByID/{idGeolocalisation}")
    @ResponseBody
    public Geolocalisation ModifyGeolocalisationById(@PathVariable("idGeolocalisation") int idGeolocalisation, @RequestBody Geolocalisation Geolocalisation) {
        return geolocalisationService.updateGeolocalisationById(Geolocalisation, idGeolocalisation);
    }
}
