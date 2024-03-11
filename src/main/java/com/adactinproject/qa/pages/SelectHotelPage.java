package com.adactinproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinproject.qa.base.TestBase;

   public class SelectHotelPage extends TestBase{

	@FindBy(xpath = "//input[@id='radiobutton_0']")
	WebElement selectradioBtn;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;


	// Initializing the Page Objects:
	
    public SelectHotelPage() {
	   PageFactory.initElements(driver, this);
	   
	   
    }
    
    //Actions
	 public String validateSelectHotelPageTitle() {
		   return driver.getTitle();
	   }
	 
	 public void selectHotel() {
		 selectradioBtn.click();
	 }
	   
	public BookAHotelPage selectContinue() {
		continueBtn.click();
		return new BookAHotelPage();
	}
	
	
	
}

