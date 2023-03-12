package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRespDto {
	private Long id;
	private double rent;
	private LocalDateTime purchaseTime;
}

