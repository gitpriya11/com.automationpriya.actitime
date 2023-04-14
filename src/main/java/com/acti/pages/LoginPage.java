package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.driver.DriverManager;

public class LoginPage extends DriverManager {

	// ***************PageElements*************************//

	@FindBy(id = "username")
	WebElement usernameField;
	@FindBy(name = "pwd")
	WebElement passwordField;
	@FindBy(xpath = "//div[text()='Login ']")
	WebElement loginButton;
	@FindBy(className = "atLogoImg")
	WebElement actiImg;
	@FindBy(linkText = "actiTIME Inc.")
	WebElement actiTimeLink;
	
	// ************************************pageInitialization******************//
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	// ************************************page Actions/Functions******************//
	
	public boolean actiImgisDisplayed() {
		return actiImg.isDisplayed();
	}
	
	public boolean actiTimeLinkisDisplayed() {
		return actiTimeLink.isDisplayed();
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public void enterUsername(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);
		
	}
	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
		
		
	}
	public void clickLogin( ) {
		loginButton.click();
		
	}
}
