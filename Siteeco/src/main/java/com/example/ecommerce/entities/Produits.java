package com.example.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "products")
public class Produits implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private double  prix;
    private String img;
    private  Integer qte;


    protected Produits(){

    }
    public Produits(String nom, String img, double prix, Integer qte){

        this.nom = nom;
        this.prix = prix;
        this.img = img;
        this.prix=prix;
        this.qte = qte;

    }
    public Long  getId(){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = this.nom;
    }

    public double getPrix(){
        return this.prix;
    }

    public void setPrix(double prix){
        this.prix = this.prix;
    }

    public String getImg(){
        return this.img;
    }

    public void setImg(String img){
        this.img = this.img;
    }

    public Integer  getQte(){
        return this.qte;
    }
    public void setQte(Integer qte){
        this.qte = this.qte-qte;
    }



    @Override
    public String toString() {
        return String.format("id=%d,nom='%s',quantite=%d]",id,nom,qte);
    }
}
