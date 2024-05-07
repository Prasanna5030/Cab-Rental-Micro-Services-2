package com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sl.entity.TripBooking;

@Controller
@RequestMapping("/api/taxi")
public class UIController {
	
	
	@GetMapping("/hello")
	public String homepage(TripBooking tb) {
		return "index";
	}
}
