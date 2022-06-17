package com.mongo.demo.controller;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class badrequest extends RuntimeException{
	public badrequest(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}

	