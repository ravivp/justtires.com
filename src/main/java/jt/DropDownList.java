package jt;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownList {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup(); // it will down the chromedriver
		
		driver= new ChromeDriver(); //  it will open chrome browser 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		 driver.findElement(By.xpath("//button[starts-with(@class, 'oxd-button oxd-button')]")).click();
		
		 List<WebElement> options= driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));	
		 for(WebElement element:options) {
			 
			 element.getText();
		 }
		
		 
		// driver.findElement(By.cssSelector(".--active.oxd-userdropdown")).click();
		 driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
		 driver.findElement(By.xpath("//a[text()='About']")).click();
		
		
		
		System.out.println(driver.findElement(By.xpath("//div[@class='oxd-grid-2 orangehrm-about']")).getText());
					
	     driver.findElement(By.cssSelector(".oxd-dialog-close-button.oxd-dialog-close-button-position")).click();
		
		
		
		
		/*
		 * Alert alret= driver.switchTo().alert(); alret.accept();
		 */
		 // alert 
		
		//div[@role='document']
		 

	}

}
