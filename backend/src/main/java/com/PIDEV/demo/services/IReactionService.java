package com.PIDEV.demo.Service;

import com.PIDEV.demo.entities.Comment;
import com.PIDEV.demo.entities.Reaction;

import javax.transaction.Transactional;

public interface IReactionService {
    @Transactional
    void addReactionToPublication(Integer id, Integer idPub, Integer reaction);

    // ajouter et affecter like to com to user
    @Transactional
    void addReactionToComment(Integer id, Integer idCom, Integer reaction);

  /*  @Transactional
    void addReactionToPublication(Integer idPub, Integer id, Integer reaction);*/
}
