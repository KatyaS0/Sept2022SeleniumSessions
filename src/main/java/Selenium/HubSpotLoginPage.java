package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HubSpotLoginPage {

	@SuppressWarnings("deprecation");
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login");
		
		//Thread.sleep(5000); // this is static/constant wait, what if element is found within 2 seconds? 
		
		//applied for all the elements
		//global wait - it applies to all elements
		//dynamic wait 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // THIS IS A DYNAMIC WAIT. The code will be executed once the system finds the element you need.
		// it will not wait 20 seconds until they run out like static method. It will ignore the pedning seconds left. Also this is only for elements not title or anything else
		
		System.out.println(driver.getTitle()); 
				
		WebElement emailId = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("loginBtn"));
		
		emailId.sendKeys("test@gmail.com"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // for some reason this code is deprecated and this method will override the previous one thats 20 seconds  
		// how to nullify this mehod? to cancel this metho? you write "0" nest to timeUnit. 
		
		//since its a global wait, it will aplly time to ALL elements and not like expl, because expl is individual 
		

	}

}
