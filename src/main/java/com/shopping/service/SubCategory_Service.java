package com.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.entities.Sub_categories;
import com.shopping.repository.SubCategory_Repository;

@Service
public class SubCategory_Service {
	
	@Autowired
	private SubCategory_Repository subcategoryrepository;

	public List<Sub_categories> subCategoryList() {	
		return subcategoryrepository.findAll();
	}

	public ResponseEntity<?> saveSubCategory(Sub_categories subcategories) {
		subcategories.setCreatedDate(getCurrentDateTime());
		subcategoryrepository.save(subcategories);
		return ResponseEntity.ok("SubCategory Saved");
	}

	public ResponseEntity<?> updateSubCategory(Long id, Sub_categories subcategory) {
		Optional<Sub_categories> subcat=subcategoryrepository.findById(id);
		if(subcat.isPresent()) {
			Sub_categories exist=subcat.get();
			exist.setSubName(subcategory.getSubName());
			exist.setUpdatedDate(getCurrentDateTime());
			subcategoryrepository.save(exist);
			return ResponseEntity.ok(id+" Updated Succesfully");
		}
		return ResponseEntity.badRequest().body("Plesae Try Again.....!");
	}

	public ResponseEntity<?> removeSubCategory(Long id) {
		if(subcategoryrepository.existsById(id)) {
			subcategoryrepository.deleteById(id);
			return ResponseEntity.ok(id+" removed SuccessFully");
		}
		return ResponseEntity.badRequest().body("Wrong Input....!");
	}
	
	public String getCurrentDateTime() {
	    // Change pattern here as per your need
	    String pattern = "yyyy-MM-dd HH:mm:ss"; 
	    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(pattern);
	    formatter.setTimeZone(java.util.TimeZone.getTimeZone("Asia/Kolkata")); // IST
	    return formatter.format(new java.util.Date());
	}

}
