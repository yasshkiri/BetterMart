package com.PIDEV.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PurchaseOrder  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idDemand;
    private String productName;
    private String descriptionPO;
    private Integer quantityPO;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="purchaseOrder")
    private Set<Suggestion> Suggestions;

    @ManyToOne
    @JsonIgnore
    private Customer customer;
}
