package com.adactinproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinproject.qa.base.TestBase;

public class NewUserRegistrationPage extends TestBase {
	
	@FindBy(xpath = "//a[contains(text(), 'New User Register Here')]")
	WebElement NewUserRegLink;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='re_password']")
	WebElement confirmpassword;
	
	@FindBy(xpath = "//input[@id='full_name']")
	WebElement fullname;
	
	@FindBy(xpath = "//input[@id='email_add']")
	WebElement emailaddress;
	
	@FindBy (xpath = "//td[@class='login_title']")
	WebElement regpagetitle;
	
	@FindBy(xpath = "//input[@id='tnc_box']")
	WebElement checkbox;
	
	@FindBy(xpath = "//input[@id='Submit']")
	WebElement register;
	
	@FindBy (xpath = "//img[@class='logo']")
	WebElement logo;
	//Adding all WebElements
	
	// Initializing the Page Objects:
	public NewUserRegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateRegistrationPageTitle() {
		return driver.getTitle();
		
	}
	public boolean validateAdactinimage() {
		return logo.isDisplayed();
		
	}
	
	public void clickNewUserRegLink() {
		NewUserRegLink.click();
		
	}

	public void enterUsername(String user) {
		username.sendKeys(user);
	}
	public void enterPassword(String pas) {	
		password.sendKeys(pas);
		
	}
	public void enterConfirmPassword(String confpass)	{
		confirmpassword.sendKeys(confpass);
	}
	public void enterFullName(String fn) {
		fullname.sendKeys(fn);
	}
	public void enterEmailAddress(String email) {	
	emailaddress.sendKeys(email);
	
	}
	public void clickCheckBox() {
		checkbox.click();
	}
    public void clickOnRegister() {
    	register.click();
    }
}


