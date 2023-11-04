package com.PIDEV.demo.services;


import com.PIDEV.demo.entities.*;
import com.PIDEV.demo.repository.PurchaseOrderRepository;
import com.PIDEV.demo.repository.SuggestionRepository;
import com.PIDEV.demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
public class SuggestionService implements ISuggestionService {

    @Autowired
    SuggestionRepository suggestionRepository;
    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;
   @Autowired
    SupplierRepository supplierRepository;

    @Override
    public void addSuggestion(Suggestion suggestion) {
        suggestionRepository.save(suggestion);

    }

    @Override
    public List<Suggestion> retrieveAllSuggestions() {
        return (List<Suggestion>)suggestionRepository.findAll();
    }

    @Override
    public Suggestion retrieveSuggestion(Integer suggestionId) {
        return suggestionRepository.findById(suggestionId).orElse(null);
    }

    @Override
    public Suggestion updateSuggestion(Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    @Override
    public void removeSuggestion(Integer idSuggestion) {
        Suggestion s=retrieveSuggestion(idSuggestion);
        suggestionRepository.delete(s);
    }
    @Override
    public List<Object[]> getSuggestionsDuringBlackFriday() throws ParseException {
        Date fd  = new SimpleDateFormat("dd-MM-yyyy").parse("23-11-2023");
        Date ld = new SimpleDateFormat("dd-MM-yyyy").parse("27-11-2023");

        Random rand = new Random();
        Integer discount = rand.nextInt(16) + 25; // génère un nombre aléatoire entre 15 et 40
        System.err.println(discount);

        List<Suggestion> suggestions = suggestionRepository.findSuggestionBetweenDates(fd,ld);
        List<Object[]> result = new ArrayList<>();
        for (Suggestion suggestion : suggestions) {
            Float originalAmount = suggestion.getPrice();
            Float discountedAmount = originalAmount * discount/100; // discount
            suggestion.setPrice(discountedAmount); // update the amount in the reservation object
           // suggestionRepository.save(suggestion); // save the updated reservation in the database
            Object[] suggestionData = {suggestion, originalAmount, discountedAmount};
            result.add(suggestionData);
        }
        return result;

    }

    @Transactional
    @Override
    public Suggestion addAndassignSuggestionToPurchaseOrder(Suggestion s, Integer purchaseOrderId,Integer id) {
        Supplier supplier =supplierRepository .findById(id).orElse(null);
        System.err.println(supplier.getId());
        s.setSupplier(supplier);

        PurchaseOrder p = purchaseOrderRepository.findById(purchaseOrderId).orElse(null);
        s.setPurchaseOrder(p);

        s.setDure(new Date());
        suggestionRepository.save(s);
        return s;
    }

}
