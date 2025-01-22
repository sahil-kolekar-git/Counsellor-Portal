package com.ty.counsellorportal.exception;

public class EnquiryNotFoundException extends RuntimeException {

	private String message;

	public EnquiryNotFoundException() {
	}

	public EnquiryNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
