package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.Discount;
import com.PIDEV.demo.entities.Product;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IDiscountService {

    public void ajouterDiscount(Discount discount);
    public List<Discount> retrieveAllDiscounts();
    Discount retrieveDiscount(Integer discountId);
    public Discount updateDiscount (Discount  dis);
    public  void removeDiscount(Integer idDiscount);

    public Discount addAndassignDiscountToProduct (Discount d, Integer productId);

    Optional<Discount> getDiscountById(Integer id);

    //list product from discount
    public List <Product> getProduct(Integer discountId);

    //promo de produits
    public List<Object[]> getProductsAfterDiscount(Integer discountId) throws ParseException;



}
