package MyTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

	WebDriver driver;
	
	//if you just write @BeforeTest or @AfterTest, it will not give you an option to execute until you write @Test because you need a test case
	@BeforeTest //pre condition - before running your test, what do you want to set up
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@Test // this is a test
	public void searchTest() {
		boolean flag = driver.findElement(By.name("q")).isDisplayed();
		Assert.assertTrue(flag);	 //validation	
	}
	
	@Test // this is a test
	public void googleSearchButtonTest() {
		boolean flag = driver.findElement(By.name("btnk")).isDisplayed();
		Assert.assertTrue(flag);	
	}
	
	@Test // this is a test
	public void urlTest() {
		String url = driver.getCurrentUrl()
		Assert.assertTrue(url.contains("google"));	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
	
	//here, browser getting launched once, with BeforeMethods will keep launching 
	
	//if you have 100 test cases, and lets say test #4 will crash, the whole browser will crash 
	//this is for small etst cases, like 20-40. 


