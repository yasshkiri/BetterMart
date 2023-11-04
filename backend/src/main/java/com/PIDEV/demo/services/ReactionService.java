package com.PIDEV.demo.Service;



import com.PIDEV.demo.Repository.ReactionRepository;
import com.PIDEV.demo.entities.Comment;
import com.PIDEV.demo.entities.Customer;
import com.PIDEV.demo.entities.Publication;
import com.PIDEV.demo.entities.Reaction;
import com.PIDEV.demo.repository.CommentRepository;
import com.PIDEV.demo.repository.CustomerRepository;
import com.PIDEV.demo.repository.PublicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class ReactionService implements com.PIDEV.demo.Service.IReactionService {

    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ReactionRepository reactionRepository;



    // ajouter et affecter like to pub to user
    @Transactional
    @Override
    public void addReactionToPublication(Integer id, Integer idPub, Integer reaction) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        Publication publication = publicationRepository.findById(idPub)
                .orElseThrow(() -> new IllegalArgumentException("Publication not found"));
        if (reaction == 0 || reaction == 1) {
            Reaction existingReaction = reactionRepository.findByCustomerAndPublication(customer, publication);
            if (existingReaction != null) {
                // If the customer has already reacted to the publication, update the existing reaction
                existingReaction.setReaction(reaction);
                reactionRepository.save(existingReaction);
            } else {
                // If the customer has not yet reacted to the publication, create a new reaction
                Reaction newReaction = new Reaction();
                newReaction.setReaction(reaction);
                newReaction.setCustomer(customer);
                newReaction.setPublication(publication);
                reactionRepository.save(newReaction);
            }
        } else {
            // Handle invalid reaction value
            throw new IllegalArgumentException("Invalid reaction value");
        }
    }



    // ajouter et affecter like to com to user
    @Transactional
    @Override
    public void addReactionToComment(Integer id, Integer idCom, Integer reaction) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        Comment comment = commentRepository.findById(idCom)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        if (reaction == 0 || reaction == 1) {
            Reaction existingReaction = reactionRepository.findByCustomerAndComment(customer, comment);
            if (existingReaction != null) {
                // If the customer has already reacted to the comment, update the existing reaction
                existingReaction.setReaction(reaction);
                reactionRepository.save(existingReaction);
            } else {
                // If the customer has not yet reacted to the comment, create a new reaction
                Reaction newReaction = new Reaction();
                newReaction.setReaction(reaction);
                newReaction.setCustomer(customer);
                newReaction.setComment(comment);
                reactionRepository.save(newReaction);
            }
        } else {
            // Handle invalid reaction value
            throw new IllegalArgumentException("Invalid reaction value");
        }
    }



    public List<Publication> getPublicationsByReaction() {
        List<Publication> publications = publicationRepository.findAll();
        publications.sort((p1, p2) -> {
            int p1Count = reactionRepository.countByPublicationAndReaction(p1, 1);
            int p2Count = reactionRepository.countByPublicationAndReaction(p2, 1);
            return Integer.compare(p2Count, p1Count);
        });
        return publications;


    }



    }

