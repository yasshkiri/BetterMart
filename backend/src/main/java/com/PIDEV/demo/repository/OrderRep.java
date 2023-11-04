package com.PIDEV.demo.repository;





import com.PIDEV.demo.entities.Orderr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRep extends CrudRepository<Orderr,Integer> {
    /*@Query("select o from Orderr o where o.dateOrder<:d")
    List<Orderr> FindOrders(Date d);*/
    List<Orderr> findByDateOrderLessThan(Date d);

}
