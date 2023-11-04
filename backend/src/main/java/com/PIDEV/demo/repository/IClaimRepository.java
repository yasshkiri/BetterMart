package com.PIDEV.demo.repository;

import com.PIDEV.demo.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClaimRepository  extends JpaRepository<Claim,Integer> {
 //  @Query("SELECT COUNT(c) FROM Claim c JOIN c.delivery d JOIN d.deliverer u WHERE u.id = :id")
   // Integer countByDelivererId(@Param("id") Integer id);

    @Query("select r from Claim r where r.etat=true ")
    List<Claim> reclamationsTraitees();

    @Query("select r from Claim r where r.etat=false")
    List<Claim> reclamationsNonTratitees();

    @Query("select r from Claim r where r.etat=?1")
    List<Claim> findReclamationByEtat();


    //affichage avec tri par date
    @Query("SELECT claim from Claim claim"+
            "   GROUP BY (claim.idClaim)"+
            "   ORDER BY (claim.dateC) DESC ")
    List<Claim> triPub();







}







