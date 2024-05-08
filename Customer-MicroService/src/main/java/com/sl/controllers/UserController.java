package com.sl.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sl.Dto.UserDto;
import com.sl.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome ! Mr/Mrs";
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAllUsers(){
	List<UserDto> users=	userService.getAllUsers();
	return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/allusers")
	public ResponseEntity<Map<Long, UserDto>> getAllUsersMap(){
	Map<Long ,UserDto> users=	userService.getAllUsersMap();
	return new ResponseEntity<Map<Long ,UserDto>>(users, HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
		userService.saveUser(userDto);
		return new ResponseEntity<>("User saved to db", HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/{id}")
	public UserDto getUserById(@PathVariable Long id) {
		UserDto userDto=userService.getUserById(id);
		return userDto;
	}
	
	
	@GetMapping("/name")
	public UserDto getUserByname(@RequestParam("name") String name) {
		UserDto userDto=userService.getUserByName(name);
		return userDto;
	}
}

