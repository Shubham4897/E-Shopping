package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
