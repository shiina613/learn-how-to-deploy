package com.rikkei.reshoppingcartwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rikkei.reshoppingcartwebapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
