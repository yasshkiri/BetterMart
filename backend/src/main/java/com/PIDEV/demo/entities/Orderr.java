package com.PIDEV.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Orderr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idOrd;
    private  String refer;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateOrder ;
    @PrePersist
    private void onCreate(){
        dateOrder= new Date();
    }
    //
    private String state;

    private String mail;


    @ManyToOne
    private  Delivery delivery;

    @OneToOne
    //@JsonIgnore:ajouter jsonignore seulement dans cette entite
    //si je veux afficher les details de odrder,lignecommande,delivery,facture
    private Facture facture;

   @OneToMany(cascade = CascadeType.ALL, mappedBy="orderr")
   @JsonIgnore
    private Set<CommandLigne> CommandLignes;

   @ManyToOne
    private Customer customer;

}
