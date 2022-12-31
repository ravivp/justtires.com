package jt;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(); //  it will open chrome browser 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Forgotten password?")).click();
		
		
		//Forgotten account?
		
		String parent= driver.getWindowHandle(); // current window id
		System.out.println(parent);
		
		driver.findElement(By.linkText("Forgotten account?")).click();
		/*
		 * Thread.sleep(5000); driver.navigate().back();
		 * 
		 * Thread.sleep(5000); driver.navigate().forward();
		 */
        Set<String> windows= driver.getWindowHandles();
		
		for(String w:windows) {
			
			System.out.println(w);
		
			if(!w.equalsIgnoreCase(parent)) {
				
				
				driver.switchTo().window(w);
				driver.findElement(By.cssSelector("input[name='email'][placeholder='Email or phone']")).sendKeys("test@gmail.com");
				//driver.findElement(By.cssSelector("#lastName")).sendKeys("window");
				
				Thread.sleep(5000);
				
			  driver.close();
			  
				
			}
		}
		
		driver.switchTo().window(parent);
		driver.findElement(By.cssSelector("input[name='pass'][placeholder='Password']")).sendKeys("test@123");
		
		
	}

}
