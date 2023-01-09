package com.cucumber.test;

import com.curd.function.test.two.CreateFunctionFinal;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef {

	@Given("setup test data into json & use post method")
	public void setup() {
		CreateFunctionFinal.post();
	}

	@Then("validate test cases")
	public void postTestCasesValidate() {
		CreateFunctionFinal.postTestCase();
	}
}
