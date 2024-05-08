package com.sl.model;



import java.time.LocalDate;
import java.time.LocalDateTime;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TripBooking {


	private Long tripId;
	
	private Long customerId;
	
	private String customerName;
	
	private Long driverId;
	
	private String driverName;
	
	private LocalDate tripStartDate;
	
	private LocalDate tripEndDate;	

	private Double totalKms;
	
	private Double fare;
	
	private Float rating;
	

	
}
