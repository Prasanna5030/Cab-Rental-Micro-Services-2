package com.sl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.feignclients.DriverFeign;
import com.sl.model.DriverDto;

@Service
public class DriverService {
	@Autowired
	private DriverFeign driverFeign;
	
	public void saveDriver(DriverDto driverDto) {
		driverFeign.saveDriver(driverDto);
	}
	
	
	public List<DriverDto> getAvailableDrivers(Boolean available){
		return driverFeign.getAvailableDrivers(available);
	}
}
