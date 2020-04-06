package com.codelovin.h2demo;

import java.util.Date;

public class CustomExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;
	
	public CustomExceptionResponse(Date timestamp, String errorMessage, String errorDetails) {
		this.timestamp = timestamp;
		this.message = errorMessage;
		this.details = errorDetails;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}
	
	public String getDetails() {
		return details;
	}
}
