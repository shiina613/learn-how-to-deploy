package com.rikkei.reshoppingcartwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rikkei.reshoppingcartwebapp.service.CartService;
import com.rikkei.reshoppingcartwebapp.service.ProductService;

@Controller
public class HomeController {

    private final ProductService productService;
    private final CartService cartService;

    // Demo: fix cartId = 1
    private static final Integer CART_ID = 1;

    public HomeController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cartItems", cartService.getCartItems(CART_ID));
        model.addAttribute("cartId", CART_ID);
        model.addAttribute("totalAmount", cartService.calculateTotal(CART_ID));
        return "index";
    }
}
