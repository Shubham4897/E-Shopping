package com.shopping.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.entities.Cart;
import com.shopping.entities.Products;
import com.shopping.entities.dto.RequestCartDto;
import com.shopping.repository.CartRepository;
import com.shopping.repository.ProductsRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartrepo;
    @Autowired
    private ProductsRepository prodrepo;

    public ResponseEntity<?> saveProductToCart(RequestCartDto cartdto) {
        Cart obj = new Cart();
        Optional<Products> products = prodrepo.findById(cartdto.getProductId());
        if (!products.isPresent()) {
            return ResponseEntity.badRequest().body("Product not found");
        }
        obj.setProducts(products.get());
        obj.setQuantity(cartdto.getQuantity());
        obj.setCreatedDate(createCartDate());
        cartrepo.save(obj);
        return ResponseEntity.ok("Product Saved in Cart");
    }

    public List<Cart> getCartList() {
        return cartrepo.findAll();
    }

    public ResponseEntity<?> updateCartQuantity(Long id, RequestCartDto cartdto) {
        Optional<Cart> carts = cartrepo.findById(id);
        if (carts.isPresent()) {
            Cart cart = carts.get();
            long currentQty = cart.getQuantity();
            long change = cartdto.getQuantity();
            long newQty = currentQty + change;

            if (newQty < 1) {
                return ResponseEntity.badRequest().body("Quantity cannot be less than 1");
            }
            cart.setQuantity(newQty);
            cart.setUpdatedDate(createCartDate());
            cartrepo.save(cart);
            return ResponseEntity.ok("Cart quantity updated to: " + newQty);
        } else {
            return ResponseEntity.badRequest().body("Cart item not found");
        }
    }

    public ResponseEntity<?> deleteCartProductById(Long id) {
        if (cartrepo.existsById(id)) {
            cartrepo.deleteById(id);
            return ResponseEntity.ok(id + " product Deleted succesfully");
        }
        return ResponseEntity.badRequest().body("Product cant be deleted");
    }

    public String createCartDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return formatter.format(date);
    }
}