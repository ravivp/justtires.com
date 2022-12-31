package jt;



import org.openqa.selenium.By;

import jt.data.Excel;
import jt.data.LoginPageData;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import gt.pages.*;


 
public class HardAssertion extends Base  {
	

	LoginPage loginPage= new LoginPage();
	LoginPageData loginContent= Excel.getLoginPageContent("1");
	
	@Test(groups = {"sanity"})
	public void validateContent() {
		
		//LoginPage loginPage= new LoginPage(driver);
		SoftAssert soft= new SoftAssert();
		//soft.assertTrue(loginPage.getHeroImage(), "Verify the hero image");
		soft.assertTrue(loginPage.getLoginText().equals(loginContent.getLogin()), "Verify the login text");
		
	
		driver.close();
		soft.assertAll();
		
	}
	
	@Test(groups = {"regression"})
	public void login() {
		
		System.out.println("regression suite");
	}


}
