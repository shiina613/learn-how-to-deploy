package com.rikkei.reshoppingcartwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.rikkei.reshoppingcartwebapp.model.CartItem;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    List<CartItem> findByCartId(Integer cartId);

    Optional<CartItem> findByCartIdAndProductId(Integer cartId, Integer productId);

    @Modifying
    @Transactional
    void deleteByCartId(Integer cartId);
}
