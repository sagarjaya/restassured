package com.rest.training;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class QueryParam {

	@Test
	void query_param_1() {
		given()
		.queryParam("page", "2")
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.statusCode(200);

	}

	@Test()
	void query_param_2() {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification req=RestAssured.given();
		
		req.queryParam("page","2");
		Response res=req.get("/api/users");
		System.out.println(res.asString());
		
		System.out.println(res.getStatusCode());
	}
	}



