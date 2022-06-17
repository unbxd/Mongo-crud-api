package com.mongo.demo.exceptions;

import java.util.Date;

public class ExceptionsResponse {
	private Date timestamp;
	private String message;
	private String Details;
	public ExceptionsResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		Details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return Details;
	}
	

}
