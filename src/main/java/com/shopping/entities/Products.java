package com.shopping.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "products")
public class Products {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long productId;
	 @Column
	 private String productName;
	 @Column
	 private double productPrice;
	 @Column
	 private double discountedPrice;
	 @Column
	 private String description;
	 @Column
	 private String imageUrl;
	 @Column
     private int stockQuantity;
     @Column
     private String model;
     @Column
 	private double discountPercent;
     @Column
 	private String createdDate;
 	@Column
 	private String updatedDate;
 	
 	@ManyToOne(fetch = FetchType.EAGER)
 	@JoinColumn(name = "categoryId")
 	private Categories categories;
 	
 	@ManyToOne(fetch = FetchType.EAGER)
 	@JoinColumn(name = "brandsId")
 	private Brand brands;
 	
 	@ManyToOne(fetch = FetchType.EAGER)
 	@JoinColumn(name="subId")
 	private Sub_categories subcategories;
 	
 	@OneToMany(mappedBy = "products")  
 	@JsonIgnore
    private List<Cart> carts;
 	
 	@OneToOne(mappedBy = "products")
 	@JsonIgnore
 	private ProductOrder prodorder;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Brand getBrands() {
		return brands;
	}

	public void setBrands(Brand brands) {
		this.brands = brands;
	}

	public Sub_categories getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Sub_categories subcategories) {
		this.subcategories = subcategories;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public ProductOrder getProdorder() {
		return prodorder;
	}

	public void setProdorder(ProductOrder prodorder) {
		this.prodorder = prodorder;
	}
 	
 	
	
}
