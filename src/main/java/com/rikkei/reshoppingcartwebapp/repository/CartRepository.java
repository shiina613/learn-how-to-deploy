package com.rikkei.reshoppingcartwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rikkei.reshoppingcartwebapp.model.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByUserId(Integer userId);
}
