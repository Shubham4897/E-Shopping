package com.shopping.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	@Column
	private String categoryName;
	@Column
	private String createdCategoryDate;
	@Column
	private String updatedCategoryDate;
	
	@OneToMany(mappedBy = "categories")
	@JsonIgnore
	private List<Products> products;
	
	
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCreatedCategoryDate() {
		return createdCategoryDate;
	}
	public void setCreatedCategoryDate(String createdCategoryDate) {
		this.createdCategoryDate = createdCategoryDate;
	}
	public String getUpdatedCategoryDate() {
		return updatedCategoryDate;
	}
	public void setUpdatedCategoryDate(String updatedCategoryDate) {
		this.updatedCategoryDate = updatedCategoryDate;
	}

}
