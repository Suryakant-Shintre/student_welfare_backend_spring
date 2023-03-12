package com.app.pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//STUDENT WELFARE SYSTEM
@Entity
@Table(name="room_tbl")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RoomPojo extends BaseEntityPojo{
	@Column(name="room_name",length=50,nullable=false)
	private String roomName;
	
	@Column(name="rent",nullable=false)
	private Double rent;
	
	private String imagePath;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Gender gender;
	
	@Column(name="vacancy",nullable=false)
	private Integer roomVacancy;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sharing",nullable=false)
	private Sharing roomsharing;
	@ManyToOne
	@JoinColumn(name="ServiceID",nullable=false)	
	private ServicePojo service;
	@OneToOne(mappedBy="room",cascade=CascadeType.ALL,orphanRemoval=true)
	private AddressPojo addressPojo;
	@OneToOne(mappedBy="room",cascade=CascadeType.ALL,orphanRemoval=true)
	private AmenitiesPojo amenities;
	@OneToMany(mappedBy="room",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<BookingPojo> booking = new ArrayList<>();
	@OneToMany(mappedBy="room",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<RatingPojo> rating = new ArrayList<>();
	public RoomPojo(String roomName, Double rent, Gender gender, Integer roomVacancy, Sharing roomsharing) {
		super();
		this.roomName = roomName;
		this.rent = rent;
		this.gender = gender;
		this.roomVacancy = roomVacancy;
		this.roomsharing = roomsharing;
	}
	
	private void addAddress(AddressPojo addressPojo) {
		this.addressPojo=addressPojo;
		addressPojo.setRoom(this);
	}
	
	private void addamenities(AmenitiesPojo amenities) {
		this.amenities=amenities;
		amenities.setRoom(this);
	}
	
	private void addBooking(BookingPojo b) {
		booking.add(b);
		b.setRoom(this);
	}
	private void addRating(RatingPojo r) {
		this.rating.add(r);
		r.setRoom(this);
		
	}
	
}
