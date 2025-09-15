package com.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.entities.OrderAddress;
import com.shopping.repository.OrderAddressRepo;

@Service
public class OrderAddressService {
	
	@Autowired
	private OrderAddressRepo orderaddressrepo;

	public List<OrderAddress> getAddressList() {
			return orderaddressrepo.findAll();
	}

	public ResponseEntity<?> saveaddress(OrderAddress address) {
		orderaddressrepo.save(address);
		return ResponseEntity.ok("Address Saved Successfully");
	}

	public ResponseEntity<?> updateAddress(Long id, OrderAddress address) {
		Optional<OrderAddress> obj=orderaddressrepo.findById(id);
		if(obj.isPresent()) {
			OrderAddress existaddress=obj.get();
			existaddress.setFirstName(address.getFirstName());
			existaddress.setLastName(address.getLastName());
			existaddress.setAddress(address.getAddress());
			existaddress.setCity(address.getCity());
			existaddress.setEmail(address.getEmail());
			existaddress.setMobileNo(address.getMobileNo());
			existaddress.setState(address.getState());
			existaddress.setPincode(address.getPincode());
			orderaddressrepo.save(existaddress);
			return ResponseEntity.ok("Address Updated Succesfully");
		}
		return ResponseEntity.badRequest().body("Wrong Details Found");
	}

	public ResponseEntity<?> deleteaddress(Long id) {
		if(orderaddressrepo.existsById(id)) {
			orderaddressrepo.deleteById(id);
			return ResponseEntity.ok("Address Removed Successfully");
		}
		return ResponseEntity.badRequest().body("Wrong Addres inserted");
	}
	
	

}
