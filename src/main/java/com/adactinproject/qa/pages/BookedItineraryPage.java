package com.adactinproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.adactinproject.qa.base.TestBase;

public class BookedItineraryPage extends TestBase{
	
	
	
	@FindBy(xpath = "//input[@id='logout']")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Click here to login again')]")
	WebElement clickheretologinagainlink;
	
	public BookedItineraryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateBookedItineraryPageTitle() {
		return driver.getTitle();
		
	}
	
	public void logoutPage() {
		logoutBtn.click();
		
	}
	public LoginPage clickHereToLoginAgain() {
		clickheretologinagainlink.click();
		return new LoginPage();
	}

	}


