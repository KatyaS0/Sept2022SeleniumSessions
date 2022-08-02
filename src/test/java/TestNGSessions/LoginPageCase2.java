package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageCase2 {

	WebDriver driver;
	
	
	@BeforeTest
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, , TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://app.hubspot.com/login");
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
		Assert.assertTrue(flag);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	\
	//if you want to run just one specific test, you can just right click on it and run it
}// if you look at hubspot_regression xml, you will see we added thread_count="2", this method execute these two tests in parallel mode. 
//and you can do whatever thread counts ut no point to get more than the actual size of tests. so one thread will be executing login and other test will execute sign up at the same ytime,, meaning parallel 
//we can also do parameters in xml like thi    <parameter name="url" value="https://app.hubspot.com/login" />
// but in the test, you have to add @ Parameter after @Before Test. so this we add in the LoginTest. And we have to pass it for both tests mentioned in the xml file.
//you can pass many patrams in the xlm.








