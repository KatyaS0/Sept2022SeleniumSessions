package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logintest {
	
	//before annotations - BS BT BC BM
	//test annotations - @Test
	//After annotations - AM AC AT AS
	//we never write TetsNG with main method 
	
	//TEST SEQUENCE
	/*
	 * BS
	 * BT
	 * BC
	 * 
	 * BM
	 * T1
	 * AM
	 * 
	 * AC
	 * AT
	 * AS
	 * 
	 */
	
	WebDriver driver; //declare drive at class level
	
	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signup = By.linkText("Sign up");
	By homePageHeader = By.className("private-page__title");
	
	
	//@BeforeTest // annotaions is declared with @, must be associated with a method, canno9t just leave it blank
	//@BeforeTest - mends eqecute before all your test. 
	//this will be executed only once 
	//BeforeMethod -it will create a pair of tests. So here we have 3 tests so it will open broser 3 times.
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite -- prepare test data");
	}
	
	
	@BeforeTest
	public void beforeTest () {
		System.out.println("before test -- DB colections");
	}
	
	@BeforeClass
	public void beforeClass () {
		System.out.println("before class -- get the value from DB");
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("before method -- setup");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1) // you can give priority 
	public void signUpLinkTest() {
		System.out.println("test method 1");
		Assert.assertTrue(driver.findElement(signup).isDisplayed()); //assert is here when we have boolean return. We use Asssert
	}
	
	@Test(priority=2) //if you type @Test(priority=2, enable = false) , test will not be executed
	public void pageTitleTets() {
		String title = driver.getTitle();
		System.out.println("page title is: " + title);
		Assert.assertEquals(title, "Hubspot Login"); // we do not use if method here, we use assert
	}
	
	@Test(priority=3)
	public void loginTest () {
		driver.findElement(username).sendKeys("katy@yahoo.com");
		driver.findElement(password).sendKeys("123456");
		driver.findElement(login).click();
		String homePageHeaderVal = driver.findElement(homePageHeader).getText();
		//to verify: we use assert. Every test. 
		Assert.assertTrue(homePageHeaderVal.contains("Sales Dashboard")); // there is a word "default" next to the name, and when you run Xpath, 
		//it takes the "deafault" too, and it makes your test fail, so we use "contains" here. 
	}

	@AfterMethod
	//AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class -- delete the user");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test -- dissconnect the DB");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite -- ");
	}
	
	
	
	
	//driver.getTitle(); cannot be handled by implicitly wait method 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
