package com.rikkei.reshoppingcartwebapp.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "cart")
    @JsonManagedReference
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(User user, List<CartItem> cartItems) {
        this.user = user;
        this.cartItems = cartItems;
    }

    public Cart(Integer id, User user, List<CartItem> cartItems) {
        this.id = id;
        this.user = user;
        this.cartItems = cartItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
