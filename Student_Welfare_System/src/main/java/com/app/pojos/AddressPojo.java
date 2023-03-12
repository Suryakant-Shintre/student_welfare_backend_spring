package com.app.pojos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Address_tbl")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddressPojo extends BaseEntityPojo {
	@Column(name="Address_line_1",length=200,nullable=false)
	private String addressLine1;
	
	@Column(name="Address_Line_2",length=200)
	private String addressLine2;
	
	@Column(name="Contact_no",unique=true,nullable=false)
	private String contact;
	
	@Column(name="City",nullable=false)
	private String cityName;
	
	@Column(name="State",nullable=false)
	private String stateName;
	
	@Column(name="Pin_Code",nullable=false,length=8)
	private String pinCode;
	
	@OneToOne
	@JoinColumn(name="RoomID",nullable=false)
	private RoomPojo room;
	
	public AddressPojo(String addressLine1, String addressLine2, String contact, String cityName, String stateName,
			String pinCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.contact = contact;
		this.cityName = cityName;
		this.stateName = stateName;
		this.pinCode = pinCode;
	}

}
