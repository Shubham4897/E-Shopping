package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.ProductOrder;

public interface OrderRepository extends JpaRepository<ProductOrder, Long> {

}
