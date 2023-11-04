package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.Comment;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ICommentService {
    public Comment addCom(Comment comment);
    List<Comment> fetchCommentList();
    Comment getCommentById(Integer id);

    Comment updateCom(Comment comment);
    void deleteCom();
    void deleteComById(Integer id);

    Optional<Comment> getComById(Integer id);


   /* @Transactional
    Comment addAndassignComToPub(Comment comment, Integer idPub);
    */

    @Transactional
    Comment AddandAssignComtoPubtoUser(Comment comment, Integer idPub, Integer id);

    List<Comment> triCom();
}
