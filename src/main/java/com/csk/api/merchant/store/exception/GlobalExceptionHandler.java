package com.csk.api.merchant.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.csk.api.merchant.store.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("rawtypes")
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
	
	@ExceptionHandler( BadRequestException.class )
	public ResponseEntity handleHttpExceptions(BadRequestException e) {
		log.error("Bad Request Exception: {}", e.getMessage());
		ErrorResponse errorResponse = null;
		if (e.getErrorsList() != null) {
			errorResponse = new ErrorResponse(
					HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getErrorsList());
		}
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
