package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.OrderAddress;

public interface OrderAddressRepo extends JpaRepository<OrderAddress, Long>{

}
