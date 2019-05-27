package com.poc.demo;

import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.lambda.runtime.Context;

public class App {

	//static final logger log=Logger
	public static Object handleRequest(Request request,Context context) throws ResourceNotFoundException {
		
		TimeAllocation ta=null;
		switch(request.getHttpMethod()) {
		case "GET":
			ta = getDynameDbMapper().load(TimeAllocation.class,request.getId());
			if(ta==null)
				throw new ResourceNotFoundException("Resource Not Found"+request.getId());
			return ta;
		case "POST":
			ta = request.getTimeAllocation();
			getDynameDbMapper().save(ta);
			return ta;
		case "PUT":
			ta = request.getTimeAllocation();
			getDynameDbMapper().save(ta);
			return ta;
		case "DELETE":			
			if(!deleteAccountByAccountId(request.getId()))
				throw new ResourceNotFoundException("Resource Not Found"+request.getId());
			
		default:
			break;
		}
		
		return "hello iam in"+request.getHttpMethod()+"request Method"+request.getId()+"id";
		
	}
	
	public static DynamoDBMapper getDynameDbMapper() {
		AmazonDynamoDB client=AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDBMapper mapper=new DynamoDBMapper(client);
		return mapper;
	}
	
	public static TimeAllocation getAccountByAccountId(Integer id) {
		TimeAllocation ta = null;
		   try {
		       DynamoDBMapper mapper = getDynameDbMapper();
		       DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		       scanExpression.addFilterCondition("id", new Condition().withComparisonOperator(ComparisonOperator.EQ).withAttributeValueList(new AttributeValue().withN(id.toString())));
		       List<TimeAllocation> accounts = mapper.scan(TimeAllocation.class, scanExpression);
		       if (accounts != null && accounts.size() > 0) {
		           ta = accounts.get(0);
		       }
		   } catch (Exception e) {
		       e.printStackTrace();
		   }
		   return ta;
		}

		

		public static Boolean deleteAccountByAccountId(int id) {
		   try {
		   	TimeAllocation ta = getAccountByAccountId(id);
		       if (ta != null) {
		           DynamoDBMapper mapper = getDynameDbMapper();
		           mapper.delete(ta);
		       } else {
		           return false;
		       }
		   } catch (Exception e) {
		       e.printStackTrace();
		       return false;
		   }
		   return true;
		}
}
