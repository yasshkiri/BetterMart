package com.PIDEV.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Facture  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer idF;
    private  String ref;
    private float totale;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateFac ;

    @PrePersist
    private void onCreate(){
        dateFac= new Date();
    }

    @OneToOne(mappedBy="facture")
    @JsonIgnore //ajouter ici si je veur afficher seulement facture (id,refer,date)
    private Orderr orderr;



}
