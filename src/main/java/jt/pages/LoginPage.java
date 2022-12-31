package jt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Base {


	
	By heroImage=By.cssSelector(".orangehrm-login-branding img");

	By loginText=By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
	By enterUser= By.xpath("//input[@name='username']");
	By enterPassword= By.xpath("//input[@name='password']");
	By loginButton= By.xpath("//button[starts-with(@class, 'oxd-button oxd-button')]");
	By invalidErrorMessage=By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
	By invalidErrorIcon=By.xpath("//i[@class='oxd-icon bi-exclamation-circle oxd-alert-content-icon']");
    By userNameText = By.xpath("(//p[@class=\"oxd-text oxd-text--p\"])[1]");
    By passwordText = By.xpath("(//p[@class=\"oxd-text oxd-text--p\"])[2]");
    

	public boolean getHeroImage() {
		
		
		return driver.findElement(heroImage).isDisplayed();
	}
	public String getLoginText() {

		return driver.findElement(loginText).getText();
	}
	public WebElement getEnterUser() {
		return driver.findElement(enterUser);
	}

	public WebElement getEnterPassword() { 
		return driver.findElement(enterPassword);
	}

	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	public WebElement getInvalidErrorMessage() {

		return driver.findElement(invalidErrorMessage);
	}
	public boolean getInvalidErrorIcon() {
		return driver.findElement(invalidErrorIcon).isDisplayed();
	}
	public String getUserNameText() {
		return driver.findElement(userNameText).getText();
	}
	public String getPasswordText() {
		return driver.findElement(passwordText).getText();
	}
	
	
	
	
   






}
