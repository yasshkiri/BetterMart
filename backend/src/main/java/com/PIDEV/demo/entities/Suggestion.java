package com.PIDEV.demo.entities;

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
public class Suggestion  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idS;

    private float price;
    @Temporal(TemporalType.DATE)
    //changer le nom de l'attribut
    private Date dure;
    private String statue;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private PurchaseOrder purchaseOrder;

}
