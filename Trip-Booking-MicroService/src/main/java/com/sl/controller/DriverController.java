package com.sl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sl.model.DriverDto;

import com.sl.service.DriverService;
import com.sl.service.UserService;

@RestController
@RequestMapping("/api/driver")
public class DriverController {
	@Autowired
	private DriverService driverService;

	@GetMapping("/all")
	public ResponseEntity<List<DriverDto>> getAllUsers(){
		return new ResponseEntity<List<DriverDto>>( driverService.getAlldrivers(), HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DriverDto> getUserbyId(@PathVariable Long id){
		return new ResponseEntity<DriverDto>(driverService.getDriverById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/available")
	public ResponseEntity<List<DriverDto>> availableDrivers( @RequestParam Boolean available){
		return new ResponseEntity<List<DriverDto>>( driverService.availableDrivers(available) , HttpStatus.OK);		
	}



}
