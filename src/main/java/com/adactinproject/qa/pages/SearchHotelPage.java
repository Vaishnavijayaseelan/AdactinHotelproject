package com.adactinproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.adactinproject.qa.base.TestBase;

public class SearchHotelPage extends TestBase {
	
	@FindBy(xpath = "//input[@value='Hello 9943611595!']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//select[@id='location']")
	WebElement location;
	
	@FindBy(xpath = "//select[@id='hotels']")
	WebElement hotels;
	
	@FindBy(xpath = "//select[@id='room_type']")
	WebElement roomType;
	
	@FindBy(xpath = "//select[@id='room_nos']")
	WebElement roomNos;
	
	@FindBy(xpath = "//input[@id='datepick_in']")
	WebElement checkInDate;
	
	@FindBy(xpath = "//input[@id='datepick_out']")
	WebElement checkOutDate;
	
	
	@FindBy(xpath = "//input[@id='Submit']")
	WebElement submitBtn;
	
	// Initializing the Page Objects:
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateSearchHotelPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public void select_locationviadropdown() {
		Select locations = new Select(location);
		locations.selectByIndex(1);	
	}
	
	public void select_hotelviadropdown() {
		Select hotel = new Select(hotels);
		hotel.selectByIndex(1);	
	}
	
	public void select_roomtypeviadropdown() {
		Select roomtypes = new Select(roomType);
		roomtypes.selectByIndex(1);	
    }
	
	public void select_roomnosviadropdown() {
		Select noofrooms = new Select(roomNos);
		noofrooms.selectByIndex(2);	
	}
	
	public void enterCheckIndate (String checkIn) {
		checkInDate.clear();
		checkInDate.sendKeys(checkIn);
	}
	
	public void enterCheckOutdate (String checkOut) {
		checkOutDate.clear();
        checkOutDate.sendKeys(checkOut);
	}
	
	
	public SelectHotelPage submit() {
		submitBtn.click();
		return new SelectHotelPage();
	}
	

}
