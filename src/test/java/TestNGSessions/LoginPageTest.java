package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	
	WebDriver driver;
	SoftAssert softAssert; 
	
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, , TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://app.hubspot.com/login");
		softAssert = new SoftAssert ();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Hubspot"));
		
		String title = driver.getTitle();
		System.out.println("page title is: " + title);
		Assert.assertEquals(title, "Hubspot Login");
	}
	@Test(priority=2)
	public void signUpLinkTest() {
		boolean flag = driver.findElement(By.linkText("Sign Up")).isDisplayed();
		Assert.assertTrue(driver.findElement(By.linkText("Sign up")).isDisplayed();
	}
	
	@Test (priority=3)
	public void loginTest() {
		driver.findElement(By.id("username")).sendKeys("katy@yahoo.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("loginbtn")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("private-page__title")));		
		Assert.assertTrue(driver.findElement(By.className("private-page__title")).isDisplayed()); //if this fails, that particular test case will be terminated.
		
		String header = driver.findElement(By.className("private-page__title")).getText();		
		System.out.println("homepage header is: " +header); 
		Assert.assertEquals(header,  "Sales Dashboard", "header text is not matched");	//if your assertion fails, you can customise a message. (we just passes a third variable. 
		//in any kind of assert method you can add your message
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	//hard assertion vs. soft assertion and Assertion vs. verify:
	//in testNG we do not have verify, but it is like soft assertion
	//Soft assertion:
	//if you have 5 test assesrtions, and lets say first 2 passed, then 2 failed then one last one passed, SA will keep executing even if it failed and then give you report what failed
	//Hard Assertions:
	//will not keep executing test cases if one failed 
	//also you do not need to create an object where as in soft assert you do. softAssert = new SoftAssert ();
	
	//how to make soft assert:
	
//	WebDriver driver;
//	SoftAssert softAssert; 
//	
//	
//	@BeforeMethod
//	public void setup() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().fullscreen();
//		driver.manage().timeouts().implicitlyWait(20, , TimeUnit.SECONDS);
//		driver.manage().deleteAllCookies();
//		driver.get("http://app.hubspot.com/login");
//		softAssert = new SoftAssert ();
//	}
	// and then when you need to use soft assert, you declare the method like this:
	//softAssert.assertTrue(driver.findElement(By.linkText("Sign up")).isDisplayed();
	//softAssert.assertAll(); this will colect all assertions and  give you final report
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
