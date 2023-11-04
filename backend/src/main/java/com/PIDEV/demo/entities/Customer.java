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
public class Customer extends User {

    private int points;
    private int cin;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
    private Set<PurchaseOrder> PurchaseOrders;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
    private Set<Reaction> Reactions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
    private Set<Orderr> Orders;
}
