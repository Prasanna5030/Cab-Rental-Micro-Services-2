package com.sl.feignclients;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.sl.model.UserDto;

@FeignClient(name="UserFeignClient"  , url="${user.service.url}")
public interface UserFeign {
	
	@GetMapping(path="/api/user/all")
	public List<UserDto> getAllUser();
	
	@GetMapping(path="/api/user/allusers")
	public Map<Long, UserDto> getAllUsersMap();
	
	@GetMapping("/api/user/{id}")
	public UserDto getUserById(@PathVariable Long id);
	
	
	
	

}
