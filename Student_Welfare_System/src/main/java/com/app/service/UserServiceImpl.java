package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserRepository;
import com.app.pojos.Role;
import com.app.pojos.UserPojo;

import custom_exception.UserAlreadyExistsException;

@Service
@Transactional

public class UserServiceImpl implements UserService{
	@Autowired 
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder enc;
	@Override
	public UserPojo addUserDetails(UserPojo user) {
		if(userRepo.existsByEmail(user.getEmail())) {
			throw new UserAlreadyExistsException("User email already exists !!!");
			
		}
		user.setPassword(enc.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public void changeRole(Role role, String email) {
		
		
	}

	@Override
	public Object saveUser(UserPojo user) {
	
		return userRepo.save(user);
	}

	@Override
	public Optional<UserPojo> getUser(Long id) {
		return userRepo.findById(id) ;
		
	}

}
