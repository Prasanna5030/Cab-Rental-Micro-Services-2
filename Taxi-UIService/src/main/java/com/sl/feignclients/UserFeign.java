package com.sl.feignclients;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sl.model.UserDto;

@FeignClient(name = "UserFeign", url="${user.service.url}")
public interface UserFeign {
	
	@PostMapping("/api/user/add")
	public void saveUser(@RequestBody UserDto userDto);
	
	@GetMapping("/api/user/{id}")
	public UserDto getUserById(@PathVariable Long id);
	
	@GetMapping("/api/user/name")
	public UserDto getUserByName(@RequestParam String name);

}
