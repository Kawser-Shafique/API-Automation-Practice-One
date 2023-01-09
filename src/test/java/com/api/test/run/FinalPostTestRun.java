package com.api.test.run;

import org.testng.annotations.Test;

import com.curd.function.test.two.CreateFunctionFinal;
import com.testng.report.ExtentReport;

public class FinalPostTestRun extends ExtentReport{
	@Test
	public void postTestCases() {
		CreateFunctionFinal.post();
		CreateFunctionFinal.postTestCase();
	}
}
