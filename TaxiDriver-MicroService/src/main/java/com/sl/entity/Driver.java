package com.sl.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Driver")
@ToString
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="driver_name", nullable=false )
	private String name;
	
	@Column(nullable=false )
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	private String mobile;
	
	private String lisenceNo;
	
	private Boolean available = true;
	
	private Double rating;
	
	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Address.class)
	@JoinColumn(name = "address_id" )
	private Address address;
	
	@OneToOne( cascade = CascadeType.ALL  ,fetch = FetchType.EAGER ,targetEntity = Cab.class)
	@JoinColumn(name="cab_id")
	private Cab cab;
	
}
