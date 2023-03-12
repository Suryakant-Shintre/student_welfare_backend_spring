package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AddressRepository;
import com.app.pojos.AddressPojo;

import custom_exception.ResourceNotFoundException;


@Service
@Transactional
public class AddressServiceImpl  implements AddressService{
	@Autowired
	private AddressRepository adr;

	@Override
	public AddressPojo addAddress(AddressPojo adp) {
		
		return adr.save(adp);
	}

	@Override
	public void deleteAddress(Long Id) {
		if(adr.existsById(Id)) {
			System.out.println("address deleted with ID = "+Id);
			adr.deleteById(Id);
		}
		else
			throw new ResourceNotFoundException("Address not found forgiven ID");
	}

	@Override
	public int updateAddress(AddressPojo ad) {
		Optional<AddressPojo>ap=adr.findById(ad.getId());
		if(ap.isPresent()) {
			AddressPojo a=ap.get();
			a.setAddressLine1(ad.getAddressLine1());
			a.setAddressLine2(ad.getAddressLine2());
			a.setContact(ad.getContact());
			a.setCityName(ad.getCityName());
			a.setAddressLine1(ad.getStateName());
			adr.save(a);
			return 1;
		}
		return 0;
	}

}
