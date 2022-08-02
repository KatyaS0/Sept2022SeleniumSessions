package Selenium;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	public static void main(String[] args) {

		//Explicit wait types:
		//1.WebDriverWait
		//2.FluentWait:
		//	a. TimeOut
		//	b. pollingPeriod
		//	c. IgnoringException 
		//  d. Unit
		
		//when to use fluentwait
		//for handling the Ajax components (particualr sections are getting upgrated. We will send ajax request to server without refreshing the page to see the update)
		//Ajax is the sections that get updated. 
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://classic.crmpro.com/");
		
		final By username = By.name("username");
		By password = By.name("password");
		By loginBtn = By.xpath("//input[@value='Login']"); // we didnt have the name so we used xpath
		waitForElementWithFluentWait(driver, username).sendKeys("batchauto");
		driver.findElement(password).sendKeys("1234");
		driver.findElement(loginBtn).click();
		
		
		}
	
	public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator) {		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);  // this is a class implementing inteface 
				.withTimeout(Duration.ofSeconds(15));
				.pollingEvery(Duration.ofSeconds(3)); //here we can define the interval time ourself, but in exp. wait there is 500mls. So every 3 seconds the program will check if the eleemnt is visible yet or not 
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	} //the top method is the same as below, but the diff is that we do not have to bother with "OVERRIDE" and the below methood is more for interview and top is for project
	
	
//	
//	public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator) {		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);  // this is a class implementing inteface 
//				.withTimeout(Duration.ofSeconds(15));
//				.pollingEvery(Duration.ofSeconds(3)); //here we can define the interval time ourself, but in exp. wait there is 500mls. So every 3 seconds the program will check if the eleemnt is visible yet or not 
//				.ignoring(NoSuchElementException.class);
//		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//
//			@Override
//			public WebElement apply(WebDriver driver) { //this enrire thing will behave like class. 
//				return driver.findElement(locator);
//			}
//		});
//		
//		return element; 
		
	}	

}
