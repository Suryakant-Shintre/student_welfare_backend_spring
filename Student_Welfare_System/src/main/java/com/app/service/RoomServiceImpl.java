package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookingRepository;
import com.app.dao.RoomRepository;
import com.app.pojos.RoomPojo;

import custom_exception.ResourceNotFoundException;
@Service
@Transactional

public class RoomServiceImpl implements RoomService {
	@Autowired 
	private RoomRepository roomRepo;
	@Autowired
	private BookingRepository bookingRepo;

	@Override
	public RoomPojo saveRoom(RoomPojo room) {
		
		return roomRepo.save(room);
	}

	@Override
	public void deleteRoom(Long Id) {
		
		if(roomRepo.existsById(Id)) {
			System.out.println("deleted "+bookingRepo.deleteByRoomId(Id)+"booking");
			roomRepo.deleteById(Id);
		}
		else
			throw new ResourceNotFoundException("Invalid room Id,cant delete entered room");
	}

	@Override
	public List<RoomPojo> findAllRooms() {
		
		return roomRepo.findAll();
	}

	@Override
	public List<RoomPojo> findRoomByPrice() {
		// TODO Auto-generated method stub
		return null;
	}

}
