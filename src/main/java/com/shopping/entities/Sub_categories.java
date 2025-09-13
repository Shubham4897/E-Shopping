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
@Table(name="sub-category")
public class Sub_categories {
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long subId;
			@Column
			private String subName;
			@Column
			private String createdDate;
			@Column
			private String updatedDate;
			
			@OneToMany(mappedBy = "subcategories")	
		    @JsonIgnore
			private List<Products> products;
			
				
			public List<Products> getProducts() {
				return products;
			}
			public void setProducts(List<Products> products) {
				this.products = products;
			}
			public Long getSubId() {
				return subId;
			}
			public void setSubId(Long subId) {
				this.subId = subId;
			}
			public String getSubName() {
				return subName;
			}
			public void setSubName(String subName) {
				this.subName = subName;
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
			
			
	
}
