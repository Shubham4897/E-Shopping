package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.Brand;

public interface BrandsRepository extends JpaRepository<Brand, Long> {

}
