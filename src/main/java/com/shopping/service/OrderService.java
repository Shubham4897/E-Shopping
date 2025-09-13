package com.shopping.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.entities.ProductOrder;
import com.shopping.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderrepo;

	public List<ProductOrder> getOrderList() {
		return orderrepo.findAll();
	}

	public ResponseEntity<?> saveOrder(ProductOrder order) {
		order.setCreatedDate(LocalDateTime.now());
		orderrepo.save(order);
		return ResponseEntity.ok("Order Saved Successfully");
	}

	public ResponseEntity<?> updateOrder(Long id, ProductOrder order) {
		Optional<ProductOrder> orders=orderrepo.findById(id);
		if(orders.isPresent()) {
			ProductOrder exist=orders.get();
			exist.setOrderDate(order.getOrderDate());
			exist.setPrice(order.getPrice());
			exist.setQuantity(order.getQuantity());
			order.setUpdatedDate(LocalDateTime.now());
			orderrepo.save(exist);
			return ResponseEntity.ok("Order updated");
		}
		return ResponseEntity.badRequest().body("Order Not Updated");
	}

	public ResponseEntity<?> deleteOrder(Long id) {
		if(orderrepo.existsById(id)) {
			orderrepo.deleteById(id);
			return ResponseEntity.ok("Order Deleted Succesffully");
		}
		return ResponseEntity.badRequest().body("Invalid orderId");
		
	}
	
	public String getCurrentDateTime() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime now = LocalDateTime.now();
	    return now.format(formatter);
	}

}
