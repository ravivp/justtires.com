package jt;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gt.pages.LoginPage;
import jt.test.BaseTest;

public class ReadDataFromExcel extends BaseTest {
	 
	
  
  @Test(testName = "Verify login credentials", dataProvider = "rangeWith2DArray")
  public void verifyContentOnLoginPage(String username, String password) {
	  
	  LoginPage loginPage= new LoginPage();
	// LoginPageData loginPageData=Excel.getLoginPageContent("1");
		

	   loginPage.getEnterUser().sendKeys(username);
	   loginPage.getEnterPassword().sendKeys(password);
	   loginPage.getLoginButton().click();
	 
	   String exepectedErroMessage="Invalid credentials";
	   Assert.assertTrue(loginPage.getInvalidErrorMessage().getText().equals(exepectedErroMessage), "Verify invalid credentials error message");
	  
  }
  
  @DataProvider(name = "rangeWith2DArray")
  public Object[][] rangeCalculator() {
      return new Object[][]{
              {"Admin", "admin1234"},
              {"admin10", "admin123"},
              {"admin20", "admin220"},
              {"Admin", "admin123"}
      };
  }

}
