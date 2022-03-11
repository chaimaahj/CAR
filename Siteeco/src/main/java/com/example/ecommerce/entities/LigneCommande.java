package com.example.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lignecommande")
public class LigneCommande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idlCommande;

    private Long idProduit;

    private int qte;

    private double prix;

    private double total;

    private  String img;

    private  String nom;

    public LigneCommande(){

    }
    public  LigneCommande( Long idProduit,String nom,double prix,int qte,String img){
        super();
        this.idProduit= idProduit;
        this.nom = nom;
        this.img=img;
        this.qte = qte;
        this.prix = prix;
    }


    public Long getIdlCommande() {
        return idlCommande;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setId(Long id) {
        this.idlCommande = id;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte=qte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return String.format("[idLigneCommande=%d,idProduit=%s,prix=%f,qte=%d,nom=%s]",idlCommande,idProduit,prix,qte,nom);
    }
}
