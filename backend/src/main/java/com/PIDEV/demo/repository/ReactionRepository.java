package com.PIDEV.demo.Repository;

import com.PIDEV.demo.entities.Comment;
import com.PIDEV.demo.entities.Customer;
import com.PIDEV.demo.entities.Publication;
import com.PIDEV.demo.entities.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction, Integer> {

   @Query("SELECT r FROM Reaction r WHERE r.customer = :customer AND r.publication = :publication")
   Reaction findByCustomerAndPublication(@Param("customer") Customer customer, @Param("publication") Publication publication);

   @Query("SELECT r FROM Reaction r WHERE r.customer = :customer AND r.comment = :comment")
   Reaction findByCustomerAndComment(@Param("customer") Customer customer, @Param("comment") Comment comment);

   //int countByPublicationAndReaction(Publication publication, int reaction);
   @Query("SELECT COUNT(r) FROM Reaction r WHERE r.publication = :publication AND r.reaction = :reaction")
   int countByPublicationAndReaction(@Param("publication") Publication publication, @Param("reaction") int reaction);

}
