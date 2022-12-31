package jt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropDown {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
       WebDriverManager.chromedriver().setup(); // it will down the chromedriver
		
		driver= new ChromeDriver(); //  it will open chrome browser 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		
		
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //
		  
		  boolean heroImage= driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		  
		  Thread.sleep(5000);
		  System.out.println( driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed());
		  
		  String LoginText= driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")).getText();
		  
	
		  String UserCred=driver.findElement(By.xpath("//div[@class='orangehrm-login-error']//div")).getText();
		  
		  
		  driver.close();
		  
		 
				
			/*
			 * driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
			 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123"
			 * ); driver.findElement(By.
			 * xpath("//button[starts-with(@class, 'oxd-button oxd-button')]")).click();
			 * driver.findElement(By.
			 * xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).
			 * click();
			 */
		  
		//ul[@class='oxd-dropdown-menu']//li//a[text()='Change Password']
		  
		/*
		 * String Before="//ul[@class='oxd-dropdown-menu']//li//a[text()='"; String
		 * after="']"; String pass_parameter="Support";
		 * 
		 * 
		 * driver.findElement(By.xpath(Before +pass_parameter+ after)).click();
		 * //ul[@class='oxd-dropdown-menu']//li//a[text()='Support']
		 */
			/*
			 * List<WebElement> listelement=
			 * driver.findElements(By.xpath("//ul[@class='oxd-dropdown-menu']//li//a"));
			 * 
			 * for(WebElement items: listelement) {
			 * 
			 * if(items.getText().equals("Change Password")) {
			 * 
			 * items.click();
			 * 
			 * break; }
			 * 
			 * }
			 */
		  

	}

}
