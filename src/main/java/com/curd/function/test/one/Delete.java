package com.curd.function.test.one;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete {
	@Test
	public static void delete() {

		Response responseObj = RestAssured.delete("https://httpbin.org/delete");
		System.out.println(responseObj.prettyPrint());
}
}