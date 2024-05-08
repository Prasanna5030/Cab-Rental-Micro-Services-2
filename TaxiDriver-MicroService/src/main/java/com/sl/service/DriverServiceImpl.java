package com.sl.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.Dto.DriverDto;
import com.sl.entity.Driver;

import com.sl.repository.DriverRepository;


@Service
public class DriverServiceImpl implements DriverService{
	@Autowired
	private DriverRepository driverRepository;
	

	@Override
	public List<DriverDto> getAllUsers() {
		 List<Driver> drivers=driverRepository.findAll();
		 List<DriverDto> allDrivers= drivers.stream().map((driver)-> DriverDto.builder().id(driver.getId())
				 																		.name(driver.getName())
				 																		.email(driver.getEmail())
				 																		.mobile(driver.getMobile())
				 																	    .address(driver.getAddress())
				 																	    .lisenceNo(driver.getLisenceNo())
				 																	    .cab(driver.getCab())
				 																	    .rating(driver.getRating())
				 																	    .build()).collect(Collectors.toList());	
		 return allDrivers;
	}

	@Override
	public DriverDto getUserById(Long id) {
		Driver driver=driverRepository.findById(id).orElseThrow(()->new RuntimeException("driver not found"));
		DriverDto userDto= DriverDto.builder()
				.id(driver.getId())
				.name(driver.getName())
					.email(driver.getEmail())
					.mobile(driver.getMobile())
				    .address(driver.getAddress())
				    .lisenceNo(driver.getLisenceNo())
				    .cab(driver.getCab())
				    .rating(driver.getRating())
				    .build();
		return userDto;
	}

	@Override
	public Driver saveUser(DriverDto driverDto) {
		Driver driver = Driver.builder()
				.id(driverDto.getId())
				.name(driverDto.getName())
				.email(driverDto.getEmail())
				.mobile(driverDto.getMobile())
				.address(driverDto.getAddress())
				.password(driverDto.getPassword())
				.cab(driverDto.getCab())
				.lisenceNo(driverDto.getLisenceNo())
				.rating(driverDto.getRating())
				.available(true)
						.build();
		
	return	driverRepository.save(driver);
		
	}

	@Override
	public List<DriverDto> findByAvailable(Boolean b) {
	 	List<Driver> driversList = driverRepository.findByAvailable(b);
	 	
	 	List<DriverDto> driversAvailable= driversList.stream().map( driver-> DriverDto.builder()
	 																	.id(driver.getId())
			                                                        	.name(driver.getName())
			                                                         	.email(driver.getEmail())
			                                                         	.mobile(driver.getMobile())
			                                                         	.address(driver.getAddress())
			                                                         	.lisenceNo(driver.getLisenceNo())
			                                                         	.cab(driver.getCab())
			                                                         	.rating(driver.getRating())
			                                                         	.build()
	 																).collect(Collectors.toList());
	 	
	 	return driversAvailable;
	}
}
