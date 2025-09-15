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

import com.shopping.entities.OrderAddress;
import com.shopping.service.OrderAddressService;

@RestController
@RequestMapping("/api/order-address")
public class OrderAddressController {
	
	@Autowired
	private OrderAddressService orderservicerepo;
	
	@GetMapping("/list")
	public List<OrderAddress> getAddressList(){
		return orderservicerepo.getAddressList();
	}
	@PostMapping("/save")
	public ResponseEntity<?> createAddress(@RequestBody OrderAddress address){
		return orderservicerepo.saveaddress(address);
	}
	@PutMapping("/update")
	public ResponseEntity<?> modifyAddress(@PathVariable Long id, @RequestBody OrderAddress address){
		return orderservicerepo.updateAddress(id, address);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?> removeAddress(@PathVariable Long id){
		return orderservicerepo.deleteaddress(id);
	}
}
