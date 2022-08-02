package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HubSpotLogin {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		ElementUtil elementUtil = new ElementUtil(driver);

		By emailId = By.id("Username");
		By password = By.id("password");
		By loginBtn = By.id("loginBtn");
		By signUp = By.linkText("sing up"); 
		
		driver.get("http://app.hubspot.com/login");
	
		elementUtil.clickWhenReady(signUp, 6); // this is for sign up 
		
		
		
		String title = elementUtil.waitForTitleToBePresent("login", 6);
		System.out.println(title);
				
		elementUtil.waitForElementToBePresent(emailId, 15).sendKeys("kk@gmail.com");
		elementUtil.doSendKeys(password,"1233");
		
		elementUtil.doClick(loginBtn);
		elementUtil.waitForElementToBePresent(loginBtn, 5).click();
		
		
		
		
		
	}

}
