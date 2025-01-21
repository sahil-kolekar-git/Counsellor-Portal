package com.ty.counsellorportal.exception;

public class CounsellorNotFoundException extends RuntimeException {

	private String message;

	public CounsellorNotFoundException() {
	}

	public CounsellorNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
