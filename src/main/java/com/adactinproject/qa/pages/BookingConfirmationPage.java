package com.adactinproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinproject.qa.base.TestBase;

public class BookingConfirmationPage extends TestBase{
	
	@FindBy(xpath = "//input[@id='order_no']")
	WebElement orderNo;
	
	@FindBy(xpath = "//input[@id='search_hotel']")
	WebElement searchHotelBtn;
	
	@FindBy(xpath = "//input[@id='my_itinerary']")
	WebElement myItineraryBtn;
	
	
	
	
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String vadidateBookingConfirmationTitle() {
		return driver.getTitle();
		
	}
	public boolean validateOderNo() {
		return orderNo.isDisplayed();
	}
	public BookedItineraryPage myItineraryPage() {
		myItineraryBtn.click();
		return new BookedItineraryPage();
	}
	
}

