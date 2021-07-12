package com.gonzalo.consultorio.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String message) {
		super(message);
		
	}
}
