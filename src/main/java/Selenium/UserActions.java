package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login");
		Thread.sleep(5000);
		
		
//		WebElement emailId = driver.findElement(By.id("username"));
//		WebElement password = driver.findElement(By.id("password"));
//		WebElement loginBtn = driver.findElement(By.id("loginBtn"));
//		
//		Actions action = new Actions(driver);
//		
//		action.sendKeys(emailId, "kk@gamil.com").perform();
//		action.sendKeys(password, "1233").perform();
//		action.click(loginBtn).perform(); 
		
		ElementUtil elementUtil = new ElementUtil (driver);
		elementUtil.doActionsSendKeys(By.id("username"), "kk@gmail.com");
		elementUtil.doActionsSendKeys(By.id("password"), "12344");
		elementUtil.doActionsClick(By.id("loginBtn"));
		
		
		

		
		
	}

}
