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

import com.shopping.entities.Products;
import com.shopping.entities.dto.ProductsDto;
import com.shopping.service.Products_Service;

@RestController
@RequestMapping("/products/api")
public class Product_Controller {
	
	@Autowired
	private Products_Service productservice;
	
	@GetMapping("/product-list")
	public List<Products> getproductlist(){
		return productservice.getProductList();
	}
	
	@PostMapping("/save-products")
	public ResponseEntity<?> createProduct(@RequestBody ProductsDto productdto){
		return productservice.saveProducts(productdto);
	}
	@PutMapping("/update-products/{id}")
	public ResponseEntity<?> modifyProducts(@PathVariable Long id, @RequestBody ProductsDto productdto){
		return productservice.updateProducts(id,productdto);
		
	}
	@DeleteMapping("/delete-products/{id}")
	public ResponseEntity<?> removeProduct(@PathVariable Long id){
		return productservice.deleteProduct(id);
	}

}
