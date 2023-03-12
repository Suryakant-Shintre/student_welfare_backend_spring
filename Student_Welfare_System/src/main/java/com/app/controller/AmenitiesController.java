package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.AmenitiesPojo;
import com.app.service.AmenitiesService;

@RestController
@RequestMapping("/amenities")
public class AmenitiesController {
	@Autowired
	private AmenitiesService amenitiesService;
	
	@PostMapping
	public ResponseEntity<?>saveAmnities(@RequestBody AmenitiesPojo am){
		return new ResponseEntity<>(amenitiesService.addAmenities(am),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/amenitiesId")
	public ResponseEntity<?>deleteAmenities(@PathVariable Long Id){
		amenitiesService.deleteAmenities(Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?>updateAmenities(@RequestBody AmenitiesPojo ap){
		amenitiesService.updateAmenities(ap);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
