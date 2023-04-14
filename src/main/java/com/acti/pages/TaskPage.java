package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.driver.DriverManager;

public class TaskPage extends DriverManager{
	
	
	// ***************PageElements*************************//

		@FindBy(id = "container_tasks")
		WebElement Tasks;
		@FindBy(linkText = "Add New") WebElement AddnewButton;
		@FindBy(xpath = "//input[@placeholder='Enter Customer Name']")
				WebElement custName;
		@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
		WebElement custDesc;
		
		@FindBy(xpath = "//div[text()='Create Customer']") WebElement createCustomer;
		
		
		
		// ************************************pageInitialization******************//
		
		public TaskPage() {
			
			PageFactory.initElements(driver, this);
		}
		// ************************************page Actions/Functions******************//
		public void clickTask( ) {
			Tasks.click();
			
		}
		public void clickAddNew( ) {
			AddnewButton.click();
			
		}
		
		public void createCustomer(String custName1, String custDesc1)
		{
			
			custName.clear();
			custName.sendKeys(custName1);
			custName.clear();
			custDesc.sendKeys(custDesc1);
			createCustomer.click();
			
			
		}
}
