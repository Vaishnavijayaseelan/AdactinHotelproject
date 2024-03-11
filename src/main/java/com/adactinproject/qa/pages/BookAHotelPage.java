package com.adactinproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.adactinproject.qa.base.TestBase;

public class BookAHotelPage extends TestBase{
	
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//textarea[@id='address']")
	WebElement billingAddress;
	
	@FindBy(xpath = "//input[@id='cc_num']")
	WebElement ccNum;
	
	@FindBy(xpath = "//select[@id='cc_type']")
	WebElement ccType;
	
	@FindBy(xpath = "//select[@id='cc_exp_month']")
	WebElement expiryMonth;
	
	@FindBy(xpath = "//select[@id='cc_exp_year']")
	WebElement expiryYear;
	
	
	@FindBy(xpath = "//input[@id='cc_cvv']")
	WebElement cvvNum;
	
	@FindBy(xpath = "//input[@id='book_now']")
	WebElement bookNowBtn;
	
	public BookAHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateBookAHotelPageTitle() {
		return driver.getTitle();
	}
	public void enterBookingdetails() {
		firstName.sendKeys("Vaishnavi");
		lastName.sendKeys("Jayaseelan");
		billingAddress.sendKeys("Unit-10 44-50, Thomas Street, Parramatta NSW 2150");
		ccNum.sendKeys("1234567890123456");
        cvvNum.sendKeys("234");
	}
	public void selectCreditCardDetails() {
		Select creditcardtype = new Select(ccType);
		creditcardtype.selectByValue("VISA");
		Select expmonth = new Select(expiryMonth);
		expmonth.selectByIndex(2);
		Select expyear = new Select(expiryYear);
		expyear.selectByValue("2026");
	
	}
	public BookingConfirmationPage submit() {
		bookNowBtn.click();
		return new BookingConfirmationPage();
		
	}
}
