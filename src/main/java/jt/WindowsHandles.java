package jt;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandles {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
        WebDriverManager.chromedriver().setup(); // it will down the chromedriver
		
		driver= new ChromeDriver(); //  it will open chrome browser 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Forgotten password?")).click();
		String parentWindow= driver.getWindowHandle(); //12345
		
		driver.findElement(By.linkText("Forgotten account?")).click();
		
		Thread.sleep(5000);
		
		Set<String> listOfWindows= driver.getWindowHandles();
		
		
		for(String windows: listOfWindows) {
			
			// windows has parentid = 12345
			//windows has child id= 98761
			
			if(!windows.equals(parentWindow)) {   // 12345== 12345 = !true= false
				
				// 98761=12345= !false= true 
				
				
				driver.switchTo().window(windows);  // windows has child id 
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//input[@name='email'][@placeholder='Email or phone']")).sendKeys("test");
			}
			
		}
		
		//driver.close(); // child window
		driver.switchTo().window(parentWindow);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("password");
							 
	}

}
