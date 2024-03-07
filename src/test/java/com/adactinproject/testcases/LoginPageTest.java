package com.adactinproject.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactinproject.qa.base.TestBase;
import com.adactinproject.qa.pages.LoginPage;
import com.adactinproject.qa.pages.SearchHotelPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	SearchHotelPage searchhotelpage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage = new LoginPage();
		
	}
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Adactin.com - Hotel Reservation System");	
	}
	
	@Test(priority = 2)
	public void logoImageTest() {
		boolean flag = loginpage.validateAdactinimage();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority =3)
	public void loginTest() {
		searchhotelpage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
