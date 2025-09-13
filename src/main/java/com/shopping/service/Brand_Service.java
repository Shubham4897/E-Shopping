package com.shopping.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entities.Brand;
import com.shopping.repository.BrandsRepository;

@Service
@RequestMapping("/brands/api")
public class Brand_Service {
	
	@Autowired
	private BrandsRepository brandsrepository;

	@GetMapping("/brands-list")
	public List<Brand> getBrandsList() {	
		return brandsrepository.findAll();
	}
	
	@PostMapping("/save-brands")
	public ResponseEntity<?> saveBrand(Brand brand) {
		brand.setCreateDate(getCurrentDateTime());
		brandsrepository.save(brand);
		return ResponseEntity.ok("Brand Saved Successfully");
	}

	@PutMapping("/modify-brand/{id}")
	public ResponseEntity<?> updateBrand(Brand brand, Long id) {
		Optional<Brand> brands =brandsrepository.findById(id);
		if(brands.isPresent()) {
			Brand exist=brands.get();
			exist.setBrandsName(brand.getBrandsName());
			exist.setUpdateDate(getCurrentDateTime());
			brandsrepository.save(exist);
			return ResponseEntity.ok("Brand Updated Succesfully");
		}					
		return ResponseEntity.badRequest().body("Errrorr...PLease Tray Again!");
	}

	@DeleteMapping("/delete-brands/{id}")
	public ResponseEntity<?> deleteBrand(Long id) {
				if(brandsrepository.existsById(id)) {
					brandsrepository.deleteById(id);
					return ResponseEntity.ok("Brand Deleted Succesfully");
				}
		return ResponseEntity.badRequest().body("Please Try Again Later....!");
	}
	
	
	public String getCurrentDateTime() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime now = LocalDateTime.now();
	    return now.format(formatter);
	}

	

}
