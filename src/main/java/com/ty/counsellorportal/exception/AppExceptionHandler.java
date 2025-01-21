package com.ty.counsellorportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<String> catchDuplicateEmailException(DuplicateEmailException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CounsellorNotFoundException.class)
	public ResponseEntity<String> catchCounsellorNotFoundException(CounsellorNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
