package gt.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import core.utils.Config;
import core.utils.DriverFactory;


public class Base {
	
	
	public static WebDriver driver= null;
	//@BeforeClass(alwaysRun = true)
	public static void launchApplication() {
		
	    driver=DriverFactory.getBrowser("firfox");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		//driver.get("https://hmropensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.get(Config.getURL());
		
	}
	
	public static void quitBrowser() {
		
		driver.quit();
	}
	
	

	
	
}
