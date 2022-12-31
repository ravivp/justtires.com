package jt.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import core.utils.Config;
import core.utils.*;


public class Base {
	
	
	public static WebDriver driver= null;
	//@BeforeClass(alwaysRun = true)
	public static void launchApplication() {
		
	    driver=DriverFactory.getBrowser("chrome");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		//driver.get("https://hmropensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.get(Config.getURL());
		
	}
	
	public static void quitBrowser() {
		
		driver.quit();
	}
	
	

	
	
}
