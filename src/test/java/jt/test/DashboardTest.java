package jt.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import jt.app.App;
import jt.data.Excel;
import jt.data.LoginPageData;

public class DashboardTest extends BaseTest {

  
  
  @Test(testName = "verify useraccount")
  public void verifyUserAccount() {
	  

		SoftAssert soft= new SoftAssert();

		App app=new App();
		LoginPageData loginPageData=Excel.getLoginPageContent("1");

		app.loginPage.getEnterUser().sendKeys(loginPageData.getUsername());;
		app.loginPage.getEnterPassword().sendKeys(loginPageData.getPassword());;
		app.loginPage.getLoginButton().click();
		
	    soft.assertTrue(app.dashboardPage.getUserName(), "verify username on dashboard page");
	    soft.assertTrue(app.dashboardPage.getProfilePicture(), "verify profile picture");
	    soft.assertTrue(app.dashboardPage.getUserAccountDropdownIcon().isDisplayed(), "user icon");
	    soft.assertAll();
	    
	    
	  
  }
}
