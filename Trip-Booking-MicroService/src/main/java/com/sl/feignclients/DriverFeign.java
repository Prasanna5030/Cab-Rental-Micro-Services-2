package com.sl.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sl.model.DriverDto;

@FeignClient(name="DriverFeignClient" , url="${driver.service.url}")
public interface DriverFeign {

	@GetMapping("/api/driver/all")
	public List<DriverDto> getAllDrivers();
	
	@GetMapping("api/driver/{id}")
	public DriverDto getDriverById(@PathVariable Long id);
	
	@GetMapping("api/driver/available")
	public List<DriverDto> availableDrivers(@RequestParam Boolean available);
	
	
}
