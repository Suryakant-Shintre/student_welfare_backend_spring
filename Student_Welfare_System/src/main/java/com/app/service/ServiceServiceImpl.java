package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ServiceRepository;
import com.app.pojos.ServicePojo;

import custom_exception.ResourceNotFoundException;
@Service
@Transactional
public class ServiceServiceImpl implements ServiceService{
	@Autowired
	private ServiceRepository ser;
	

	@Override
	public ServicePojo saveService(ServicePojo serv) {
		
		return ser.save(serv);
	}

	@Override
	public void deleteService(Long Id) {
		if(ser.existsById(Id)) {
			Optional<ServicePojo> sp=ser.findById(Id);
			System.out.println("service having name "+(sp.get().getServiceName()));
			ser.deleteById(Id);
		}else {
			throw new ResourceNotFoundException("Service with given Id doesn't exists");
		
		}
	}

	@Override
	public List<ServicePojo> findAllServices() {
		
		return ser.findAll();
	}

}
