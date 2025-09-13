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

import com.shopping.entities.Categories;
import com.shopping.service.Categories_Service;

@RestController
@RequestMapping("/api/categories")
public class Categories_Controller {
	
	@Autowired
	private Categories_Service categoriesservice;
	
	@GetMapping("/list")
	public List<Categories> getList(){
		return categoriesservice.getCategoryList();
	}
	
	@PostMapping("/save-categories")
	public ResponseEntity<?> createCategories(@RequestBody Categories categories){
		return categoriesservice.saveCategories(categories);	
	}
	
	@PutMapping("/modify-categories/{id}")
	public ResponseEntity<?> updateCategories(@PathVariable Long id, @RequestBody Categories categories){
		return categoriesservice.modifyCategory(id,categories);
	}
	
	@DeleteMapping("/remove-categories/{id}")
	public ResponseEntity<?> deleteCategories(@PathVariable Long id){
		return categoriesservice.removeCategories(id);
	}
	

}
