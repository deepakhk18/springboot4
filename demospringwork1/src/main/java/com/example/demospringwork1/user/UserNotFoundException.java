package com.example.demospringwork1.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

	public UserNotFoundException(String arg0) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
