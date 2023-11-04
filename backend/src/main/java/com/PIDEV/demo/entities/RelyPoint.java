package com.PIDEV.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RelyPoint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idRp;
    private String name;
    private String description;
    private String address;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="relyPoint")
    private Set<Delivery> deliveries;

}
