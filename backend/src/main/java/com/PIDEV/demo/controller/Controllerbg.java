package com.PIDEV.demo.controller;


import com.PIDEV.demo.entities.Delivery;
import com.PIDEV.demo.entities.RelyPoint;
import com.PIDEV.demo.services.IDeliveryService;
import com.PIDEV.demo.services.IRelyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Controllerbg")
public class Controllerbg {



    IRelyService iRelyService;

    IDeliveryService iDeliveryService;


    //  http://localhost:8888/pidev/Controllerbg/ajouter-rely
    @PostMapping("/ajouter-rely")
    public void ajouterRelyPoint(@RequestBody RelyPoint p)
    {

        iRelyService.ajouterRelyPoint(p);
    }


    //  http://localhost:8888/pidev/Controllerbg/modifier-rely/idRp
    @PutMapping("/modifier-rely/{idRp}")
    @ResponseBody
    public RelyPoint modifierRelyPoint(@RequestBody RelyPoint p,  @PathVariable int idRp) {
        return iRelyService.modifierRelyPoint(p,idRp);

    }


    //  http://localhost:8888/pidev/Controllerbg/supprimer-rely/id_rp
    @DeleteMapping("/supprimer-rely/{idRp}")
    void supprimerRelyPoint(@PathVariable("idRp") int idRp) {
        iRelyService.supprimerRelyPoint(idRp);
    }



    // http://localhost:8888/pidev/Controllerbg/allRely
    @GetMapping("/allRely")
    public List<RelyPoint> getRely() {
        List<RelyPoint> listRely = iRelyService.affichageAllRely();
        return listRely;
    }

    // http://localhost:8888/pidev/Controllerbg/afficheIdRely/
    @GetMapping("/afficheIdRely/{idRp}")
    public RelyPoint afficheRely(@PathVariable("idRp") Integer idRp) {
        return iRelyService.afficheRely(idRp);
    }



    //////////////// *************Delivery**************** //////////////////////////

    //  http://localhost:8888/pidev/Controllerbg/supprimer-delivery/idD
    @DeleteMapping("/supprimer-delivery/{idD}")
    void supprimerDelivery(@PathVariable("idD") int idD)
    {
        iDeliveryService.supprimerDelivery(idD);
    }


    //  http://localhost:8888/pidev/Controllerbg/ajouter-delivery
    @PostMapping("/ajouter-delivery")
    public void ajouterDelivery (@RequestBody Delivery d)
    {
        iDeliveryService.ajouterDelivery(d);
    }


    // http://localhost:8888/pidev/Controllerbg/modifier-delivery/idD
    @PutMapping("/modifier-delivery")
    @ResponseBody
    public Delivery modifierRelyPoint( @RequestBody Delivery d) {
      return   iDeliveryService.modifierDelivery(d);
    }

    // http://localhost:8888/pidev/Controllerbg/allDelivery
    @GetMapping("/allDelivery")
    public List<Delivery> getDelivery() {
        List<Delivery> listDe = iDeliveryService.affichageAll();
        return listDe;
    }

    // http://localhost:8888/pidev/Controllerbg/afficheDelivery/idD
    @GetMapping("/afficheDelivery/{idD}")
    public Delivery afficheDelivery (@PathVariable("idD") Integer idD)
    {
        return iDeliveryService.afficheDelivery(idD);
    }




    //  http://localhost:8888/pidev/Controllerbg/affecter-Rely/idD/IdRp
    @PutMapping(value="/affecter-Rely/{idD}/{IdRp}")
    public void AffecterPointRely (@PathVariable("idD") Integer idD, @PathVariable("IdRp")Integer IdRp){
        iDeliveryService.AffecterPointRely(idD,IdRp);
    }

    //  http://localhost:8888/pidev/Controllerbg/affecter-Deliverer/idD/id
    @PutMapping(value="/affecter-Deliverer/{idD}/{id}")
    public void AffecterDeliverer (@PathVariable("idD") Integer idD, @PathVariable("id")Integer id){
      iDeliveryService.AffecterDeliverer(idD,id);
    }

    // http://localhost:8888/pidev/Controllerbg/disponibles
    @GetMapping("/disponibles")
    public int nbrLivreursDisponibles() {
       int DD =  iDeliveryService.getLivreursDisponibles();
        return DD;
    }

    //  http://localhost:8888/pidev/Controllerbg/searchDeliveryByReference/reference
    @GetMapping("/searchDeliveryByReference/{reference}")
    public int searchDeliveryByReference( @PathVariable("reference") String reference){
        return iDeliveryService.searchDeliveryByReference(reference);
    }




  //  http://localhost:8888/pidev/Controllerbg/countD
    @GetMapping("/countD")
    public Long CountD( ){
        return iRelyService.countD();
    }


    //  http://localhost:8888/pidev/Controllerbg/findOneByAddress/
    @GetMapping("/findOneByAddress/{ad}")
    public double findOneByAddress(@PathVariable String ad  ){
        Long total = iRelyService.countD();
        int totalint = total.intValue();
        int nbadr = iRelyService.findByAddress(ad).size();
        int c = totalint*nbadr ;
        double t = (c * 0.01) ;
        return t ;
        //return iRelyService.findByAddress(ad);
    }

}


