package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsEvents {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login");
		
		Thread.sleep(5000);
		
		WebElement emailId = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("loginBtn"));

		
		Actions action = new Actions (driver);
		
		action.sendKeys(emailId, "test@gmail.com").build().perform(); // this will enter the test email. 
		// so here toMoveElement is being perfomrmed internally  anyways and then perfoing send keys.
		action.sendKeys(password, "test@123").build().perform();
		action.click(loginButton).build().perform();
		
	}

}
