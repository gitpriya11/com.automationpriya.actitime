package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.acti.pages.EnterPage;


public class LoginPageTest extends BaseTest {
	
	@Test(priority =1, enabled = true)
	public void testLoginPageTitle() {

		String actual = "actiTIME - Login";
		String expected = lp.getLoginPageTitle();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
	
	}
	@Test(priority =2, enabled = true)
	public void testactiLogoisDisplayed() {
		
		boolean flag = lp.actiImgisDisplayed();
		System.out.println(flag);
		Assert.assertTrue(flag);
	

	}
	@Test(priority =3, enabled = true)
	public void testactiLinkisDisplayed() {
		
		boolean flag = lp.actiTimeLinkisDisplayed();
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority =4, enabled = true)
	public void testLoginFunction()
	{
		
		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLogin();
		EnterPage ep = new EnterPage();
		          String user = ep.getUserLoggedIn();
		         Assert.assertTrue(user.contains("John"));
		         ep.clickLogout();
		        
		
	}

}