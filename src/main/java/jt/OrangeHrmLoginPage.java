package jt;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.utils.Config;
import gt.pages.Base;
import jt.data.Excel;
import jt.data.LoginPageData;



public class OrangeHrmLoginPage extends Base {

	
 LoginPageData loginContent=Excel.getLoginPageContent("1");
 
	
	  @Test(priority = 1, testName = "GDYR-1729") public void validateContent() {
	  
	  boolean heroImage=
	  driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	  Assert.assertTrue(heroImage); String LoginText= driver.findElement(By.
	  xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")).getText(
	  );
	  
	  Assert.assertEquals(LoginText, loginContent.getLogin(),
	  "verify the login content");
	  
	  String actualTitle= driver.getTitle(); String expected="OrangeHRM";
	  Assert.assertEquals(actualTitle, expected,"Verify the title "); }
	 
   
   @Test(priority = 1, enabled = true)
   public void VerifyInvalidCred() {
	   
	   driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Config.getUser());
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Config.getPasswod());
	   driver.findElement(By.xpath("//button[starts-with(@class, 'oxd-button oxd-button')]")).click();
	   String actualErroMessage= driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
	   String exepectedErroMessage="Invalid credentials";
	   
	 //  Assert.assertEquals(actualErroMessage, exepectedErroMessage);
	   
   }
   
	
	  @Test(priority = 3)
	  public void VerifyValidCred() {
	  
	  System.out.println("executing VerifyValidCred testcase");
	  
	  
	  }
	 
	
}
