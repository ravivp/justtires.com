package jt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNGTestCases {

		
	@Test // it will treate as testcase
	public void orangeHrmLogin() throws InterruptedException{
		
		    WebDriver driver;
	        WebDriverManager.chromedriver().setup(); // it will down the chromedriver
			driver= new ChromeDriver(); //  it will open chrome browser 
			driver.manage().window().maximize(); 
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //
			  
			//p[text()='Username : Admin']
			//p[text()='Password : admin123']
			//label[text()='Username']
			//label[text()='Password']
			//div[contains(@class,'oxd-sheet oxd-sheet--rounded oxd-sheet-')]//p[1]
			
			 boolean heroImage= driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
			 Assert.assertTrue(heroImage);
			  
			  Thread.sleep(5000);
			 // driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
			  
			  String LoginText= driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")).getText();
			  String expectedLogin="Login";
			  Assert.assertEquals(LoginText, expectedLogin, "Verify the logon text");
			  
			// driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")).getText();
			 // String UserCred=driver.findElement(By.xpath("//div[@class='orangehrm-login-error']//div")).getText();
			  		  
			  driver.close();
		
	}
	
	
	public void dashboardPage() {
		
		  WebDriver driver;
	        WebDriverManager.chromedriver().setup(); // it will down the chromedriver
			driver= new ChromeDriver(); //  it will open chrome browser 
			driver.manage().window().maximize(); 
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //
			
		
	}
	
   
			
			
}
