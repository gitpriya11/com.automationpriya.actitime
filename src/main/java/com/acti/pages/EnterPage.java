package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.driver.DriverManager;

public class EnterPage extends DriverManager {

	// ***************PageElements*************************//

	@FindBy(id = "logoutLink")
	WebElement logoutLink;

	@FindBy(xpath = "//a[@class=\"userProfileLink username \"]")
	WebElement userProfileText;
	
	// ************************************pageInitialization******************//

	public EnterPage() {

		PageFactory.initElements(driver, this);
	}
	// ************************************page
	// Actions/Functions******************//
     public String getUserLoggedIn()
{
	return  userProfileText.getText();
			
}
     public String getEnterPageTitle()
     {
    	 return driver.getTitle();
    	 
     }
     public void clickLogout() {
    	 
    	 logoutLink.click();
     }
}
