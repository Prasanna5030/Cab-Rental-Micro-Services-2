package com.sl.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sl.model.DriverDto;

@FeignClient(name = "DriverFeign" , url = "${taxidriver.service.url}")
public interface DriverFeign {

	@PostMapping("/api/driver/add")
	public void saveDriver(@RequestBody DriverDto driverDto);
	
	// http://localhost:8085/api/driver/available?available=true
	
	@GetMapping("api/driver/available")
	public List<DriverDto> getAvailableDrivers(@RequestParam ("available") Boolean available);
}
