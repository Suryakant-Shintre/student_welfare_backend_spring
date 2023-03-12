package com.app.service;

import com.app.pojos.AddressPojo;

public interface AddressService {
	AddressPojo addAddress(AddressPojo adr);
	void deleteAddress(Long Id);
	int updateAddress(AddressPojo adr);

}
