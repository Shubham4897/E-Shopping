package com.shopping.entities.dto;

import jakarta.persistence.Column;

public class ProductsDto {
	
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
     private long brandsId;
     @Column
     private long categoryId;
     @Column
     private long subId;
     
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
	 public long getBrandsId() {
		 return brandsId;
	 }
	 public void setBrandsId(long brandsId) {
		 this.brandsId = brandsId;
	 }
	 public long getCategoryId() {
		 return categoryId;
	 }
	 public void setCategoryId(long categoryId) {
		 this.categoryId = categoryId;
	 }
	 public long getSubId() {
		 return subId;
	 }
	 public void setSubId(long subId) {
		 this.subId = subId;
	 }
     
}
