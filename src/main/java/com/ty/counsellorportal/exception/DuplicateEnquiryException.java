package com.ty.counsellorportal.exception;

public class DuplicateEnquiryException extends RuntimeException {

	private String message;

	public DuplicateEnquiryException() {
	}

	public DuplicateEnquiryException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
