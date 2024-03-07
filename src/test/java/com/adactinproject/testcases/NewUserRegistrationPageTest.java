package com.adactinproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactinproject.qa.base.TestBase;
import com.adactinproject.qa.pages.NewUserRegistrationPage;
import com.adactinproject.qa.pages.SearchHotelPage;

public class NewUserRegistrationPageTest extends TestBase{
	
	NewUserRegistrationPage newregpage;
	SearchHotelPage searchhotelpage;
	
	public NewUserRegistrationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		newregpage = new NewUserRegistrationPage();
	}
	
	@Test
	public void NewUserRegistrationPageTitleTest() {
		String title = newregpage.validateRegistrationPageTitle();
		Assert.assertEquals(title, "Adactin.com - Hotel Reservation System");
	}
	
	@Test
	public void logoImageTest() {
		boolean flag = newregpage.validateAdactinimage();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void enterUserDetails() throws InterruptedException {
		newregpage = new NewUserRegistrationPage();
		newregpage.clickNewUserRegLink();
		newregpage.enterUsername("Vaishuseelan");
		newregpage.enterPassword("Flower@123");
		newregpage.enterConfirmPassword("Flower@123");
		newregpage.enterFullName("VaishnaviJayaseelan");
		newregpage.enterEmailAddress("manigandanvenket27@gmail.com");
		Thread.sleep(10000);
		newregpage.clickCheckBox();
		newregpage.clickOnRegister();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}

