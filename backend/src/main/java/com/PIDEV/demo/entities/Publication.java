package com.PIDEV.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Publication implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPub;

    private LocalDateTime datePub;
    private String imagePub;
    private String pub;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="publication")
    private Set<Claim> claims;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="publication")
    private Set<Comment> comments;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reaction> reactions;





}
