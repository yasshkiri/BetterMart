package com.PIDEV.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Comment  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCom;

    private LocalDateTime dateCom;
    private String imageCom;
    private String com;

    @JsonIgnore
    @ManyToOne
    private Publication publication;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reaction> reactions;

}
