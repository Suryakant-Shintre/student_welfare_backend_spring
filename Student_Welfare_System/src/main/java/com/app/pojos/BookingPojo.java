package com.app.pojos;
//STUDENT WELFARE SYSTEM
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Booking_tbl")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class BookingPojo extends BaseEntityPojo{
	
	@Column(name="Payment_ID",unique=true ,nullable=false)

	private Integer paymentId;
	@CreationTimestamp
	@Column(name="Updated_on")
	private LocalDate bookingDate;
	@Column(name="rent_amount",nullable=false)
	private Double rent;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RoomID",nullable=false)
	private RoomPojo room;
	@OneToOne
	@JoinColumn(name="UserID",nullable=false)
	private UserPojo user;

	public BookingPojo( Integer paymentId, LocalDate bookingDate, Double rent) {
		super();
		
		this.paymentId = paymentId;
		this.bookingDate = bookingDate;
		this.rent = rent;
	}


}
