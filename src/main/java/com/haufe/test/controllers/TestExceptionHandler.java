package com.haufe.test.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.haufe.test.exception.TestException;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class TestExceptionHandler {


	@ResponseBody
	    @ExceptionHandler(TestException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public String NotFoundHandler(TestException ex) {
	        return ex.getMessage();
	    }

}
