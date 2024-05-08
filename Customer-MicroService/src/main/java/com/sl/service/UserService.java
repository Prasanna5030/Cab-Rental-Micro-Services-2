package com.sl.service;

import java.util.List;
import java.util.Map;

import com.sl.Dto.UserDto;
import com.sl.entity.User;

public interface UserService {

	List<UserDto> getAllUsers();
	
	Map<Long, UserDto> getAllUsersMap();

	UserDto getUserById(Long id);

	User saveUser(UserDto userDto);
	
	UserDto getUserByName(String name);

}
