package com.rest.training;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PathParam {


	@Test
	void path_param1() {
		RestAssured.given()
	.pathParam("red","2")
		.when()
		.get("https://reqres.in/api/users/{red}")
		.then()
		.statusCode(200);
		
	}
	@Test()
	void path_param2() {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification req=RestAssured.given();
		req.pathParam("red", "/2");
		Response res=req.get("/api/users{red}");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.asString());

	}
}
