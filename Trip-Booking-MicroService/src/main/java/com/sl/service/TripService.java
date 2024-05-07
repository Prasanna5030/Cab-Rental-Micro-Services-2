package com.sl.service;

import com.sl.entity.TripBooking;

public interface TripService {
	

	public TripBooking addNewTrip(TripBooking tb);
	
	public String deleteTrip(Long id);
	
	public TripBooking tripEnd(TripBooking tb,Long id);

}
