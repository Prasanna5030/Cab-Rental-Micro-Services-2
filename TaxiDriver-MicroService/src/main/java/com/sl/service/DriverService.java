package com.sl.service;

import java.util.List;

import com.sl.Dto.DriverDto;

import com.sl.entity.Driver;


public interface DriverService {

	List<DriverDto> getAllUsers();

	DriverDto getUserById(Long id);

	Driver saveUser(DriverDto driverDto);
	
	List<DriverDto> findByAvailable(Boolean b);

}
