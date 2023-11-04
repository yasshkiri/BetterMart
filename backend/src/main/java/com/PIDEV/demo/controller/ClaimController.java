package com.PIDEV.demo.controller;

import com.PIDEV.demo.entities.Claim;
import com.PIDEV.demo.services.ClaimServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pi")

public class ClaimController {
    @Autowired
    private ClaimServicesImpl claimServicesImpl;


  //  http://localhost:8888/pidev/pi/addC
     @PostMapping("/addC")
     @ResponseBody
    public Claim addClaim(@RequestBody Claim claim){

    return claimServicesImpl.addClaim(claim);
    }

   // http://localhost:8888/pidev/pi/{{id}}
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        claimServicesImpl.deleteClaim(id);
        return "redirect:/claims";
    }

   // http://localhost:8888/pidev/pi/claims
    @GetMapping("/claims")
    public List<Claim> fetchClaimList()
    {
        return claimServicesImpl.fetchClaimList();
    }

   // http://localhost:8888/pidev/pi/update/{{id}}
    @PutMapping("/update/{id}")
    public ResponseEntity<Claim> updatePost(@PathVariable Integer id, @RequestBody Claim claim) {
        Optional<Claim> existingPost = claimServicesImpl.getPostById(id);
        if (existingPost.isPresent()) {
            claim.setIdClaim(id);
            claimServicesImpl.updatePost(claim);
            return ResponseEntity.ok(claim);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   // http://localhost:8888/pidev/pi/delete
    @DeleteMapping("/delete")
    public String delete() {
        claimServicesImpl.delete();
        return "La liste des réclamations a été supprimée";
    }



    //ajouter et affecter claim to user about the web app
    // http://localhost:8888/pidev/pi/addAndassignCLaimtoUser/{{id}}
    @PutMapping(value="/addAndassignCLaimtoUser/{id}")
    public void addAndassignClaimtoUser(@RequestBody Claim claim, @PathVariable("id")Integer id){
        claimServicesImpl.addAndassignClaimtoUser(claim,id);
    }


    //ajouter et affecter claim to user to delivery
   // http://localhost:8888/pidev/pi/addAndAssignClaimToDeliveryToUser/{{idD}}
    @PutMapping("/addAndAssignClaimToDeliveryToUser/{idD}/{id}")
    public void addAndAssignClaimToDeliveryToUser(@RequestBody Claim claim, @PathVariable("idD") Integer idD,@PathVariable("id") Integer id){
        claimServicesImpl.addAndAssignClaimToDeliveryToUser(claim,idD,id);
    }



    //ajouter et affecter claim to user to publication
   // hhttp://localhost:8888/pidev/pi/addAndAssignClaimToPubToUser/{{idPub}}/{{id}}
    @PutMapping("/addAndAssignClaimToPubToUser/{idPub}/{id}")
    public void addAndAssignClaimToPubToUser(@RequestBody Claim claim, @PathVariable("idPub") Integer idPub, @PathVariable("id") Integer id){
        claimServicesImpl.addAndAssignClaimToPubToUser(claim, idPub,id);
    }



    //ajouter et affecter claim to user to ComLigne
    //http://localhost:8888/pidev/pi/addAndAssignClaimToComLignToUser/{{idComLign}}/{{id}}
    @PutMapping("/addAndAssignClaimToComLignToUser/{idComLign}/{id}")
    public void addAndAssignClaimToComLignToUser(@RequestBody Claim claim, @PathVariable("idComLign") Integer idComLign, @PathVariable("id") Integer id){
        claimServicesImpl.addAndAssignClaimToComLignToUser(claim, idComLign,id);
    }

    //affiche les reclamations traités(etat=true)
   // http://localhost:8888/pidev/pi/listeReclamationsTraitees
    @GetMapping("listeReclamationsTraitees")
    public List<Claim> listeReclamationsTraitees(){
        List<Claim> liste =claimServicesImpl.listeReclamationsTratitees();
        return liste;
    }

    //affiche les reclamations traités(etat=false)
  //  http://localhost:8888/pidev/pi/listeReclamationsNonTraitees
    @GetMapping("listeReclamationsNonTraitees")
    public List<Claim> listeReclamationsNonTraitees(){
        List<Claim> liste =claimServicesImpl.listeReclamationsNonTratitees();
        return liste;
    }
   //Admin change reclamation etat (false -> true)
   // http://localhost:8888/pidev/pi/RecTrue/{{id}}
    @PutMapping("RecTrue/{id}")
    public  void TraiterRec(@PathVariable("id") Integer idClaim,@RequestBody Claim  reclamation){
        claimServicesImpl.traiterRec(idClaim, reclamation);
    }



    //affichage avec tri par date
    //http://localhost:8888/pidev/pi/triPub
    @GetMapping("/triPub")
    List<Claim> triPub(){return claimServicesImpl.triPub();
    }








}
