package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitlyWaitConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login");
		
		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait1.until(ExpectedConditions.titleContains("HubSpot Login"));
		wait1.until(ExpectedConditions.titleContains("Login"));
		
		//tried for 3 seonds with 500 milisec interval
		//System.out.println(driver.getTitle());
		
		getElementExpWait(driver, 10, By.id("username")).sendKeys("test");
		
//		WebDriverWait wait = new WebDriverWait(driver, 15);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		
		
		WebElement emailId = driver.findElement(By.id("username"));
		emailId.sendKeys("test");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("1234");
				
		WebElement loginBtn = driver.findElement(By.id("loginBtn"));
		loginBtn.click();

		
	}
	public static WebElement getElementExpWait(WebDriver driver , int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
