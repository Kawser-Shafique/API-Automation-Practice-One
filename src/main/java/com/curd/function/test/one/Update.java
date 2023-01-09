package com.curd.function.test.one;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update {
	@Test
	public static void put () {
		
		JsonObject jsObject = new JsonObject();
		jsObject.addProperty("Name", "Kawser");
		jsObject.addProperty("Location", "Jackson-Heights");
		jsObject.addProperty("Institute", "Smarttech");
		jsObject.addProperty("Course", "Software-Testing");
		jsObject.addProperty("Year", "2023");
		
		RequestSpecification rsObject = RestAssured.given();
		rsObject.body(jsObject.toString());
		
		rsObject.header("Content-Type","application/json");
		
		Response respnse = rsObject.put("https://httpbin.org/put");
		System.out.println(respnse.prettyPrint());
	}
}
