package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.Customer;
import com.PIDEV.demo.entities.Discount;
import com.PIDEV.demo.entities.PurchaseOrder;
import com.PIDEV.demo.repository.CustomerRepository;
import com.PIDEV.demo.repository.DiscountRepository;
import com.PIDEV.demo.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PurchaseOrderService implements IPurchaseOrderService {
    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    CustomerRepository customerRepository;

    //à revoir
    public PurchaseOrder ajouterDemandeAchat(PurchaseOrder purchaseOrder, Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        System.err.println(customer.getId());
        purchaseOrder.setCustomer(customer);
        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> searchPurByProductName(String query) {

            return purchaseOrderRepository.rechercheParNomProduit(query);

    }


    @Override
    public void addPurchaseOrder(PurchaseOrder purchase) {
        purchaseOrderRepository.save(purchase);

    }

    @Override
    public List<PurchaseOrder> retrieveAllPurchaseOrders() {
        return (List<PurchaseOrder>) purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder retrievePurchaseOrder(Integer purchaseId) {

        return purchaseOrderRepository.findById(purchaseId).orElse(null);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchase) {

        return purchaseOrderRepository.save(purchase);
    }

    @Override
    public void removePurchaseOrder(Integer idPurchase) {
        PurchaseOrder p=retrievePurchaseOrder(idPurchase);
        purchaseOrderRepository.delete(p);

    }
}
