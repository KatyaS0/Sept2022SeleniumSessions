package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login");
		Thread.sleep(5000);

		// page objs:
		By emailId = By.id("username");
		By password = By.id("password");
		By loginButton = By.id("loginButton");
		
		Util util = new Util(driver);  // got this from Util class
		
		String title = util.waitForTitlePresent("HubSpot",10);
		System.out.println(title);
		
		
		// the requirement we have to pass the locator.
		//how to create lcoator with by class?
		
		util.waitForElementPresent(emailId, 15); //use this form UTIL
		util.doSendKeys(emailId, "naveen@gmail.com");
		util.doSendKeys(password, "test123");
		util.doClick(loginButton);
		
		
	}

}
