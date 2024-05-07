package com.sl.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.feignclients.UserFeign;
import com.sl.model.UserDto;


@Service
public class UserService {

	@Autowired
	private UserFeign userFeign;
	
	public List<UserDto>  getAllUsers(){
		return userFeign.getAllUser();
	}
		
	public Map<Long, UserDto>  getAllUsersMap(){
		return userFeign.getAllUsersMap();
	}
	public UserDto getUserById(Long id) {
		return userFeign.getUserById(id);
	}

	}

