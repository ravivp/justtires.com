package jt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUp {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
       WebDriverManager.chromedriver().setup(); // it will down the chromedriver
		
		driver= new ChromeDriver(); //  it will open chrome browser 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("test");
		
		driver.findElement(By.xpath("//input[@class='signinbtn']")).click();
		
		Alert alert= driver.switchTo().alert();
		
		Thread.sleep(5000); // we just pause execution 
		String alertMsg= alert.getText();
		if(alertMsg.equals("Please enter a valid user name")) {
			
			System.out.println(alertMsg);
			System.out.println("this is expected");
		}else if(alertMsg.equals("Please enter your password")) {
			
			System.out.println(alertMsg);
			System.out.println("this is expected");
		}else {
			
			System.out.println(alertMsg);
			System.out.println("this is not expected");
		}
		
		alert.accept();
		//alert.dismiss();
		
		

	}

}
