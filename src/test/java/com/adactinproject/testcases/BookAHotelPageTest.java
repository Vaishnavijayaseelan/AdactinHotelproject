package com.adactinproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactinproject.qa.base.TestBase;
import com.adactinproject.qa.pages.BookAHotelPage;
import com.adactinproject.qa.pages.LoginPage;
import com.adactinproject.qa.pages.SearchHotelPage;
import com.adactinproject.qa.pages.SelectHotelPage;

public class BookAHotelPageTest extends TestBase{
     LoginPage loginpage;
     SearchHotelPage searchhotelpage;
     SelectHotelPage selecthotelpage;
     BookAHotelPage bookahotelpage;
     
 public BookAHotelPageTest () {
	 super();
 }
	
 
     @BeforeMethod
        public void SetUp() {
	      initialization();
	     LoginPage loginpage = new LoginPage();  // to access the login page class methods
	     searchhotelpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); // to access
		// login method
	     
	      searchhotelpage = new SearchHotelPage();
	      selecthotelpage = new SelectHotelPage();
	      bookahotelpage = new BookAHotelPage();
	     searchhotelpage.select_locationviadropdown();
	     searchhotelpage.select_hotelviadropdown();
	     searchhotelpage.select_roomtypeviadropdown();
	     searchhotelpage.select_roomnosviadropdown();
	     searchhotelpage.enterCheckIndate("10/03/2024");
	     searchhotelpage.enterCheckOutdate("12/03/2024");
	     searchhotelpage.submit();
	     selecthotelpage.selectHotel();
	     selecthotelpage.selectContinue();
     }
	  
	 @Test
	 public void bookAHotelPageTitleTest() {
		     String title = bookahotelpage.validateBookAHotelPageTitle();
			Assert.assertEquals(title, "Adactin.com - Book A Hotel");	 
	 }
	 
	 @Test
	 public void userDetailsTest() {
		 bookahotelpage.enterBookingdetails();
		  
	 }
	 @Test
	  public void creditCardDetailsTest() {
		  bookahotelpage.selectCreditCardDetails();
	  }
	 
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }
  }
 
 

