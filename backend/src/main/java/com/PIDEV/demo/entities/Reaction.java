package com.PIDEV.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idReact;
    private Integer reaction;

    @JsonIgnore
    @ManyToOne
    private Customer customer;
    //à ajouter
    @JsonIgnore
    @ManyToOne
    private Publication publication;
    //à ajouter
    @JsonIgnore
    @ManyToOne
    private Comment comment;
}
