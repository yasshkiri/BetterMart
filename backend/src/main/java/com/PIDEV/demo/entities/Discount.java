package com.PIDEV.demo.entities;

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
public class Discount  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idDiscount;
    //à supprimer
    private Integer code;
    private float amountCode;
    private String descriptionD;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;


    @OneToMany( mappedBy="discount")
    private Set<Product> products;
}
