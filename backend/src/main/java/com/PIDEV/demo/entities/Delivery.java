package com.PIDEV.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Delivery implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idD;
    private String reference;



    @Temporal(TemporalType.DATE)
    private Date  date;



    @ManyToOne
    private Deliverer deliverer;


    @ManyToOne
    private RelyPoint relyPoint;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="delivery")
    private Set<Orderr> orders;




    public Delivery(int idd, String reference, java.sql.Date date) {
        this.idD = idd;
        this.reference = reference;
        this.date = date;
    }
}
