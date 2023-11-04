package com.PIDEV.demo.controller;

import com.PIDEV.demo.entities.*;
import com.PIDEV.demo.services.DiscountService;
import com.PIDEV.demo.services.IDiscountService;
import com.PIDEV.demo.services.IPurchaseOrderService;
import com.PIDEV.demo.services.ISuggestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class PiController {


    @Autowired
    IDiscountService discountService;
    @Autowired
    IPurchaseOrderService purchaseOrderService;
    @Autowired
    ISuggestionService suggestionService;

    @PostMapping("/addDiscount")
    public void ajouterData(@RequestBody Discount discount) {
        discountService.ajouterDiscount(discount);
    }

    @GetMapping("/retrieve-all-discounts")
    public List<Discount> getContrats() {
        List<Discount> listDiscounts = discountService.retrieveAllDiscounts();
        return listDiscounts;
    }

    @GetMapping("/retrieve-dicount/{discount-id}")
    public Discount retrieveDiscount(@PathVariable("discount-id") Integer discountId) {
        return discountService.retrieveDiscount(discountId);
    }

    @PutMapping("/update-discount")
    public Discount updateDiscount(@RequestBody Discount d) {
        Discount discount = discountService.updateDiscount(d);
        return discount;
    }

    @DeleteMapping("/remove-discount/{discount-id}")
    public void removeDiscount(@PathVariable("discount-id") Integer discountId) {
        discountService.removeDiscount(discountId);
    }

    @PutMapping(value="/affecter-discount-product/{productId}")
    public void affecterDiscountToProduct(@RequestBody Discount d, @PathVariable("productId")Integer productId){
        discountService.addAndassignDiscountToProduct(d,productId);
    }


    @PostMapping("/add-purchase")
    public void ajouterData(@RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrderService.addPurchaseOrder(purchaseOrder);
    }

    @GetMapping("/retrieve-all-purchaseOrders")
    public List<PurchaseOrder> getPurchaseOrders() {
        List<PurchaseOrder> listPurchaseOrders = purchaseOrderService.retrieveAllPurchaseOrders();
        return listPurchaseOrders;
    }

    @GetMapping("/retrieve-purchaseOrder/{purchaseOrder-id}")
    public PurchaseOrder retrievePurchaseOrder(@PathVariable("purchaseOrder-id") Integer purchaseOrderId) {
        return purchaseOrderService.retrievePurchaseOrder(purchaseOrderId);
    }

    @PutMapping("/update-purchaseOrder")
    public PurchaseOrder updatePurchaseOrder(@RequestBody PurchaseOrder p) {
        PurchaseOrder purchaseOrder = purchaseOrderService.updatePurchaseOrder(p);
        return purchaseOrder;
    }

    @DeleteMapping("/remove-purchaseOrder/{purchaseOrder-id}")
    public void removePurchaseOrder(@PathVariable("purchaseOrder-id") Integer purchaseOrderId) {
        purchaseOrderService.removePurchaseOrder(purchaseOrderId);
    }

    //fonction update par id
    @PutMapping("/updateDiscount/{id}")
    public ResponseEntity<Discount> updatePub(@PathVariable Integer id, @RequestBody Discount discount) {
        Optional<Discount> existingPost = discountService.getDiscountById(id);
        if (existingPost.isPresent()) {
            discount.setIdDiscount(id);
            discountService.updateDiscount(discount);
            return ResponseEntity.ok(discount);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //ajout purchase order et affectation au client à supprimer après
    @PostMapping("/{id}")
    public PurchaseOrder ajouterDemandeAchat(@RequestBody PurchaseOrder purchaseOrder, @PathVariable("id") Integer id) {
        return purchaseOrderService.ajouterDemandeAchat(purchaseOrder, id);
    }


    //discount pour la période de black friday

    @GetMapping("/bF")
    public List<Object[]> getSuggestionsDuringBlackFriday() throws ParseException {
        return  suggestionService.getSuggestionsDuringBlackFriday();
    }

    @PutMapping(value="/affecter-suggestion-purchase/{purchaseOrderId}/{id}")
    public void affecterDiscountToProduct(@RequestBody Suggestion s, @PathVariable("purchaseOrderId")Integer purchaseOrderId,@PathVariable("id")Integer id){
        suggestionService.addAndassignSuggestionToPurchaseOrder(s,purchaseOrderId,id);
    }

//rechercher product npar nom
    @GetMapping("search")
    List<PurchaseOrder> searchbyProductName( @RequestParam("query") String query){
        return purchaseOrderService.searchPurByProductName(query);
    }



    //List Product test jpql
    @GetMapping("getProduct/{discountId}")
    List<Product> getProduct(@PathVariable("discountId")Integer discountId){
        return discountService.getProduct(discountId);
    }

    //dicount of product
    @GetMapping("/Ds/{discountId}")
    public List<Object[]> getProductsAfterDiscount(@PathVariable("discountId")Integer discountId) throws ParseException {
        return  discountService.getProductsAfterDiscount(discountId);
    }


    @GetMapping("/smsTest/{id}")
    public void smsTest(@PathVariable ("id") Integer id)
    {
       /* User[] users =  discountService.getUsersBySupplier(supplierId)
           for(User user : users){
            this.smsService.send(new SmsPojo(user.email, "hi bitch"));
        }

        */



    }
}
