package core.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static  WebDriver getBrowser(String browserType) {
		
		WebDriver driver= null;
		
		if(browserType.equals("chrome")) {
			ChromeOptions option= new ChromeOptions();
			option.addArguments("incognito");
			option.setHeadless(true);
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
		}else if(browserType.equals("firfox")) {
			FirefoxOptions opts = new FirefoxOptions();
			opts.addArguments("-private");
			opts.setHeadless(true);
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(opts);
		}else if(browserType.equals("edge")) {
			
			EdgeOptions options=new EdgeOptions();
			//options.addArguments("--headless");
			options.setCapability("--headless", true);
			WebDriverManager.edgedriver().forceDownload().setup();
			driver=new EdgeDriver();
		}else if(browserType.equals("headless")) {
			
			
			driver=new HtmlUnitDriver(BrowserVersion.CHROME);
		}
		
		driver.manage().window().maximize();
		return driver;
		
		
		
	}

}
