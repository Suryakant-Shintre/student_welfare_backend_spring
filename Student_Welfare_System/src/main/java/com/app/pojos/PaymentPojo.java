package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Payment")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PaymentPojo extends BaseEntityPojo{
	private Integer paymentId;
	
	

}
