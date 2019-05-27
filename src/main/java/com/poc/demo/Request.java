package com.poc.demo;

public class Request {
	private String httpMethod;
	private int id;
	private TimeAllocation timeAllocation;
	/**
	 * @return the httpMethod
	 */
	public String getHttpMethod() {
		return httpMethod;
	}
	/**
	 * @param httpMethod the httpMethod to set
	 */
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the timeAllocation
	 */
	public TimeAllocation getTimeAllocation() {
		return timeAllocation;
	}
	/**
	 * @param timeAllocation the timeAllocation to set
	 */
	public void setTimeAllocation(TimeAllocation timeAllocation) {
		this.timeAllocation = timeAllocation;
	}
	
	

}
