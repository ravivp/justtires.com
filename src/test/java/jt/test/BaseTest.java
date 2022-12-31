package jt.test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import jt.app.App;
import jt.pages.Base;

public class BaseTest {
	
	
	@BeforeMethod(alwaysRun = true)
	public void getdriver() {
		
		Base.launchApplication();
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void quiteBrowser() {
		
		Base.quitBrowser();
	}

}
