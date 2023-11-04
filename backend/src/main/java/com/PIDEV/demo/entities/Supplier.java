package com.PIDEV.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Supplier extends User {

    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="supplier")
    private Set<Warehouse> warehouses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="supplier")
    private Set<Suggestion> Suggestions;

}
