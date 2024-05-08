package com.sl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sl.model.DriverDto;
import com.sl.model.TripBooking;
import com.sl.model.UserDto;
import com.sl.service.DriverService;
import com.sl.service.UserService;

@Controller
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private DriverService driverService;
	
	@GetMapping("/home")
	public String sayHello( ) {
		return "apphome";
	}
	
	@GetMapping("/userlogin")
	public String sayHello(@ModelAttribute("userDto") UserDto userDto) {
		return "userlogin";
	}

	@PostMapping("/login")
	public ModelAndView getUserInfo(@ModelAttribute("userDto") UserDto userDto, @ModelAttribute("TripBooking") TripBooking tripBooking ) {
		ModelAndView mav= new ModelAndView();
		
		
		mav.addObject(tripBooking);
		mav.setViewName("bookcab");
		
		// getting list of available drivers
		List<DriverDto> availableDrivers= new ArrayList<>();
		availableDrivers=driverService.getAvailableDrivers(true);
		
		userService.saveUser(userDto);
		
		UserDto user =userService.getUserByName(userDto.getName());
		mav.addObject("user",user);
		
		mav.addObject("availableDrivers", availableDrivers);
		return mav;
		
	}
}
