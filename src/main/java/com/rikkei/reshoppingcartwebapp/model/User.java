package com.rikkei.reshoppingcartwebapp.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Cart> carts;

    public User() {
    }

    public User(String name, List<Cart> carts) {
        this.name = name;
        this.carts = carts;
    }



    public User(Integer id, String name, List<Cart> carts) {
        this.id = id;
        this.name = name;
        this.carts = carts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
