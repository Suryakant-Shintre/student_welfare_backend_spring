package com.app.service;

import java.util.List;

import com.app.dto.BookingRespDto;
import com.app.dto.bookingDTO;
import com.app.pojo.projection.BookingItem;

public interface BookingService {
	BookingRespDto bookRoom(bookingDTO book);
	
List<BookingItem> findBookingRoomsOfUser(String email);
}
