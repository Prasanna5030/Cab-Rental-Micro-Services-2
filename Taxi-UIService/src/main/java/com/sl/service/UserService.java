package com.sl.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sl.feignclients.UserFeign;
import com.sl.model.UserDto;

@Service
public class UserService {
	
	@Autowired
	private UserFeign userfeign;
	
	public void saveUser(UserDto userDto) {
		userfeign.saveUser(userDto);
	}
	
	public UserDto getUserId(Long id) {
		UserDto userDto = userfeign.getUserById(id);
		return userDto;
	}
	
	public UserDto getUserByName(String name) {
		return userfeign.getUserByName(name);
	}

}
