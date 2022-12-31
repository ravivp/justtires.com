package jt.test;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import gt.app.App;
import jt.data.Excel;
import jt.data.LoginPageData;

public class loginOrangeTest extends BaseTest{

	App app=new App();
	LoginPageData loginPageData=Excel.getLoginPageContent("1");
	@Test(testName = "Verify login credentials", dataProvider = "rangeWith2DArray")
	public void verifyInvalideCredentianal(String username, String password) {

		SoftAssert soft= new SoftAssert();

		app.loginPage.getEnterUser().sendKeys(username);
		app.loginPage.getEnterPassword().sendKeys(password);
		app.loginPage.getLoginButton().click();

		soft.assertTrue(app.loginPage.getInvalidErrorMessage().getText().equals(loginPageData.getErrorMessage()), "Verify invalid credentials error message");
		soft.assertTrue(app.loginPage.getInvalidErrorIcon(), "verify invalide error icon");
		soft.assertAll();

	}


	@Test(testName = "contentvalidation")
	public void verifyContentOnLoginPage() {
		
		SoftAssert soft= new SoftAssert();

		soft.assertTrue(app.loginPage.getHeroImage(), "Verify the hero image"); 
		soft.assertTrue(app.loginPage.getLoginText().equals(loginPageData.getLogin()), "verify the login text");
		soft.assertTrue(app.loginPage.getUserNameText().equals(loginPageData.getUsernaneText()), "Verify username text");
		soft.assertTrue(app.loginPage.getPasswordText().equals(loginPageData.getPasswordText()), "verify password text");
		soft.assertAll();
	}



	@DataProvider(name = "rangeWith2DArray")
	public Object[][] rangeCalculator() {
		return new Object[][]{
			{"Admin", "admin1234"},
			{"admin10", "admin123"},
			{"admin20", "admin220"}
		};
	}

}
