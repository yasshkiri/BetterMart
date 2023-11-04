package com.PIDEV.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idProduct;

    private String referance;
    @NotNull(message = "Le champ ne doit pas etre null")
    private String name;
    private float price;
    private  String descrp;
    private  String category;
    private  int quantite;
    @Min(value = 0, message = "Le rating doit être supérieur ou égal à 0")
    @Max(value = 5, message = "Le rating doit être inférieur ou égal à 5")
    private int rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="product")
    private Set<CommandLigne> CommandLignes;

    //orderitem
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH)
    private Discount discount;

    @ManyToOne
    private Warehouse warehouse;


}
