package com.mongo.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class userNotFound extends RuntimeException {

	public userNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
		
}
