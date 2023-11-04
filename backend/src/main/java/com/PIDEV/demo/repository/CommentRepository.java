package com.PIDEV.demo.repository;


import com.PIDEV.demo.entities.Comment;
import com.PIDEV.demo.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("SELECT comment from Comment comment"+
            "   GROUP BY (comment.idCom)"+
            "   ORDER BY (comment.dateCom) DESC ")
    List<Comment> triCom();


}
