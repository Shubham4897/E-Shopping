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

import com.shopping.entities.Sub_categories;
import com.shopping.service.SubCategory_Service;

@RestController
@RequestMapping("/api/sub-category")
public class SubCategory_Controller {
	
	@Autowired
	private SubCategory_Service subcategoryservice;
	
	@GetMapping("/list")
	public List<Sub_categories> getSubCategoryList(){
		return subcategoryservice.subCategoryList();
	}
	@PostMapping("/save")
	public ResponseEntity<?> createSubCategory(@RequestBody Sub_categories subcategories){
		return subcategoryservice.saveSubCategory(subcategories);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> modifySubCategory(@PathVariable Long id , @RequestBody Sub_categories subcategory ){
		return subcategoryservice.updateSubCategory(id,subcategory);	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteSubCategory(@PathVariable Long id){
		return subcategoryservice.removeSubCategory(id);
	}

}
