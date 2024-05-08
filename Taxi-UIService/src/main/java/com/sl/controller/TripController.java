package com.sl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sl.model.DriverDto;
import com.sl.model.TripBooking;
import com.sl.service.DriverService;
import com.sl.service.TripService;



@Controller
@RequestMapping("/api")
public class TripController {
	@Autowired
   private TripService tripService;
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/booktrip")
	public ModelAndView bookTrip(@ModelAttribute("tripBooking") TripBooking tripBooking, Model model) {

		ModelAndView mav= new ModelAndView();
		System.out.println(tripBooking);
//		TripBooking tb = tripService.bookTrip(tripBooking);
//	   System.out.println("TripBookingSuccess" +tb);
	   
	// getting list of available drivers
			List<DriverDto> availableDrivers= new ArrayList<>();
			availableDrivers=driverService.getAvailableDrivers(true);
			mav.addObject("availableDrivers", availableDrivers);
			System.out.println(availableDrivers);
	   mav.addObject("tripBooking",tripBooking);
	  mav.setViewName("cars");
		
		return mav ;
	}
	
	@PostMapping("/bookcab")
	public ModelAndView bookCab(@ModelAttribute("tripBooking") TripBooking tripBooking) {
		ModelAndView mav= new ModelAndView();
		System.out.println(" --bookcab--tripBooking " +tripBooking);
		TripBooking tb=tripService.bookTrip(tripBooking);
		System.out.println("final "+tb);
		mav.addObject("tb", tb);
		mav.setViewName("trip-booking-success");
		return mav;
	}
	
	@PostMapping("/tripend")
	public ModelAndView tripend(@ModelAttribute("tb") TripBooking tripBooking, 	Model model) {
		System.out.println("tripend"+ tripBooking);
		ModelAndView mav= new ModelAndView();
		Long id= tripBooking.getTripId();
		tripService.tripend(tripBooking,id);
		mav.addObject("tripBooking, tripBooking");
		mav.setViewName("trip-end");
		return mav;
		
	}
	
	@PostMapping("/tripends")
	public ModelAndView tripEnds(@ModelAttribute("tripBooking") TripBooking tripBooking) {
		ModelAndView mav= new ModelAndView();

		System.out.println("trip-ends" + tripBooking);
		mav.addObject("tripBooking, tripBooking");
		mav.setViewName("trip-end");
		return mav;
		
	}
}
