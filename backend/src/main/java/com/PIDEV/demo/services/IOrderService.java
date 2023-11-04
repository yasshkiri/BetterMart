package com.PIDEV.demo.services;



import com.PIDEV.demo.entities.CommandLigne;
import com.PIDEV.demo.entities.Facture;
import com.PIDEV.demo.entities.Orderr;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public interface IOrderService {
    public void updateOrderState();
    void ajoutOrder(Orderr order);
    void addFacture(int ido);
     String generateUniqueId();
    void deleteOrder(int ido);
    public void updateProduct(int idcmd);
    Facture FacturesOfOrder(int ido);

    Facture GetFacture(int id);

    void affectPreoductLignecommande(int idProduit);
    Set<CommandLigne> listLigneCommand(int ido);
    void deletelignecommande(int idlc);
    void AddligneCommandeToOrder(int idCmd, int ido);
    float CalculeTotale(int idO);

    public void export(HttpServletResponse response, int id) throws IOException;
    Orderr GetOrder(int id);
}
