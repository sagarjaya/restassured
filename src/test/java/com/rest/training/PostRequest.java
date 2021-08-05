package com.rest.training;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.*;

public class PostRequest {

	
	@Test()
	void test_post1() {// printing on the console
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name","morpheus");
		map.put("job","leader");
		System.out.println(map);
		Reporter.log("hello",true); //will print on the console
		Reporter.log("hello");// will create newfolder of test-output
	}
	@Test()
	void test_post2() { // using json simple dependency
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name","morpheus");
		map.put("job","leader");
		JSONObject req=new JSONObject(map);
		System.out.println(req);
		System.out.println(req.toJSONString());		
	}
	
	
	@Test()
	void test_post3() { // validating
		JSONObject req=new JSONObject();
		req.put("name","abc");
		req.put("job","leader");
		System.out.println(req);
		RestAssured.given()
		
		.body(req.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
	
	}
	


	@Test()
	void test_post4() { // using json simple dependency
		RestAssured.given()
		.header("Content-Type","Application/Json")
		.when()
		.body("{\r\n"+
		"  \"name\":\"sagar\",\r\n" +
		"  \"job\":\"test\"\r\n"
		+"}")
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
	}
	
}
