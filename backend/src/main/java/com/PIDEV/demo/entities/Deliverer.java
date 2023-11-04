package com.PIDEV.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Deliverer extends User  {


    private int dispo;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="deliverer")
    private Set<Delivery> Deliveries;


}
