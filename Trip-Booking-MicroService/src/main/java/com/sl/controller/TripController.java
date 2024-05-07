package com.sl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.entity.TripBooking;
import com.sl.model.TripDto;
import com.sl.service.TripService;

@RestController
@RequestMapping("/api")
public class TripController {

	@Autowired
	private TripService tripService;
	
	@GetMapping("/hello")
	public String sayHEllo() {
		return "Hello trip";
	}
	
	@PostMapping("/addtrip")
	public ResponseEntity<TripBooking> tripBooking(@RequestBody TripBooking tripBooking){
		return new ResponseEntity<TripBooking> (tripService.addNewTrip(tripBooking), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteTrip(@PathVariable Long id) {
		tripService.deleteTrip(id);
		return  new ResponseEntity("Trip deleted successfully", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/tripend/{id}")
	public ResponseEntity<TripBooking> tripEnd(@RequestBody TripBooking tripBooking ,@PathVariable Long id) {
		TripBooking tb=tripService.tripEnd(tripBooking, id) ;
		return  new ResponseEntity<TripBooking> (tb, HttpStatus.ACCEPTED);
	}
}
