package com.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.entities.Categories;
import com.shopping.repository.CategoriesRepository;

@Service
public class Categories_Service {
	
	@Autowired
	private CategoriesRepository categoriesrepository;

	public List<Categories> getCategoryList() {
		return categoriesrepository.findAll();
	}

	public ResponseEntity<?> saveCategories(Categories categories) {
		categories.setCreatedCategoryDate(getCurrentDateTime());
		categoriesrepository.save(categories);
		return ResponseEntity.ok("Categories Saved");
	}

	public ResponseEntity<?> modifyCategory(Long id, Categories categories) {
		Optional<Categories> cate=categoriesrepository.findById(id);
		if(cate.isPresent()) {
			Categories exist=cate.get();
			exist.setCategoryName(categories.getCategoryName());
			exist.setUpdatedCategoryDate(getCurrentDateTime());
			categoriesrepository.save(exist);
			return ResponseEntity.ok("Updated Successfully");
		}
		return ResponseEntity.badRequest().body("Please Try Again...!");
	}

	public ResponseEntity<?> removeCategories(Long id) {
		
				if(categoriesrepository.existsById(id)) {
					categoriesrepository.deleteById(id);
					return ResponseEntity.ok(" Categories Deleted ");
				}
		return ResponseEntity.badRequest().body("Please Try Again...!");
	}
	
	public String getCurrentDateTime() {
	    // Change pattern here as per your need
	    String pattern = "yyyy-MM-dd HH:mm:ss"; 
	    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(pattern);
	    formatter.setTimeZone(java.util.TimeZone.getTimeZone("Asia/Kolkata")); // IST
	    return formatter.format(new java.util.Date());
	}

}
