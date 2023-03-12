package com.app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AmenitiesRepository;
import com.app.pojos.AmenitiesPojo;

import custom_exception.ResourceNotFoundException;
@Service
@Transactional
public class AmenitiesServiceImpl implements AmenitiesService {
private AmenitiesRepository amrp;
	@Override
	public AmenitiesPojo addAmenities(AmenitiesPojo adr) {
		
		return amrp.save(adr);
	}

	@Override
	public void deleteAmenities(Long Id) {
		
		if(amrp.existsById(Id)) {
			System.out.println("amenities deleted with ID = "+Id);
			amrp.deleteById(Id);
		}
		else
			throw new ResourceNotFoundException("amenities not found forgiven ID");
		
	}

	@Override
	public int updateAmenities(AmenitiesPojo am) {
		Optional<AmenitiesPojo>ae=amrp.findById(am.getId());
		if(ae.isPresent()) {
			AmenitiesPojo x=ae.get();
			x.setWashingMachine(am.getWashingMachine());
			x.setInternet(am.getInternet());
			x.setFurniture(am.getFurniture());
			x.setWaterFilter(am.getWaterFilter());
			amrp.save(am);
			return 1;
		}
		
		return 0;
	}

}
