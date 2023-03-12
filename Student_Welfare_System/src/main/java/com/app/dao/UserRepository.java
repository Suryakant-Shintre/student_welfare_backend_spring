package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Role;
import com.app.pojos.UserPojo;

public interface UserRepository extends JpaRepository<UserPojo,Long> {
	Optional<UserPojo> findByEmail(String email);
	boolean existsByEmail(String email);
	
	@Modifying
	@Query("update UserPojo u  set u.userRole= ?1 where u.email= ?2")
	void setUserRole(Role role,String email);
	
	
	
}
