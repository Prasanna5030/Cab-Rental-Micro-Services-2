package com.sl.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.Exception.DriverNotAvailableException;
import com.sl.Exception.TripNotFoundException;
import com.sl.Exception.UserNotFoundException;
import com.sl.entity.TripBooking;
import com.sl.enums.BookingStatus;
import com.sl.enums.Payment;
import com.sl.model.DriverDto;
import com.sl.model.UserDto;
import com.sl.repository.TripRepository;

import lombok.RequiredArgsConstructor;

@Service

public class TripServiceImpl implements TripService{
	@Autowired
	private UserService userService;

	@Autowired
	private DriverService driverService;

	private List<DriverDto>  availableDrivers=null;
	 
	private List<UserDto> ListOfUsers=null;

	private DriverDto driverDto=null;
	
	@Autowired
	private TripRepository tripRepository;
	
	@Override
	public TripBooking addNewTrip(TripBooking tb) { 
		
		 TripBooking tripBooking=null;
	  UserDto userById=userService.getUserById(tb.getCustomerId());
	  System.out.println(userById.getId());
	  List<UserDto> ListOfUsers= userService.getAllUsers();   
	  
	  Map<Long , UserDto> usersList= userService.getAllUsersMap();   
	  
       for(UserDto user :ListOfUsers) {
	         if( usersList.containsKey(userById.getId())){
	        	 availableDrivers=driverService.availableDrivers(true);
	        	 System.out.println("AvailableDrivers"+availableDrivers);
	 		   	if(availableDrivers.size()==0) {
	 		   		throw new DriverNotAvailableException("Driver is not available at the current moment ");
	 		   	}
	 		   	else {
	 		   		Long driverId=tb.getDriverId();
	 		   		 driverDto =driverService.getDriverById(driverId);
	 		     	driverDto.setIsAvailable(false);
	 		   	}
	 		   	
	 		  Double randomKms = new Random().nextDouble(50);
	 		   		tb.setCustomerId(userById.getId());
	 		   		tb.setCustomerName(userById.getName());
	 		   		tb.setDriverId(driverDto.getId());
	 		   		tb.setDriverName(driverDto.getName());
	 		   		tb.setTripStartDate((LocalDate)tb.getTripStartDate());
	 		   		tb.setTripEndDate((LocalDate)tb.getTripEndDate());
	 		   		tb.setTotalKms(randomKms );  //generating a random number for the totalKMs
	 		   		tb.setFare(randomKms* driverDto.getCab().getRatePerKm());
	 		   		tb.setStatus(BookingStatus.SUCCESS);
	 		   		tb.setIsPaymentDone(Payment.NONE);
	 		   		
	 	 tripBooking= 	tripRepository.save(tb);
	 	 System.out.println("New trip"+tripBooking);
	         }
	      }
       System.out.println(tripBooking);
	return tripBooking;
	
   }

	public String deleteTrip(Long id) {
		
		TripBooking tb=tripRepository.findById(id).orElseThrow(()->new TripNotFoundException("Trip with" +id+"doesn't exist ")) ;
		
		tb.setDriverId(null);
		tb.setCustomerId(null);
		tripRepository.delete(tb);
		
		return "Trip deleted sucessfully";
		
	}

	@Override
	public TripBooking tripEnd(TripBooking tb, Long id) {
			TripBooking tb1= tripRepository.findById(id).orElseThrow(()->new TripNotFoundException("Trip with  "+id +"not found "));
		
			System.out.println(tb.getTripId());
			
			tb.setIsPaymentDone(Payment.CASH); 
		   tb.setStatus(BookingStatus.COMPLETED);
		
//			currentDriver.setIsAvailable(true);   
		return	tripRepository.save(tb);
		
	}		

}
