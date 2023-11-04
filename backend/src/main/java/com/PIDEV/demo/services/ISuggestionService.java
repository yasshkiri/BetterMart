package com.PIDEV.demo.services;

import com.PIDEV.demo.entities.Discount;
import com.PIDEV.demo.entities.PurchaseOrder;
import com.PIDEV.demo.entities.Suggestion;

import java.text.ParseException;
import java.util.List;

public interface ISuggestionService {

    public void addSuggestion(Suggestion suggestion);
    public List<Suggestion> retrieveAllSuggestions();
    Suggestion retrieveSuggestion(Integer suggestionId);
    public Suggestion updateSuggestion (Suggestion suggestion);
    public  void removeSuggestion(Integer idSuggestion);

    public List<Object[]> getSuggestionsDuringBlackFriday() throws ParseException;

    public Suggestion addAndassignSuggestionToPurchaseOrder(Suggestion s, Integer purchaseOrderId,Integer id);
}
