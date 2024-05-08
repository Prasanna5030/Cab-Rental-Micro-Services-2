package com.sl.Dto;

import com.sl.entity.Address;
import com.sl.entity.Cab;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverDto {

	private Long id;
	
	private String name;

	private String email;
	
	private String password;
	
	private String mobile;
	
     private String lisenceNo;
	
     private Double rating;
    	
     private Address address;
     
     private Cab cab;
	 
}
