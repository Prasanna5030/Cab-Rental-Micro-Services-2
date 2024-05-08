package com.sl.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sl.model.TripBooking;

@FeignClient(name="TripBookingFeign"  , url="${tripbooking.service.url}")
public interface TripBookingFeign {

	@PostMapping("/api/addtrip")
	public TripBooking bookNewTrip(@RequestBody TripBooking tb);

	@PostMapping("/api/tripend/{id}")
	public TripBooking tripend(@RequestBody TripBooking tripBooking,@PathVariable("id") Long id);
}
