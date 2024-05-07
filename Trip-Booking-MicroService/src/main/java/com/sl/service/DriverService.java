package com.sl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sl.feignclients.DriverFeign;

import com.sl.model.DriverDto;
@Service
public class DriverService {
	@Autowired
	private DriverFeign driverFeign;

	public List<DriverDto> getAlldrivers(){
		return driverFeign.getAllDrivers();
	}
		public DriverDto getDriverById(Long id) {
			return driverFeign.getDriverById(id);
		}
		
		public List<DriverDto> availableDrivers(Boolean available){
			return driverFeign.availableDrivers(available);
		}
	}

