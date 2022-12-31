package jt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeachDropDownOption {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
        WebDriverManager.chromedriver().setup(); // it will down the chromedriver
		
		driver= new ChromeDriver(); //  it will open chrome browser 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get("https://www.flipkart.com/");
		
		Thread.sleep(5000);
		driver.findElement(By.className("_2KpZ6l _2doB4z")).click();
		
		driver.findElement(By.className("oxd-text oxd-text--h5 orangehrm-login-title"));
		Thread.sleep(5000);
		driver.findElement(By.className("_3704LK")).sendKeys("laptop");
	    List<WebElement>	laptopOption= driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']//li//div//a"));
	    
	    for(WebElement options:laptopOption ) {
	    	
	    	String optionsname= options.getText();
	    	System.out.println(optionsname);
	    	
	    }
		
		
		
	}

}
