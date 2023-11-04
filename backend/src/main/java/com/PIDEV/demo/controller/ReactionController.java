package com.PIDEV.demo.Controller;




import com.PIDEV.demo.Repository.ReactionRepository;
import com.PIDEV.demo.Service.IReactionService;
import com.PIDEV.demo.entities.Comment;
import com.PIDEV.demo.entities.Publication;
import com.PIDEV.demo.entities.Reaction;
import com.PIDEV.demo.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/pidev")
public class ReactionController {


    @Autowired
    IReactionService reactionService;

    @Autowired
    ReactionRepository reactionRepository;

    @Autowired
    PublicationRepository publicationRepository;







    /*@PostMapping(value = "/addReactionToPublication/{id}/{idPub}")
    public void addReactionToPublication(@PathVariable Integer id, @PathVariable Integer idPub, @RequestBody Integer reaction) {
        reactionService.addReactionToPublication(id, idPub, reaction);
    }

     */

    @PostMapping("/publications/{idPub}/reactions/{id}")
    public ResponseEntity<Void> addReactionToPublication(
            @PathVariable Integer id,
            @PathVariable Integer idPub,
            @RequestParam Integer reaction) {

        reactionService.addReactionToPublication(id, idPub, reaction);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/customers/{id}/comments/{idCom}")
    public ResponseEntity<Void> addReactionToComment(@PathVariable Integer id, @PathVariable Integer idCom, @RequestParam Integer reaction) {
        reactionService.addReactionToComment(id, idCom, reaction);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/publications/reactions")
    public List<Publication> getPublicationsByReaction() {
        List<Publication> publications = publicationRepository.findAll();
        publications.sort((p1, p2) -> {
            int p1Count = reactionRepository.countByPublicationAndReaction(p1, 0);
            int p2Count = reactionRepository.countByPublicationAndReaction(p2, 0);
            return Integer.compare(p2Count, p1Count);
        });
        return publications;
    }














}
