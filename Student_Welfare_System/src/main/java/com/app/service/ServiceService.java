package com.app.service;

import java.util.List;

import com.app.pojos.ServicePojo;

public interface ServiceService {
	ServicePojo saveService(ServicePojo serv);
	void deleteService(Long Id);
	List<ServicePojo>findAllServices();

}
