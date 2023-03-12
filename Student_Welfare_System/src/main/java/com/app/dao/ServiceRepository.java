package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ServicePojo;

public interface ServiceRepository extends JpaRepository<ServicePojo,Long>{

	
	


	
}
