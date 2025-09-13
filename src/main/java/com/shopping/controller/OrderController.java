package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entities.ProductOrder;
import com.shopping.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private OrderService orderservice;
	@GetMapping("/list")
	public List<ProductOrder> orderList(){
		return orderservice.getOrderList();
	}
	@PostMapping("/save")
	public ResponseEntity<?> createOrder(@RequestBody ProductOrder order){
		return orderservice.saveOrder(order);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> modifyOrder(@PathVariable Long id, @RequestBody ProductOrder order){
		return orderservice.updateOrder(id,order);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removeOrder(@PathVariable Long id){
		return orderservice.deleteOrder(id);
	}

}
