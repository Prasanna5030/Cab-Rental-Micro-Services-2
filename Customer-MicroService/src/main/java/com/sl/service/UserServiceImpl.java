package com.sl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.Dto.AddressDto;
import com.sl.Dto.UserDto;
import com.sl.entity.Address;
import com.sl.entity.User;
import com.sl.exception.UserNotFoundException;
import com.sl.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<UserDto> getAllUsers() {
		 List<User> users=userRepository.findAll();
		 
		
		 List<UserDto> allUsers= users.stream().map((user)-> UserDto.builder().id(user.getId())
				 																		.name(user.getName())
				 																		.email(user.getEmail())
				 																		.mobile(user.getMobile())
				 																	    .address( AddressDto.builder().id(user.getAddress().getId())
				 																				.city(user.getAddress().getCity())
				 																				.state(user.getAddress().getState())
				 																				.pincode(user.getAddress().getPincode())
				 																				.build())
				 																	    .build()).collect(Collectors.toList());	
		 return allUsers;
	}

	@Override
	public UserDto getUserById(Long id) {
		User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found"));
		

		UserDto userDto= UserDto.builder()
										.id(user.getId())
										.name(user.getName())
										.email(user.getEmail())
										.mobile(user.getEmail())
										.address(getAddressDto(user))
										.password(user.getPassword())
										.build();
		return userDto;
	}

	@Override
	public User saveUser(UserDto userDto) {
	
		
		User user = User.builder()
				.id(userDto.getId())
				.name(userDto.getName())
				.email(userDto.getEmail())
				.mobile(userDto.getMobile())
				.address( getUserAddress(userDto))
				.password(userDto.getPassword())
						.build();
		
	return	userRepository.save(user);
		
	}

	@Override
	public UserDto getUserByName(String name) {
	User user=	userRepository.findByName(name).orElseThrow(()-> new UserNotFoundException("user with "+ name +"not exists"));	
	UserDto userDto = UserDto.builder().id(user.getId())
			.name(user.getName())
			.email(user.getEmail())
			.mobile(user.getEmail())
			.address(getAddressDto(user))
			.password(user.getPassword())
			
			.build();
	
	return userDto;
	}


    public Address getUserAddress(UserDto userDto) {
Address address= Address.builder().id(userDto.getAddress().getId())
			.city(userDto.getAddress().getCity())
			.state(userDto.getAddress().getState())
			.pincode(userDto.getAddress().getPincode()).build();	
return address;
}

   public AddressDto getAddressDto(User user) {
	AddressDto addressDto= AddressDto.builder().id(user.getAddress().getId())
			.city(user.getAddress().getCity())
			.state(user.getAddress().getState())
			.pincode(user.getAddress().getPincode())
			.build();
	
	return addressDto;
}

@Override
public Map<Long , UserDto> getAllUsersMap() {
	 List<User> users=userRepository.findAll();
	 
	 Map<Long, UserDto> allUsers= new HashMap<>();
	 
	 
	 List<UserDto> allUsersDto= users.stream().map((user)-> UserDto.builder().id(user.getId())
				.name(user.getName())
				.email(user.getEmail())
				.mobile(user.getMobile())
			    .address( AddressDto.builder().id(user.getAddress().getId())
						.city(user.getAddress().getCity())
						.state(user.getAddress().getState())
						.pincode(user.getAddress().getPincode())
						.build())
			    .build()).collect(Collectors.toList());	
	 
	 for (UserDto user : allUsersDto) {
		 allUsers.put(user.getId() , user);
		 
	  }
	
	return allUsers;
}
}