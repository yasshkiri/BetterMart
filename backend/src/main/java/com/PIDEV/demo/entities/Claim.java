package com.PIDEV.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Claim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idClaim;
    @Temporal(TemporalType.DATE)
    private Date dateC;
    private String descriptionC;
    private String productType;
    private String claimType;
    private Boolean etat =false;

    @ManyToOne(cascade = CascadeType.ALL)
    private Delivery delivery;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    private CommandLigne CommandLigness;


    @ManyToOne
    private Publication publication;


}
