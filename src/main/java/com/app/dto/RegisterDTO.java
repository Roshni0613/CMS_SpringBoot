package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private String mobileNumber;
	private String houseNumber;
	
}
