package com.curd.function.test;

import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateFunction {

	public static void post() {

		// Write test data
		JsonObject jsObject = new JsonObject();
		jsObject.addProperty("Name", "Kawser");
		jsObject.addProperty("Location", "Queens");
		jsObject.addProperty("Institute", "Smarttech");
		jsObject.addProperty("Course", "Software-Testing");
		jsObject.addProperty("Year", "2022");
		
		// Add Json data inside body
		RequestSpecification rsObject = RestAssured.given();
		rsObject.body(jsObject.toString());

		// Test data format in Header
		rsObject.header("Content-Type", "application/json");

		// Use post method and send new data via post URL
		Response response = rsObject.post("https://httpbin.org/post");
		System.out.println(response.prettyPrint());

		// Status code = 200
		System.out.println("Status code Found : " + response.statusCode());
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(response.statusCode(), 200);

		// Respose Time
		System.out.println("Response Time Found : " + response.time());
		sf.assertTrue(response.time() < 2000);

		// content type check = data format
		System.out.println("Data Format Found : " + response.contentType());
		sf.assertTrue(response.contentType().contains("json"));

		// Data Null or Not check
		System.out.println("Data should not be Null : " + response.body());
		sf.assertTrue(!response.body().equals(null));

		sf.assertAll();
	}

}
