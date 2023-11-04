package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.Discount;
import com.PIDEV.demo.entities.PurchaseOrder;

import java.util.List;

public interface IPurchaseOrderService {

    public void addPurchaseOrder(PurchaseOrder purchase);
    public List<PurchaseOrder> retrieveAllPurchaseOrders();
    PurchaseOrder retrievePurchaseOrder(Integer purchaseId);
    public PurchaseOrder updatePurchaseOrder (PurchaseOrder  purchase);
    public  void removePurchaseOrder(Integer idPurchase);
    public PurchaseOrder ajouterDemandeAchat(PurchaseOrder purchaseOrder, Integer id);



    public List<PurchaseOrder> searchPurByProductName(String query);



    }
