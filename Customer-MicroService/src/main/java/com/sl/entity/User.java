package com.sl.entity;

import org.hibernate.annotations.BatchSize;
import org.springframework.boot.convert.DataSizeUnit;

import jakarta.annotation.Generated;
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
import jakarta.persistence.UniqueConstraint;
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
@Table(name="User" , uniqueConstraints = {@UniqueConstraint(columnNames = {"email","name"} ) } )
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="user_name", nullable=false , unique = true)
	private String name;
	
	@Column(nullable=false , unique = true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	private String mobile;
	
	private Boolean journeyStatus = false;
	
	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Address.class)
	@JoinColumn(name = "address_id" )
	private Address address;
}
