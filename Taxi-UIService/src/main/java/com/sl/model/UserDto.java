package com.sl.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private Long id;
	
	private String name;

	private String email;
	
	private String password;
	
	private String mobile;
	
	private AddressDto address;
}
