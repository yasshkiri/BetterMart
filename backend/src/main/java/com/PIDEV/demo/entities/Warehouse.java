package com.PIDEV.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idW;

    private String reference ;
    private  int capacite ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="warehouse")
    private Set<Product> Products;

    @ManyToOne
    private Supplier supplier;
}
