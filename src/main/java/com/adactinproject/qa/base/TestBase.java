package com.adactinproject.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.adactinproject.utilities.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	

	
	public TestBase() {
	
	try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FirstSeleniumDemo1\\AdactinProject\\src\\main\\java\\com\\adactinproject\\qa\\config\\config.properties");
		    prop.load(ip);
		    
		    prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
		
	}
}
	@SuppressWarnings("deprecation")
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("Webdriver.chrome.driver", "C:\\Softwares\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		else if(browserName.equals("FF")) {
		System.setProperty("Webdriver.gecko.driver", "C:\\Softwares\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	
		
	}	
	
	
		
}
