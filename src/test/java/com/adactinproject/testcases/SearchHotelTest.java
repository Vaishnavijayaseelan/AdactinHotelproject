package com.adactinproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactinproject.qa.base.TestBase;
import com.adactinproject.qa.pages.LoginPage;
import com.adactinproject.qa.pages.SearchHotelPage;
import com.adactinproject.qa.pages.SelectHotelPage;

public class SearchHotelTest extends TestBase{
	LoginPage loginpage;
	SearchHotelPage searchhotelpage;
	SelectHotelPage selecthotelpage;


	public SearchHotelTest() {
		super(); // call the test base class constructor
		
	}	
		  
	@BeforeMethod
		public void SetUp() {
		initialization();
		loginpage = new LoginPage(); // to access the login page class methods
    	searchhotelpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); //to access login methods
	}
    	
    @Test
    	public void searchHotelPageTitleTest() {
    		String title = searchhotelpage.validateSearchHotelPageTitle();
    		Assert.assertEquals(title, "Adactin.com - Search Hotel");
    	}
    
    @Test
    public void userName() {
    	boolean flag = searchhotelpage.verifyCorrectUserName();
    	Assert.assertTrue(flag);
    }
    @Test
    public void selectDropDownValues() {
    	searchhotelpage.select_locationviadropdown();
    	searchhotelpage.select_hotelviadropdown();
    	searchhotelpage.select_roomtypeviadropdown();
    	searchhotelpage.select_roomnosviadropdown();	
    	searchhotelpage.enterCheckIndate("13/03/2024");
    	searchhotelpage.enterCheckOutdate("14/03/2024");
    	searchhotelpage.submit();
    }
    
    
 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
 }


			
		
	


