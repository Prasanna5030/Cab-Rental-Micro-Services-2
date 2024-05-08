package com.sl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sl.model.DriverDto;
import com.sl.service.DriverService;

@Controller
public class DriverController {
	@Autowired
	private DriverService driverService;
	
	@GetMapping("/driver")
	public String loginDriver(@ModelAttribute("driverDto") DriverDto driverDto) {
		return "driver-login";
	}
	
	@PostMapping("/driverlogin")                          
	public String saveDriver(@ModelAttribute("driverDto") DriverDto driverDto) {
		driverService.saveDriver(driverDto);
		return "driver-home";
		
	}
}
