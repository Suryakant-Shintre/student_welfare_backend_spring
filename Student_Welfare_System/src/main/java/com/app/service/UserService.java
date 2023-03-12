package com.app.service;

import java.util.Optional;

import com.app.pojos.Role;
import com.app.pojos.UserPojo;

public interface UserService {
	UserPojo addUserDetails(UserPojo user) ;
	
	void changeRole(Role role,String email);

	Object saveUser(UserPojo user);

	Optional<UserPojo> getUser(Long id);
		
}
