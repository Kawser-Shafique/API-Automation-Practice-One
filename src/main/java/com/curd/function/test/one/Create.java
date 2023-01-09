package com.curd.function.test.one;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create {

	public static void post() {
		JsonObject jsObject = new JsonObject();
		jsObject.addProperty("Name", "Kawser");
		jsObject.addProperty("Location", "Queens");
		jsObject.addProperty("Institute", "Smarttech");
		jsObject.addProperty("Course", "Software-Testing");
		jsObject.addProperty("Year", "2022");

		RequestSpecification rsObject = RestAssured.given();
		rsObject.body(jsObject.toString());

		rsObject.headers("Content-Type", "application/json");

		Response response = rsObject.post("https://httpbin.org/post");
		System.out.println(response.prettyPrint());

		// Test Cases
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
		System.out.println("Data should not be Null : " + response.body().asString());
		sf.assertTrue(!response.body().asString().equals(null));

		// Attribute check
		System.out.println("Check Attribute Data is there or not : " + response.body().asString().contains("data"));
		sf.assertTrue(response.body().asString().contains("data"));

		// Attribute value check
		JsonPath jsonPath = response.jsonPath();
		System.out.println("Location Value : " + jsonPath.get("json.Location").toString());
		sf.assertEquals(jsonPath.get("json.Location").toString(), "Queens");

		sf.assertAll();
	}
}
