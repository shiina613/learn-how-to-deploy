package com.rikkei.reshoppingcartwebapp.service;

import org.springframework.stereotype.Service;

import com.rikkei.reshoppingcartwebapp.model.Product;
import com.rikkei.reshoppingcartwebapp.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
