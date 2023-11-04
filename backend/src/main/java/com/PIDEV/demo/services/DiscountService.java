package com.PIDEV.demo.services;

import com.PIDEV.demo.SMS.SmsPojo;
import com.PIDEV.demo.SMS.SmsService;
import com.PIDEV.demo.entities.Discount;
import com.PIDEV.demo.entities.Product;
import com.PIDEV.demo.repository.DiscountRepository;
import com.PIDEV.demo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DiscountService implements IDiscountService{


    @Autowired
    DiscountRepository discountRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SmsService smsService;


    @Override
    public void ajouterDiscount(Discount discount) {
        discountRepository.save(discount);
    }
    @Override
    public List<Discount> retrieveAllDiscounts() {
        return (List<Discount>) discountRepository.findAll();
    }
    @Override
    public Discount retrieveDiscount (Integer  idDiscount){
        return discountRepository.findById(idDiscount).orElse(null);
    }
    @Override
    public Discount updateDiscount(Discount dis) {

        return discountRepository.save(dis);
    }
    @Override
    public void removeDiscount(Integer idDiscount) {
        Discount d=retrieveDiscount(idDiscount);
        discountRepository.delete(d);
    }
    @Transactional
    @Override
    public Discount addAndassignDiscountToProduct(Discount d, Integer productId) {
        discountRepository.save(d);
        Product p = productRepository.findById(productId).orElse(null);
        p.setDiscount(d);
        discountRepository.save(d);
        smsService.send(new SmsPojo("+21696002288",d.getDescriptionD()));
        return d;
    }

    //update par id

    public Discount updatePub(Discount discount) {
        discountRepository.save(discount);
        return discount;
    }
    public Optional<Discount> getDiscountById(Integer id) {

        return discountRepository.findById(id);
    }



    //get list product
    public List <Product> getProduct(Integer discountId) {
         return discountRepository.findProductsByDiscountId(discountId);

    }

    @Override
    public List<Object[]> getProductsAfterDiscount(Integer discountId) throws ParseException {
        List<Product> products = discountRepository.findProductsByDiscountId(discountId);
        List<Object[]> result = new ArrayList<>();
        for (Product product : products) {
            Float originalAmount = product.getPrice();
            Float discountedAmount = originalAmount *( product.getDiscount().getAmountCode()/100); // à changer par dicountamount auto
            product.setPrice(discountedAmount); // update the amount in the reservation object
            // suggestionRepository.save(suggestion); // save the updated reservation in the database
            Object[] productData = {product, originalAmount, discountedAmount};
            result.add(productData);
        }
        return result;
    }


}
