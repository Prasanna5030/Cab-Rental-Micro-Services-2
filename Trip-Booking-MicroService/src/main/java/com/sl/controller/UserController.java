package com.sl.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sl.model.UserDto;
import com.sl.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

	private final UserService userService;

	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return new ResponseEntity<List<UserDto>>( userService.getAllUsers(), HttpStatus.OK);		
	}
	
	@GetMapping("/allusers")
	public ResponseEntity<Map<Long, UserDto>> getAllUsersMap(){
		return new ResponseEntity<Map<Long, UserDto>>(userService.getAllUsersMap(),HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserbyId(@PathVariable Long id){
		return new ResponseEntity<UserDto>(userService.getUserById(id),HttpStatus.FOUND);
	}
}
