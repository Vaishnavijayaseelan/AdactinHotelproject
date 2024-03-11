package com.adactinproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.adactinproject.qa.base.TestBase;
import com.adactinproject.qa.pages.LoginPage;
import com.adactinproject.qa.pages.SearchHotelPage;
import com.adactinproject.qa.pages.SelectHotelPage;

   public class SelectHotelTest extends TestBase{
	LoginPage loginpage;
    SearchHotelPage searchhotelpage;
    SelectHotelPage selecthotelpage;


   public SelectHotelTest() {
	super();
		
}
   
   @BeforeMethod
   public void SetUp() {
	   initialization();
	   loginpage = new LoginPage();
	   searchhotelpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	   
	    
	    selecthotelpage = new SelectHotelPage();	    
	    searchhotelpage.select_locationviadropdown();
	   	searchhotelpage.select_hotelviadropdown();
	   	searchhotelpage.select_roomtypeviadropdown();
	   	searchhotelpage.select_roomnosviadropdown();	
	   	searchhotelpage.enterCheckIndate("10/03/2024");
	   	searchhotelpage.enterCheckOutdate("12/03/2024");
	   	searchhotelpage.submit();
	   
	   
	   
	
   }
   
   @Test(priority = 1)
   public void validateSelectHotelTitlePage() {
	   String title = selecthotelpage.validateSelectHotelPageTitle();
	   Assert.assertEquals(title, "Adactin.com - Select Hotel");
   }
	
   @Test(priority = 2)
   public void SelectHotelBtn() {
	   selecthotelpage.selectHotel();
	   selecthotelpage.selectContinue();
   }
   
   @AfterMethod
   public void tearDown() {
	   driver.quit();
   }
}