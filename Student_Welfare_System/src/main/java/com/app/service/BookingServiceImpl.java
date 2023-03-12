package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookingRepository;
import com.app.dao.RoomRepository;
import com.app.dao.UserRepository;
import com.app.dto.BookingRespDto;
import com.app.dto.bookingDTO;
import com.app.pojo.projection.BookingItem;
import com.app.pojos.BookingPojo;
import com.app.pojos.RoomPojo;
import com.app.pojos.UserPojo;

@Service
@Transactional

public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingRepository bookRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoomRepository roomRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<BookingItem> findBookingRoomsOfUser(String email) {
		System.out.println("Enter user email to find details");
		
		return bookRepo.findAllBookingRoomsByUserEmail(email);
	}

	@Override
	public BookingRespDto bookRoom(bookingDTO book) {
		
		UserPojo user=userRepo.getReferenceById(book.getUserId());
		RoomPojo room=roomRepo.getReferenceById(book.getRoomId());
		BookingPojo bookingPojo=new BookingPojo();
		bookingPojo.setRent(book.getRent());
		bookingPojo.setUser(user);
		bookingPojo.setRoom(room);
		BookingPojo saveBooking=bookRepo.save(bookingPojo);
		return mapper.map(saveBooking, BookingRespDto.class);
	}

}
