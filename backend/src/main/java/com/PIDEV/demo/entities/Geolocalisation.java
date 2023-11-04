package com.PIDEV.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Geolocalisation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String localistaion;

    private Integer idProduct;
    @ManyToOne
    @JoinColumn(name = "idW")
    private Warehouse warehouse;

}
