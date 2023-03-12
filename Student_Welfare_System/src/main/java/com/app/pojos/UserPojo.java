package com.app.pojos;
//STUDENT WELFARE SYSTEM

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users_tbl")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserPojo extends BaseEntityPojo {

	@Length(min=2,max=20,message="Invalid or Blank first name")
	@Column(name="name")
	private String fullName;

	@Column(name="user_contact",nullable = false,unique = true)
	private String Contact;

	@Column(name="email",length=30,unique=true)
	private String email;

	@Column(length=30,nullable=false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name="user_role")
	private Role userRole;

	@Enumerated(EnumType.STRING)
	@Column(name="gender")
	private Gender gender;

	@OneToMany(mappedBy="userRole",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<ServicePojo> service = new ArrayList<>();

	@OneToOne(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
	private BookingPojo booking;

	public UserPojo(@Length(min = 2, max = 20, message = "Invalid or Blank first name") String fullName, String contact,
			String email, String password, Role userRole, List<ServicePojo> service) {
		super();
		this.fullName = fullName;
		Contact = contact;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.service = service;
	}

	private void addService(ServicePojo service) {
		this.service.add(service);
		service.setUserRole(this);
	}

	private void addBooking(BookingPojo booking) {
		this.booking=booking;
		booking.setUser(this);
	}



}
