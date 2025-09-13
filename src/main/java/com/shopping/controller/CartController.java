package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entities.Cart;
import com.shopping.entities.dto.RequestCartDto;
import com.shopping.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/save-producttoCart")
    public ResponseEntity<?> saveProductToCart(@RequestBody RequestCartDto cartdto) {
        return cartService.saveProductToCart(cartdto);
         
    }

    @GetMapping("/product/lists")
    public List<Cart> getCartLists() {
        return cartService.getCartList();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCartQuantity(@PathVariable Long id, @RequestBody RequestCartDto cartdto) {
        return cartService.updateCartQuantity(id, cartdto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCartProductById(@PathVariable Long id) {
        return cartService.deleteCartProductById(id);
    }
}