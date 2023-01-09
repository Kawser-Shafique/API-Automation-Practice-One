package com.curd.function.test.one;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Read {
	@Test
	public static void get() {
		Response response = RestAssured.get("https://httpbin.org/get");
		System.out.println(response.prettyPrint());
	}

}
