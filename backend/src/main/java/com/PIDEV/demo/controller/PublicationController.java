package com.PIDEV.demo.controller;

import com.PIDEV.demo.entities.Publication;
import com.PIDEV.demo.services.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pidev")
public class PublicationController {

    @Autowired
    IPublicationService publicationService;

    @PostMapping("/addPub")
    @ResponseBody

    public Publication addPub(@RequestBody Publication publication) {

        publicationService.addPub(publication);

        return publication;
    }

    @GetMapping("/listPub")
    public List<Publication> fetchPublicationList() {

        return publicationService.fetchPublicationList();
    }

    @GetMapping("listCPubById/{id}")
    public ResponseEntity<Publication> getPublicationById(@PathVariable Integer id) {
        Publication publication = publicationService.getPublicatioById(id);
        return ResponseEntity.ok(publication);
    }

    @GetMapping("/triPub")
    List<Publication> triPub(){
        return publicationService.triPub();
    }

    @PutMapping("/updatePub/{id}")
    public ResponseEntity<Publication> updatePub(@PathVariable Integer id, @RequestBody Publication publication) {
        Optional<Publication> existingPost = publicationService.getPubById(id);
        if (existingPost.isPresent()) {
            publication.setIdPub(id);
            publicationService.updatePub(publication);
            return ResponseEntity.ok(publication);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping("/delete")
    public String delete() {
        publicationService.delete();
        return "La liste des publications a été supprimée";
    }


    @DeleteMapping("deletePub/{id}")
    public String deletePub(@PathVariable Integer id) {
        publicationService.deletePub(id);
        return "La Publication a été supprimée";
    }

    //ajouter&affecter
    @PutMapping(value="/addAndassignPubtoUser/{id}")
    public void addAndassignPubtoUser(@RequestBody Publication publication, @PathVariable("id")Integer id){
        publicationService.addAndassignPubtoUser(publication,id);
    }









}
