package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
//STUDENT WELFARE SYSTEM
@MappedSuperclass
@Getter
@Setter
public class BaseEntityPojo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

}
