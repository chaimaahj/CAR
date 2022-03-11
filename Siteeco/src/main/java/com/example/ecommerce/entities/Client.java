package com.example.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private String login;
    private String password;
    private String prenom;
    private String nom;
    private String email;
    private String role;

    public Client() {

    }
    public Client(String login, String password, String prenom,
                   String nom, String email) {
        super();
        this.login = login;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    public int getId() {
        return idClient;
    }
    public void setId(int id) {
        this.idClient= id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("Client[nom='%s',prenom='%s'",nom,prenom);
    }
}