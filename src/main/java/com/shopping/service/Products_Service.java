package com.shopping.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.entities.Brand;
import com.shopping.entities.Categories;
import com.shopping.entities.Products;
import com.shopping.entities.Sub_categories;
import com.shopping.entities.dto.ProductsDto;
import com.shopping.repository.BrandsRepository;
import com.shopping.repository.CategoriesRepository;
import com.shopping.repository.ProductsRepository;
import com.shopping.repository.SubCategory_Repository;

@Service
public class Products_Service {
	
	@Autowired
	private ProductsRepository productrepository;
	
	@Autowired
	private CategoriesRepository categoriesrepo;
	@Autowired
	private SubCategory_Repository subcategoriesrepo;
	@Autowired
	private BrandsRepository brandrepo;

	public List<Products> getProductList() {
		return productrepository.findAll();
	}

	public ResponseEntity<?> saveProducts(ProductsDto productdto) {
		Products prod=new Products();
		Optional<Brand> brand=brandrepo.findById(productdto.getBrandsId());
		Optional<Categories> category=categoriesrepo.findById(productdto.getCategoryId());
		Optional<Sub_categories> subcate=subcategoriesrepo.findById(productdto.getSubId());
		
		prod.setCategories(category.get());
		prod.setSubcategories(subcate.get());
		prod.setBrands(brand.get());
		
		prod.setProductName(productdto.getProductName());
		prod.setDescription(productdto.getDescription());
		prod.setDiscountedPrice(calculateDiscountedPrice(productdto.getProductPrice(), productdto.getDiscountPercent()));
		prod.setDiscountPercent(productdto.getDiscountPercent());// correct or not
		prod.setProductPrice(productdto.getProductPrice());
		prod.setImageUrl(productdto.getImageUrl());
		prod.setModel(productdto.getModel());
		prod.setStockQuantity(productdto.getStockQuantity());
		prod.setCreatedDate(getCurrentDateTime());
	
		productrepository.save(prod);
		return ResponseEntity.ok("Products Saved Successfully");
	}

	public ResponseEntity<?> updateProducts(Long id, ProductsDto productdto) {
		
		Optional<Brand> brand=brandrepo.findById(productdto.getBrandsId());
		Optional<Categories> category=categoriesrepo.findById(productdto.getCategoryId());
		Optional<Sub_categories> subcate=subcategoriesrepo.findById(productdto.getSubId());
		
		Optional<Products> prod=productrepository.findById(id);
		if(prod.isPresent()) {
			Products exist=prod.get();
			exist.setSubcategories(subcate.get());
			exist.setBrands(brand.get());
			exist.setCategories(category.get());
			exist.setProductName(productdto.getProductName());
			exist.setProductPrice(productdto.getProductPrice());
			exist.setStockQuantity(productdto.getStockQuantity());
			exist.setModel(productdto.getModel());
			exist.setDiscountedPrice(calculateDiscountedPrice(productdto.getProductPrice(), productdto.getDiscountPercent()));
			exist.setDescription(productdto.getDescription());
			exist.setImageUrl(productdto.getImageUrl());
			exist.setUpdatedDate(getCurrentDateTime());
			productrepository.save(exist);
			return ResponseEntity.ok("Product Updated");
		}
		return ResponseEntity.badRequest().body("wrong Updation....Please Try Again!");
	}
	public ResponseEntity<?> deleteProduct(Long id) {
		if(productrepository.existsById(id)) {
			productrepository.deleteById(id);
			return ResponseEntity.ok("Product "+id+" deleted successfully");
		}
		return ResponseEntity.badRequest().body("Invalid Product Id...!");
	}
	
	public String getCurrentDateTime() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime now = LocalDateTime.now();
	    return now.format(formatter);
	}
	
	 public  double calculateDiscountedPrice(double productPrice, double discountPercentage) {
	        
	        if (productPrice < 0) {
	            throw new IllegalArgumentException("Original price cannot be negative.");
	        }
	        
	        if (discountPercentage < 0 || discountPercentage > 100) {
	            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
	        }
	        double discountAmount = (productPrice * discountPercentage) / 100;

	        double discountedPrice = productPrice - discountAmount;

	        return discountedPrice;
	    }


}
