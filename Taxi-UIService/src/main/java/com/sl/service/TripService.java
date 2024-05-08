package com.sl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.feignclients.TripBookingFeign;
import com.sl.model.TripBooking;

@Service
public class TripService {
	
	@Autowired
	private TripBookingFeign tbfeign;
	
	public TripBooking bookTrip(TripBooking tb) {
	  return	tbfeign.bookNewTrip(tb);
	}

	public TripBooking tripend(TripBooking tripBooking, long id) {
		return tbfeign.tripend(tripBooking,id);
		
	}
	
	
}
