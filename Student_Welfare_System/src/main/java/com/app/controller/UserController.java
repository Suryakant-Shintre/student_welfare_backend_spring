package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Role;
import com.app.pojos.UserPojo;
import com.app.service.CustomUserDetails;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping
	public ResponseEntity<?>saveUser(@RequestBody UserPojo user){
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@PutMapping("change/{role}")
	public ResponseEntity<?>changeRole(@AuthenticationPrincipal CustomUserDetails userDetails,@PathVariable Role role)
	{
		System.out.println("In change role "+role+""+userDetails.getAuthorities());
		userService.changeRole(role, userDetails.getUsername());
		
		return ResponseEntity.ok(true);

	}
	@GetMapping
	public ResponseEntity<?>getUserById(@PathVariable Long Id){
		userService.getUser(Id);
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}


}
