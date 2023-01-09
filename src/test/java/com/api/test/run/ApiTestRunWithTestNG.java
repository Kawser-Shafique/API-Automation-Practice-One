package com.api.test.run;

import org.testng.annotations.Test;

import com.curd.function.test.one.Create;
import com.curd.function.test.one.Delete;
import com.curd.function.test.one.Read;
import com.curd.function.test.one.Update;

public class ApiTestRunWithTestNG {

	//@Test(priority = 0)
	@Test
	public void getPostTest() {
		Create.post();

	}
	//@Test(priority = 1)
	@Test(dependsOnMethods = {"getPostTest"})
	public void getUpdateTest() {
		Update.put();

	}
	//@Test(priority = 2)
	@Test(dependsOnMethods = {"getUpdateTest"})
	public void getReadTest() {
		Read.get();;

	}
	//@Test(priority = 3)
	@Test(dependsOnMethods = {"getReadTest"})
	public void getDeleteTest() {
		Delete.delete();;

	}
}
