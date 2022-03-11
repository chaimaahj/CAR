package com.example.ecommerce.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCommande;
    private Date dateCommande;
    @ManyToOne
    @JoinColumn(name="idClient")
    private Client client;
    @OneToMany
    @JoinColumn(name="idCommande")
    private Collection<LigneCommande> ligneCommandes;

    private double total;

    public Commande( ){
    }

    public Commande(Date dateCommande,  Collection<LigneCommande> ligneCommande){
        super();
        this.client = client;
        this.dateCommande = dateCommande;
        this.ligneCommandes =  ligneCommande;

    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(Collection<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

