package com.example.ecommerce.controller;
import com.example.ecommerce.entities.Client;
import com.example.ecommerce.entities.Commande;
import com.example.ecommerce.repositories.LigneCommandeRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Produits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller

public class ProduitController {
    @Autowired
    ProductRepository products;

    private Collection<Produits> produitsList;
    private static List<LigneCommande> ligneC = new ArrayList<LigneCommande>();

    @Autowired
    LigneCommandeRepository lc;

    private double totalPrice;

    private Commande commande;

    private Client client;

    @GetMapping("/")
    public String init() {

        return "home";
    }
    @GetMapping("/moncompte")
    public String compte(){
        return "account";
    }

    @GetMapping("/products")
    public String showProductList(Map<String, Object> model) {
       produitsList =products.findAll();
       model.put("products", produitsList);
       return "produits";
    }
    @GetMapping("/p")
    public String showProduct(Map<String, Object> model, @Param("name") String nom) {
        produitsList = products.findByNom(nom);
        model.put("products", produitsList);
        return "produits";
    }






    private Produits prod;
    @GetMapping( "/addProduct/{id}")
    public String addProduct(HttpSession session, @PathVariable ("id") Long idProduit) {
        System.out.println("le produit récupéré est     "+ idProduit);


        prod = products.findById(idProduit).get();
        LigneCommande ligneCommande = new LigneCommande(prod.getId(),prod.getNom(),prod.getPrix(),1,prod.getImg());
        lc.findByIdProduit(prod.getId());

        if(!lc.findByIdProduit(prod.getId()).isPresent()) {
            lc.save(ligneCommande);
        }
        ligneC.add(ligneCommande);

        return "redirect:/products";

    }










}
