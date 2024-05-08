package com.sl.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cab {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	
	private String carModel;
	
	private String cabType;
	
	private String vehicleNo;
	
	private Long ratePerKm;
	
	
}
