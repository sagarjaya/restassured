package com.rest.training;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//test get4 matcher
import static org.hamcrest.Matchers.*;

public class GetRequest {	
	
	@Test()
	void test_get1() {
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		//System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		int num=response.getStatusCode();
		Assert.assertEquals(num, 200);	
	}
	
	@Test()
	void test_get2() {
		RestAssured.given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200);
	}
	
	// using log
	@Test()
	void test_get3() {
		RestAssured.given()
		.header("Content-Type","Application/json")
		.contentType(ContentType.JSON)
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();
	}
	  //validating body
	@Test()
	void test_get4() {
		RestAssured.given()
		.header("Content-Type","Application/json")
		.contentType(ContentType.JSON)
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]",equalTo(7)) // import matcher   //validating id
		.body("data.first_name",hasItems("Michael","Lindsay","Tobias")); //valid firstname whether its in body or not
	}
	
	
	
}
