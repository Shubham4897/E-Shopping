package com.shopping.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.entities.OrderAddress;
import com.shopping.entities.ProductOrder;
import com.shopping.entities.Products;
import com.shopping.entities.dto.RequestOrderDTO;
import com.shopping.repository.OrderAddressRepo;
import com.shopping.repository.OrderRepository;
import com.shopping.repository.ProductsRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderrepo;
	@Autowired
	private OrderAddressRepo addressrepo;
	@Autowired
	private ProductsRepository productrepository;

	public List<ProductOrder> getOrderList() {
		return orderrepo.findAll();
	}

	public ResponseEntity<?> saveOrder(RequestOrderDTO orderdto) {
			ProductOrder prod =new ProductOrder();
			Optional<OrderAddress> orderadd =addressrepo.findById(orderdto.getAddressId());
			Optional<Products> products=productrepository.findById(orderdto.getProductId());
			if(!products.isPresent()) {
				return ResponseEntity.badRequest().body("Product Not Found");
			}
			if(!orderadd.isPresent()) {
				return ResponseEntity.badRequest().body("Order Not Found");
			}
			
			prod.setProducts(products.get());
			prod.setOrderaddresss(orderadd.get());
			prod.setOrderDate(LocalDateTime.now());
			prod.setPrice(orderdto.getPrice());
			prod.setQuantity(orderdto.getQuantity());
			orderrepo.save(prod);
			return ResponseEntity.ok("Order Saved Successfully");
	}

	public ResponseEntity<?> updateOrder(Long id, RequestOrderDTO orderdto) {
		Optional<ProductOrder> orders=orderrepo.findById(id);
		Optional<OrderAddress> orderadd =addressrepo.findById(orderdto.getAddressId());
		Optional<Products> products=productrepository.findById(orderdto.getProductId());
		if(orders.isPresent()) {
			ProductOrder exist=orders.get();
			exist.setProducts(products.get());
			exist.setOrderaddresss(orderadd.get());
			exist.setUpdatedDate(LocalDateTime.now());
			exist.setPrice(orderdto.getPrice());
			exist.setQuantity(orderdto.getQuantity());
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
	
	
}
