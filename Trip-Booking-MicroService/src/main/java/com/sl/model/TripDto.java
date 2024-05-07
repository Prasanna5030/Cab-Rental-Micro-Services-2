package com.sl.model;

import java.time.LocalDate;

import com.sl.enums.BookingStatus;
import com.sl.enums.Payment;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripDto {

	private Long tripId;
	
	private Long customerId;
	
	private String customerName;
	
	private Long driverId;
	
	private String driverName;
	
	private LocalDate tripStartDate;
	
	private LocalDate tripEndDate;	

	private Double totalKms;
	
	private Double fare;
	
	private Payment payment;
	
	private BookingStatus status;
	
	

}
