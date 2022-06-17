package com.mongo.demo.controller;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
//override default error
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class intrnalservererror extends RuntimeException{
	public intrnalservererror(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}

	