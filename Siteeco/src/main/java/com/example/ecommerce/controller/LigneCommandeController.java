package com.example.ecommerce.controller;

import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Produits;
import com.example.ecommerce.repositories.LigneCommandeRepository;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Map;
@Controller
public class LigneCommandeController  {
    @Autowired
    LigneCommandeRepository lc;

    private double totalprix;

    private LigneCommande ligneCommande;
    private Collection<LigneCommande> commandeList;
    @Autowired
    ProductRepository product;

    Produits produit;


    @GetMapping("/panier")
    public String showProductList(Map<String, Object> model,Model m) {
        commandeList=lc.findAll();
        for(LigneCommande l:lc.findAll()){
            totalprix+=l.getPrix();
        }
        m.addAttribute("totalprix",totalprix);

        model.put("lignecommande",commandeList);

        return "panier";
    }






    @GetMapping( "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable ("id") Long idProduit) {
        System.out.println("le produit récupéré est     "+ idProduit);

        ligneCommande = lc.findById(idProduit).get();

        lc.delete(ligneCommande);

        return "redirect:/panier";

    }
    @GetMapping( "/addQte/{id}")
    public String addQte(@PathVariable ("id") Long idProduit,Model m) {
        System.out.println("le produit récupéré est     "+ idProduit);

        ligneCommande= lc.findByIdProduit(idProduit).get();
        ligneCommande.setQte(ligneCommande.getQte()+1);
        ligneCommande.setPrix(ligneCommande.getPrix()+ product.findById(idProduit).get().getPrix());
        lc.save(ligneCommande);

        return "redirect:/panier";


    }



}
