package jt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelector {

	public static void main(String[] args) {
		
		
		WebDriver driver;
        WebDriverManager.chromedriver().setup(); // it will down the chromedriver
		
		driver= new ChromeDriver(); //  it will open chrome browser 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("admin123");
		//driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//driver.findElement(By.cssSelector("button[class*='oxd-button--medium oxd-button']")).click();
		
		driver.findElement(By.cssSelector("button[class^='oxd-button oxd-button--medium']")).click();
		//driver.findElement(By.cssSelector("button[class$='--main orangehrm-login-button']")).click();
		
	  // driver.findElement(By.cssSelector("i[class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();	
	  // driver.findElement(By.cssSelector("ul[class='oxd-dropdown-menu'] li:first-of-type a")).click();
	  // driver.findElement(By.cssSelector("ul[class='oxd-dropdown-menu'] li:last-of-type a")).click();
	   //driver.findElement(By.cssSelector("ul[class='oxd-dropdown-menu'] li:nth-of-type(2)")).click();
	  // driver.findElement(By.cssSelector("ul[class='oxd-dropdown-menu'] :nth-child(3) a")).click();
	   
	}

}
