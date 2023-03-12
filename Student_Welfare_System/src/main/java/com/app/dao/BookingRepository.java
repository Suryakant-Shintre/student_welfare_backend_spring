package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.projection.BookingItem;
import com.app.pojos.BookingPojo;

public interface BookingRepository extends JpaRepository<BookingPojo,Long>{
	
	long deleteByRoomId(Long roomId);
	
	
	@Query("select new com.app.pojo.projection.BookingItem(u.fullName as name , b.rent as rentPrice, b.bookingDate as bookingTime) from BookingPojo b join b.user u where u.email = ?1")
	//@Query("select new com.app.pojo.projection.BookingItem(r.name as name b.rentPrice as rent b.bookingTime as bookingTime)from BookingPojo b join b.user u join r.room r where u.email=?1")
	List<BookingItem>findAllBookingRoomsByUserEmail(String email);

}
