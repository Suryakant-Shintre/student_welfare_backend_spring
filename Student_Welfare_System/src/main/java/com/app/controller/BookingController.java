package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.bookingDTO;
import com.app.service.BookingService;
import com.app.service.CustomUserDetails;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	@PostMapping
	public ResponseEntity<?>bookRoom(@RequestBody bookingDTO booking){
		System.out.println("bookked room is"+booking);
		return new ResponseEntity<>(bookingService.bookRoom(booking),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<?>getBookedRoomOfUser(@AuthenticationPrincipal CustomUserDetails user){
		System.out.println("user "+user.getUsername()+" "+user.getPassword()+" "+user.getAuthorities());
		return ResponseEntity.ok(bookingService.findBookingRoomsOfUser(user.getUsername()));
	}
}

