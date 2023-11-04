package com.PIDEV.demo.services;


import com.PIDEV.demo.entities.Customer;
import com.PIDEV.demo.entities.Publication;
import com.PIDEV.demo.repository.CommentRepository;
import com.PIDEV.demo.repository.CustomerRepository;
import com.PIDEV.demo.repository.PublicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PublicationService implements IPublicationService {

    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Publication addPub(Publication publication) {


        publicationRepository.save(publication);

        return publication;

    }

    @Override
    public List<Publication> fetchPublicationList()
    {
        return publicationRepository.findAll();
    }

    @Override
    public Publication getPublicatioById(Integer id){
        return publicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }


    public Publication updatePub(Publication publication) {

        publicationRepository.save(publication);

        return publication;
    }


    public Optional<Publication> getPubById(Integer id) {

        return publicationRepository.findById(id);
    }


    public void delete() {

        publicationRepository.deleteAll();
    }

    @Override
    public void deletePub(Integer id) {

        publicationRepository.deleteById(id);
    }


    //ajouter&affecter
    @Transactional
    @Override
    public Publication addAndassignPubtoUser(Publication publication, Integer id) {

        Customer customer = customerRepository.findById(id).orElse(null);
        System.err.println(customer.getId());
        publication.setCustomer(customer);
        publication.setDatePub(LocalDateTime.now());
        return publicationRepository.save(publication);
    }



    @Override
    public List<Publication> triPub() {
        return publicationRepository.triPub();
    }



}
