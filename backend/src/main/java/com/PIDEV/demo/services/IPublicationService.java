package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.Publication;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IPublicationService {

    Publication addPub(Publication publication);

     List<Publication> fetchPublicationList();

    Publication getPublicatioById(Integer id);

    Publication updatePub(Publication publication);

    Optional<Publication> getPubById(Integer id);

    void delete();
    void deletePub(Integer id);

    //ajouter&affecter
    @Transactional
    Publication addAndassignPubtoUser(Publication publication, Integer idCus);

    List<Publication> triPub();



    /*void assignPubToCom(Integer idPub, Integer idCom);*/

}
