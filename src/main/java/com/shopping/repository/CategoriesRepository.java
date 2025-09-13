package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
