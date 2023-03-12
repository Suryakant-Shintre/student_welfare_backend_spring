package com.app.service;

import com.app.pojos.AddressPojo;
import com.app.pojos.AmenitiesPojo;

public interface AmenitiesService {
		AmenitiesPojo addAmenities(AmenitiesPojo adr);
		void deleteAmenities(Long Id);
		int updateAmenities(AmenitiesPojo am);

	}

