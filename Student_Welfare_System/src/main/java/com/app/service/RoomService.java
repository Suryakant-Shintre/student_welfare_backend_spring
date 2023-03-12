package com.app.service;

import java.util.List;

import com.app.pojos.RoomPojo;

public interface RoomService {
	RoomPojo saveRoom(RoomPojo room);
	
	void deleteRoom(Long Id);
	
	List<RoomPojo>findAllRooms();
	List<RoomPojo>findRoomByPrice();

}
