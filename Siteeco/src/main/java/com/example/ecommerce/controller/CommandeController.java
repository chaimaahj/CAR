package com.example.ecommerce.controller;
import com.example.ecommerce.entities.Commande;
import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Produits;
import com.example.ecommerce.repositories.ClientRepository;


import com.example.ecommerce.repositories.CommandeRepository;
import com.example.ecommerce.repositories.LigneCommandeRepository;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Controller
public class CommandeController {

    @Autowired
    CommandeRepository commande;



    @Autowired
    ProductRepository products;

    @Autowired
    ClientRepository client;

    @Autowired
    LigneCommandeRepository lc;

    private Long idProduit;
    private Collection<LigneCommande> commandeList;

    private Optional<Produits> produit;
    @Autowired
    ProductRepository pr;


    private double total;



    @GetMapping("/addCommande")
    public String addCommande(Model model) {

        commandeList = lc.findAll();
        Commande cmd = new Commande(new Date(), commandeList);
        commande.save(cmd);

        for (LigneCommande ligneCommande : lc.findAll()) {

            idProduit=ligneCommande.getIdProduit();
            produit = products.findById(idProduit);
            System.out.println("   produit.get().getQte() " + produit.get().getQte());
            System.out.println("   l.getQte() " + ligneCommande.getQte());
            produit.get().setQte(ligneCommande.getQte());

            total += ligneCommande.getPrix();

        }
        cmd.setTotal(total);
        for (Commande c : commande.findAll()) {
            System.out.println("   la commande passé est   " + c.getLigneCommandes());
        }


        System.out.println(" le prix total de la commande est   " + total);
        model.addAttribute("commande",cmd);
        lc.deleteAll();
        for(Produits product : products.findAll()){
            System.out.println("     "+ product.toString());
        }



            return "Commande";
        }
    }




