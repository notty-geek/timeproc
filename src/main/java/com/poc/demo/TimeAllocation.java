package com.poc.demo;

import java.sql.Time;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "time_allocation")
public class TimeAllocation {
 @DynamoDBHashKey
 private int id;
 @DynamoDBAttribute
 private String childID;
 @DynamoDBAttribute
 private String allocatedTime;

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
 * @return the childID
 */
public String getChildID() {
	return childID;
}
/**
 * @param childID the childID to set
 */
public void setChildID(String childID) {
	this.childID = childID;
}
/**
 * @return the allocatedTime
 */
public String getAllocatedTime() {
	return allocatedTime;
}
/**
 * @param allocatedTime the allocatedTime to set
 */
public void setAllocatedTime(String allocatedTime) {
	this.allocatedTime = allocatedTime;
}
 
}
