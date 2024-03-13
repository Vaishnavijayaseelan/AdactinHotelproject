package com.adactinproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactinproject.qa.base.TestBase;
import com.adactinproject.qa.pages.BookAHotelPage;
import com.adactinproject.qa.pages.BookedItineraryPage;
import com.adactinproject.qa.pages.BookingConfirmationPage;
import com.adactinproject.qa.pages.LoginPage;
import com.adactinproject.qa.pages.SearchHotelPage;
import com.adactinproject.qa.pages.SelectHotelPage;

public class BookedItineraryPageTest extends TestBase{
	
	LoginPage loginpage;
    SearchHotelPage searchhotelpage;
    SelectHotelPage selecthotelpage;
    BookAHotelPage bookahotelpage;
    BookingConfirmationPage bookingconfirmationpage;
    BookedItineraryPage bookeditinerarypage;
    
    public BookedItineraryPageTest() {
    	super();
    }
   
    @BeforeMethod
    public void SetUp() {
    	initialization();
    	loginpage = new LoginPage();
    	searchhotelpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
    	searchhotelpage = new SearchHotelPage();
	      selecthotelpage = new SelectHotelPage();
	      bookahotelpage = new BookAHotelPage();
	      bookingconfirmationpage = new BookingConfirmationPage();
	      bookeditinerarypage = new BookedItineraryPage();
	     searchhotelpage.select_locationviadropdown();
	     searchhotelpage.select_hotelviadropdown();
	     searchhotelpage.select_roomtypeviadropdown();
	     searchhotelpage.select_roomnosviadropdown();
	     searchhotelpage.enterCheckIndate("13/03/2024");
	     searchhotelpage.enterCheckOutdate("14/03/2024");
	     searchhotelpage.submit();
	     selecthotelpage.selectHotel();
	     selecthotelpage.selectContinue();
	     bookahotelpage.enterBookingdetails();
	     bookahotelpage.selectCreditCardDetails();
	     bookahotelpage.submit();
	     bookingconfirmationpage.validateOderNo();
	     bookingconfirmationpage.myItineraryPage();
	     
	     
    }
	
    @Test
    public void bookedItineraryPageTitleTest() {
    	String title = bookeditinerarypage.validateBookedItineraryPageTitle();
    	Assert.assertEquals(title, "Adactin.com - Select Hotel");
    	
    }
    
    
	
    @Test
   
    public void clickheretologinagainlinkTest() {
    	bookeditinerarypage.logoutPage();
    	loginpage = bookeditinerarypage.clickHereToLoginAgain();
    		
    }
   
	@AfterMethod
	 public void tearDown() {
		driver.quit();
	}

}
