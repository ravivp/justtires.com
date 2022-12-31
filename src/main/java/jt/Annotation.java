package jt;

import org.testng.annotations.Test;

public class Annotation {




	@Test(priority = 1)
	public void method() {
		System.out.println("1");

	}

	@Test(priority = 2)
	public void app() {

		System.out.println("2");

	}


	@Test(priority = 6, enabled = true)

	public void testcase1() {

		System.out.println("6");

	}

	@Test(priority = 7)
	public  void login() {

		System.out.println("7");

	}
	@Test(priority = 3)
	public void xyz() {

		System.out.println("3");
	}


	@Test(priority = 5)
	public void method4() {

		System.out.println("5");

	}

	@Test(priority = 4)
	public void method7() {
		System.out.println("4");

	}

	@Test(priority = 9)
	public void method8() {

		System.out.println("9");
	}

	@Test(priority = 10)
	public void mehtod9() {

		System.out.println("10");  

	}

	@Test(priority = 8)
	public void method1() {
		System.out.println("8");
	}

}
