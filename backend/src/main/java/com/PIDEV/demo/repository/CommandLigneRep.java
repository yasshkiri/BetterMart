package com.PIDEV.demo.repository;

import com.PIDEV.demo.entities.CommandLigne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandLigneRep extends CrudRepository<CommandLigne, Integer> {

    @Query("select c from CommandLigne c where c.product.idProduct=:idp")
    CommandLigne findProduct(int idp);

    @Query("select sum(c.price) from CommandLigne c where c.orderr.idOrd=:ido")
    float findOrder(int ido);
}
