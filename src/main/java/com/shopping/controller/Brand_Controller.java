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

import com.shopping.entities.Brand;
import com.shopping.service.Brand_Service;

@RestController
@RequestMapping("/brands/api")
public class Brand_Controller  {
	
	@Autowired
	private Brand_Service brandservice;
	
	//API OF MAPPINGS
	
	@GetMapping("/brand-list")
	public List<Brand> getLists(){
		return brandservice.getBrandsList();
	}
	
	@PostMapping("/save-brand")
	private ResponseEntity<?> createBrand(@RequestBody Brand brand){
		return brandservice.saveBrand(brand);
	}
	
	@PutMapping("/update-brand/{id}")
	private ResponseEntity<?> modifyBrand(@RequestBody Brand brand, Long id){
		return brandservice.updateBrand(brand,id);
	}
	
	@DeleteMapping("/delete-brand/{id}")
	private ResponseEntity<?> removeBrand(@PathVariable Long id){
		return brandservice.deleteBrand(id);
	}
	
}
