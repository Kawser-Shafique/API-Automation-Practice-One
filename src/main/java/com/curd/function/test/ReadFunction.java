package com.curd.function.test;

import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadFunction {

	public static void get() {
		
		Response responseObj = RestAssured.get("https://httpbin.org/get");
		System.out.println(responseObj.prettyPrint());

		// Status code = 200
		System.out.println("Status code Found : " + responseObj.statusCode());
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(responseObj.statusCode(), 200);

		// Respose Time
		System.out.println("Response Time Found : " + responseObj.time());
		sf.assertTrue(responseObj.time() < 2000);

		// content type check = data format
		System.out.println("Data Format Found : " + responseObj.contentType());
		sf.assertTrue(responseObj.contentType().contains("json"));

		// Data Null or Not check
		System.out.println("Data should not be Null : " + responseObj.body());
		sf.assertTrue(!responseObj.body().equals(null));

		sf.assertAll();
	}
}
