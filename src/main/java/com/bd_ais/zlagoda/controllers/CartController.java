package com.bd_ais.zlagoda.controllers;


import com.bd_ais.zlagoda.service.CartService;
import com.bd_ais.zlagoda.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String showListProducts(Model model) {
        model.addAttribute("products", cartService.getAllProducts());
        return "cart/cart";
    }
}
