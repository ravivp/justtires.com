package jt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {

	public static void main(String[] args) {
	
		WebDriver driver;
		  
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Test");
		driver.findElement(By.name("lastname")).sendKeys("Test2");
		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
		driver.findElement(By.id("password_step_input")).sendKeys("Test2@123");
		WebElement selectDay= driver.findElement(By.xpath("//select[@id='day']"));
		
		Select selectday = new Select(selectDay);
		
		selectday.selectByValue("19"); 
		selectday.deselectByIndex(1);
		
		
		// when tagname is select for dropdown than we can use Select class 
		
		// 
		
		
		//Indonesia,  india, japan, france
		
		
		Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']"))); 
		selectMonth.selectByIndex(5);
		Select selectYear= new Select(driver.findElement(By.xpath("//select[@id='year']")));
		selectYear.selectByIndex(5);
		   
		
		    		

	}

}
