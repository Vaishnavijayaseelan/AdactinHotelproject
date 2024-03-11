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

import net.bytebuddy.implementation.bind.annotation.Super;

public class BookingConfirmationPageTest extends TestBase{
	LoginPage loginpage;
    SearchHotelPage searchhotelpage;
    SelectHotelPage selecthotelpage;
    BookAHotelPage bookahotelpage;
    BookingConfirmationPage bookingconfirmationpage;
    BookedItineraryPage bookeditinerarypage;
    
    public BookingConfirmationPageTest() {
    	 super();
  
    }
    
    @BeforeMethod
    public void setUp() {
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
	     searchhotelpage.enterCheckIndate("10/03/2024");
	     searchhotelpage.enterCheckOutdate("12/03/2024");
	     searchhotelpage.submit();
	     selecthotelpage.selectHotel();
	     selecthotelpage.selectContinue();
	     bookahotelpage.enterBookingdetails();
	     bookahotelpage.selectCreditCardDetails();
	     bookahotelpage.submit();
    }

    @Test 
    public void BookingConfirmationPageTitle() {
    	String title = bookingconfirmationpage.vadidateBookingConfirmationTitle();
    	Assert.assertEquals(title, "Adactin.com - Book A Hotel");
    }
    
    @Test
    public void orderNoTest() {
    	bookingconfirmationpage.validateOderNo();
    }
    
    @Test
    public void myItineraryTest() {
    	bookingconfirmationpage.myItineraryPage();
    }
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    	
    }
}
