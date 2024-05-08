package com.sl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sl.Dto.DriverDto;
import com.sl.entity.Driver;
import com.sl.service.DriverService;


@RestController
@RequestMapping("/api/driver")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@GetMapping("hello")
	public String sayHello() {
		return "Welcome ! Mr/Mrs";
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<DriverDto>> getAllDrivers(){
	List<DriverDto> users=	driverService.getAllUsers();
	return new ResponseEntity<List<DriverDto>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public DriverDto getUserById(@PathVariable Long id) {
		DriverDto userDto=driverService.getUserById(id);
		return userDto;
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> saveUser(@RequestBody DriverDto driverDto ){
		driverService.saveUser(driverDto);
		return new ResponseEntity<String>("Driver registered" ,HttpStatus.OK);
	}
	
	@GetMapping("/available")
	public ResponseEntity<List<DriverDto>> getAvailableDrivers(@RequestParam Boolean available){
	List<DriverDto> availableDrivers=	driverService.findByAvailable(available);
	return new ResponseEntity<List<DriverDto>>(availableDrivers, HttpStatus.OK);
	}
	
	
}

