package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	
	
	WebDriver driver;  // this is a local veriable so we need to use "this" key word to get the driver into the class of Util
	//lets create constructior of this class
	public Util(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This method is used to create the webelement on the basis of By locator 
	 * @param locator
	 * @return
	 */
	
	// lets create a generic element method 
	public WebElement getElement(By locator) { // this can be anything xpath, name, id etc
		//how to handle exceptions in selenium? use try-catch, and null for no errors 
		WebElement element = null;
		try {
			//waitForElementPresent(locator); you can do this too
			element = driver.findElement(locator);
		}
		catch(Exception e ) {
			System.out.println("some exception occured while creating the webelemment");
			System.out.println(e.getMessage());
		}
		return element; 
		// this is called rapper method
		
		//lets create a separate class LoginPage class
		
	}
	
	public void waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
	}
	public String waitForTitlePresent(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.titleContains(title)); 
		return driver.getTitle(); 
	}

	
	// lets create the method for click
	/**
	 * this method is used to click on element
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("some exception occured while creating the webelemment");
			System.out.println(e.getMessage());
//will not ahve return type
		}
	}
	/**
	 * this method is used to pass the values in a webelement 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
		try {
			getElement(locator).sendKeys(value);
		}
		catch(Exception e) {
			System.out.println("some exception occured while creating the webelemment");
			System.out.println(e.getMessage());
	}
		//will not have return type
	
	
	
	
	

}
