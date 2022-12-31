package jt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertOrPopUp {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		
		
        WebDriverManager.chromedriver().setup(); // it will down the chromedriver
		
		driver= new ChromeDriver(); //  it will open chrome browser 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		/*
		 * driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		 * driver.findElement(By.cssSelector("input.signinbtn")).click(); Alert alert=
		 * driver.switchTo().alert(); System.out.println(alert.getText());
		 * alert.accept();
		 */
		
		driver.get("https://www.facebook.com/");
		
	       driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
	       Thread.sleep(5000);
	       
	       driver.navigate().back();
	       Thread.sleep(5000);
	       driver.navigate().forward(); 
	       Thread.sleep(5000);
	       driver.navigate().refresh();
	       Thread.sleep(5000);
	      
		

	}

}
