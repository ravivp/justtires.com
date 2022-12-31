package jt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends Base{


	By profilePicture=By.cssSelector(".oxd-userdropdown-img");
	By userName=By.cssSelector(".oxd-userdropdown-name");
	By userAccountDropdownIcon=By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	By userAccountOption=By.cssSelector("ul li a.oxd-userdropdown-link");
	

	public boolean getUserName() {
		return driver.findElement(userName).isDisplayed();
	}

	public boolean getProfilePicture() {
		return driver.findElement(profilePicture).isDisplayed();
	}

	public WebElement getUserAccountDropdownIcon() {
		return driver.findElement(userAccountDropdownIcon);
	}

	public List<WebElement> getUserAccountOption() {
		return driver.findElements(userAccountOption);
	}

	
	
	
}
