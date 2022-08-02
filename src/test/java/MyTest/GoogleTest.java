package MyTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	WebDriver driver;
	
	//if you just write @BeforeTest or @AfterTest, it will not give you an option to execute until you write @Test because you need a test case
	@BeforeMethod //pre condition - before running your test, what do you want to set up
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
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	//before and AFter method will launch browser three times.
	//even if the test case will crash, it will keep executing. so if there are 100 tests, and one fails, we have 99% coverage. 
	//takes longer time but we have better coverage. (this is also called regretion approach)
	//you can use BeforeTest and BeforeMehtod together 
}
