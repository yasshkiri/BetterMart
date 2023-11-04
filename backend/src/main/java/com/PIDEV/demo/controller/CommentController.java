package com.PIDEV.demo.controller;

import com.PIDEV.demo.entities.Comment;
import com.PIDEV.demo.entities.Publication;
import com.PIDEV.demo.repository.CommentRepository;
import com.PIDEV.demo.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pidev")
public class CommentController {


    @Autowired
    ICommentService commentService;

    @Autowired
    CommentRepository commentRepository;



    //ajouter
    @PostMapping("/addCom")
    @ResponseBody

    public Comment addCom(@RequestBody Comment comment) {

        commentService.addCom(comment);

        return comment;
    }

     //affichage
    @GetMapping("/listCom")
    public List<Comment> fetchCommentList() {

        return commentService.fetchCommentList();
    }

    @GetMapping("listComById/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        Comment comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    //modifier
    @PutMapping("/updateCom/{id}")
    public ResponseEntity<Comment> updateCom(@PathVariable Integer id, @RequestBody Comment comment) {
        Optional<Comment> existingPost = commentService.getComById(id);
        if (existingPost.isPresent()) {
            comment.setIdCom(id);
            commentService.updateCom(comment);
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

     //supprimer
    @DeleteMapping("/deleteCom")
    public String deleteCom() {
        commentService.deleteCom();
        return "La liste des commentaires a été supprimée";
    }
    @DeleteMapping("deleteComById/{id}")
    public String deleteComById(@PathVariable Integer id) {
        commentService.deleteComById(id);
        return "Le commentaire a été supprimé";
    }

   /* //ajouter&affecter
    @PutMapping(value="/addAndassignComToPub/{idPub}")
    public void addAndassignComToPub(@RequestBody Comment comment, @PathVariable("idPub")Integer idPub){
        commentService.addAndassignComToPub(comment,idPub);
    }
      */
    @PutMapping(value="/AddandAssignComtoPubtoUser/{idPub}/{id}")
    public void AddandAssignComtoPubtoUser(@RequestBody Comment comment, @PathVariable("idPub")Integer idPub,@PathVariable("id")Integer id){
        commentService.AddandAssignComtoPubtoUser(comment,idPub,id);
    }


    @GetMapping("/triCom")
    List<Comment> triCom(){
        return commentService.triCom();
    }








}
