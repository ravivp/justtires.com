package jt;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import gt.pages.Base;

public class DashboardPage extends Base {
 
  
  @Test
  public void verifyUser() {
	  
	  
	     driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		 driver.findElement(By.xpath("//button[starts-with(@class, 'oxd-button oxd-button')]")).click();
		 driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"));
		 
		 driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']//li//a[text()='Change Password']")).click();
  }
  
}
