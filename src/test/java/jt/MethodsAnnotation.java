package jt;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MethodsAnnotation {
	/*
	 * @Test public void f() { }
	 */


	@BeforeMethod
	public void beforemethod() {

		System.out.println("Excuted before method");
	}

	@Test
	public void testcases() {

		System.out.println("testcases1 ");
	}

	@Test
	public void testcsae2() {

		System.out.println("testcases2");
	}
	@AfterMethod
	public void afteremethod() {

		System.out.println("Excuted after method");
	}

}
