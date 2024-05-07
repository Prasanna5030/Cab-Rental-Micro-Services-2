package com.sl.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.sl.enums.BookingStatus;
import com.sl.enums.Payment;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tripId;
	
	private Long customerId;
	
	private String customerName;
	
	private Long driverId;
	
	private String driverName;
	
	private LocalDate tripStartDate;
	
	private LocalDate tripEndDate;	

	private Double totalKms;
	
	private Double fare;
	
	@Enumerated(EnumType.STRING)
	private Payment isPaymentDone;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus status;
	
}
