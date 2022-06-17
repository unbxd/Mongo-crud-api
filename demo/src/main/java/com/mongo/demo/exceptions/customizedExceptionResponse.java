package com.mongo.demo.exceptions;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mongo.demo.controller.badrequest;
import com.mongo.demo.controller.userNotFound;
import com.mongo.demo.model.EmployeeModel;
@ControllerAdvice
@RestController
public class customizedExceptionResponse extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		ExceptionsResponse exceptionResponse=new ExceptionsResponse(new Date(),"Internal server error", request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(userNotFound.class)
	public final ResponseEntity<Object> handleAllbException(userNotFound ex, WebRequest request){
		ExceptionsResponse exceptionResponse=new ExceptionsResponse(new Date()," Data Not Found", request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
		
}
	@ExceptionHandler(badrequest.class)
	public final ResponseEntity<Object> handleAllException(badrequest ex, WebRequest request){
		ExceptionsResponse exceptionResponse=new ExceptionsResponse(new Date(),"BAD REQUEST", request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
		
}
	
	

}
