package com.example.ecommerce.entities;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "stock")
public class Stock {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }


}
