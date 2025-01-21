package com.ty.counsellorportal.exception;

public class DuplicateEmailException extends RuntimeException {

	private String message;

	public DuplicateEmailException() {
	}

	public DuplicateEmailException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
