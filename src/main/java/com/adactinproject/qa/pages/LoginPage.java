package com.adactinproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinproject.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//pagefactory or Object Repository
	
	@FindBy (xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy (xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy (xpath = "//input[@id='login']")
	WebElement loginBtn;
	
	@FindBy (xpath = "//a[contains(text(), 'New User Register Here')]")
	WebElement NewUserRegBtn;
	
	@FindBy (xpath = "//img[@class='logo']")
	WebElement logo;
	//Adding all WebElements
	
	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
		}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateAdactinimage() {
		return logo.isDisplayed();
	
	}
	public SearchHotelPage login(String use, String pass) {
		username.sendKeys(use);
		password.sendKeys(pass);
		loginBtn.click();
		return new SearchHotelPage();
	}
	
	

}
