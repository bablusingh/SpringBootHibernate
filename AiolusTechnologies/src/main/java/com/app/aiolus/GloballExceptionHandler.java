package com.app.aiolus;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.aiolus.constants.Constant;
import com.app.aiolus.models.ErrorResponse;

@RestControllerAdvice
public class GloballExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		  String errorMsg = ex.getBindingResult().getFieldErrors().stream()
	                .map(DefaultMessageSourceResolvable::getDefaultMessage)
	                .findFirst()
	                .orElse(ex.getBindingResult().toString());
		  Map<String,String> msg=new HashMap<>();
		  msg.put(Constant.MESSAGE, errorMsg);
		
		return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
	}
	
	
	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex ) {
	 * 
	 * String errorMsg = ex.getBindingResult().getFieldErrors().stream()
	 * .map(DefaultMessageSourceResolvable::getDefaultMessage) .findFirst()
	 * .orElse(ex.getBindingResult().toString()); Map<String,String> msg=new
	 * HashMap<>(); msg.put(Constant.MESSAGE, errorMsg);
	 * 
	 * return new ResponseEntity(msg, HttpStatus.BAD_REQUEST); }
	 */
	
	
	/*
	 * @ExceptionHandler(MissingPathVariableException.class)
	 * 
	 * @ResponseStatus(code = HttpStatus.BAD_REQUEST) public ErrorResponse
	 * handleMissingPathVariable(HttpServletRequest
	 * request,MissingPathVariableException ex) { return new
	 * ErrorResponse(ex.getParameter()+"is missing","Path_Vaiable_Missing"); }
	 */
	  
	/*
	 * @ExceptionHandler(Exception.class)
	 * 
	 * @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR) public ErrorResponse
	 * globalException(Exception ex) { return new
	 * ErrorResponse(ex.getMessage().toString(), Constant.ERROROCCURED);
	 * 
	 * }
	 */
	/*
	 * @ExceptionHandler(NoHandlerFoundException.class)
	 * 
	 * @ResponseStatus(code = HttpStatus.NOT_FOUND)
	 * 
	 * @Order(value = 1) public ErrorResponse globalException(HttpServletRequest r
	 * ,NoHandlerFoundException ex) { return new
	 * ErrorResponse(ex.getMessage().toString(), Constant.ERROROCCURED);
	 * 
	 * }
	 */
	 
	
	

}
