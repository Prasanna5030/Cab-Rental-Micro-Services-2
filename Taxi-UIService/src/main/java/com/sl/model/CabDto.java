package com.sl.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CabDto {


	private Long id;
	
	private String carModel;
	
	private String cabType;
	
	private String vehicleNo;
	
	private Long ratePerKm;
	
	
}
