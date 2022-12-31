package core.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import jt.pages.Base;

public class Takescreenshot extends Base{
	
	public static String takescreenshot(String screenshotName) {
		
		String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file =ts.getScreenshotAs(OutputType.FILE);
		File finnalDestination= new File(path);
		try {
			FileUtils.copyFile(file, finnalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}

}
