package com.curd.function.test.two;

import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateFunctionFinal {
	static Response response;

	public static void post() {

		JsonObject jsObject = new JsonObject();
		jsObject.addProperty("Batch", "29");

		RequestSpecification rsObject = RestAssured.given();
		rsObject.body(jsObject.toString());

		rsObject.headers("Content-Type", "application/json");

		response = rsObject.post("https://httpbin.org/post");
		System.out.println(response.prettyPrint());

	}

	public static void postTestCase() {
		SoftAssert sa = new SoftAssert();
		// System.out.println(response.statusCode()==200);
		sa.assertTrue(response.statusCode() == 200);

		// System.out.println(response.time()<3000);
		sa.assertTrue(response.time() < 3000);

		// System.out.println(response.contentType().contains("json"));
		sa.assertTrue(response.contentType().contains("json"));

		// System.out.println(!response.body().asString().equals(null));
		sa.assertTrue(!response.body().asString().equals(null));

		// System.out.println(response.body().asString().contains("Batch"));
		sa.assertTrue(response.body().asString().contains("Batch"));

		JsonPath jsonPath = response.jsonPath();
		// System.out.println("Location Value : " +)
		// jsonPath.get("json.Batch").toString());
		sa.assertTrue(jsonPath.get("json.Batch").toString().contains("29"));

		sa.assertAll();
	}
}
