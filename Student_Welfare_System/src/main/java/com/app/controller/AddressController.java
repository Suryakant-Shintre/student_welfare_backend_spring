package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.AddressPojo;
import com.app.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressservice;
	@PostMapping
	public ResponseEntity<?> saveAddress(@RequestBody AddressPojo address){
		return new ResponseEntity<>(addressservice.addAddress(address),HttpStatus.CREATED);
	}
	@DeleteMapping("/addressId")
	public ResponseEntity<?>deleteAddress(@PathVariable Long Id){
		addressservice.deleteAddress(Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<?>updateAddress(@RequestBody AddressPojo ad){
		addressservice.updateAddress( ad);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
