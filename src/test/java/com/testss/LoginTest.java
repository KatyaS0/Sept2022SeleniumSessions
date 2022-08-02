package com.testss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
WebDriver driver; //declare drive at class level
	
	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signup = By.linkText("Sign up");
	By homePageHeader = By.className("private-page__title");
	
	
	@BeforeTest
	@Parameters({"url", "browser"}) //this name must match the name in xlm file 
	public void setup(String appUrl, String browserName) throws Exception {// holding param name can be anything here 
		System.out.println("before method -- setup");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("please pass the correct browser name");
			throw new Exception ("NoSuchBrowserExcpetion");
				
		}
//		WebDriverManager.chromedriver().setup(); because we declared it on top, we do not need this anymore. 
//		driver = new ChromeDriver();
		driver.get(appUrl); //instead of this"driver.get("https://app.hubspot.com/login") because of @Parameter, we can just say url
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1) // you can give priority 
	public void signUpLinkTest() {
		System.out.println("test method 1");
		Assert.assertTrue(driver.findElement(signup).isDisplayed()); //assert is here when we have boolean return. We use Asssert
	}
	
	@Test(priority=2)
	public void pageTitleTets() {
		String title = driver.getTitle();
		System.out.println("page title is: " + title);
		Assert.assertEquals(title, "Hubspot Login"); // we do not use if method here, we use assert
	}
	
	@Test(priority=3)
	@Parameters({"username", "password"})
	public void loginTest (String emailId, String pwd) {
		driver.findElement(username).sendKeys(emailId); //so instead of writing this: ("katy@yahoo.com"); we will just pass the param in the xml. Like directly 
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
		String homePageHeaderVal = driver.findElement(homePageHeader).getText();
		//to verify: we use assert. Every test. 
		Assert.assertTrue(homePageHeaderVal.contains("Sales Dashboard")); // there is a word "default" next to the name, and when you run Xpath, 
		//it takes the "deafault" too, and it makes your test fail, so we use "contains" here. 
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	//two tests in xml can be run on diff browsers 
	//<exclude name="signUpLinkTest"/> wil ignore the test 
	
	
	
	
	

}
