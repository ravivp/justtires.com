package jt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {

	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
        WebDriverManager.chromedriver().setup(); // it will down the chromedriver
		
		driver= new ChromeDriver(); //  it will open chrome browser 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get("https://selenium08.blogspot.com/2019/11/selenium-iframe.html");
		
		WebElement iframeElement= driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
		
		driver.switchTo().frame(iframeElement);
		driver.switchTo().parentFrame();
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='td-header-search'][@itemprop='query-input']")).sendKeys("java");
		Thread.sleep(5000);
		
		
	}
	
}
