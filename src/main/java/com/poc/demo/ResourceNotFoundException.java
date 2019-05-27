package com.poc.demo;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends Exception {

	private String message;
	
	public ResourceNotFoundException(String message) {
		this.message=message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
