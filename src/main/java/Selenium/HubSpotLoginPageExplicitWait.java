package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HubSpotLoginPageExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("HubSpot")); // also awailable for URL. 
				
		System.out.println(driver.getTitle()); // the momen it will see the title, it will be printed. Onces its seen 
		
		//lets create a BY element 
		
		By emailid = By.id("sudername");
		
		WebDriverWait wait1 = new WebDriverWait(driver, 3);//this is a new code because of version in POM 4.0  (i think i fixed it)
		wait1.until(ExpectedConditions.presenceOfElementLocated(emailid)); // this is a BY locator
		//we will get an exception 
		//Exception in thread "main" org.openqa.selenium.TimeoutException: 
		//Expected condition failed: waiting for presence of element located by: By.id: sudername 
		//(tried for 3 second(s) with 500 milliseconds interval)
		//the 500 milis are provided internally in between the itterations of 3 seconds. Basiclaly for the system to cehck again if the element is found 

		
		
		WebElement email = driver.findElement(emailid);
		email.sendKeys("test@gmail.com"); 
		
//		WebElement emailId = driver.findElement(By.id("username"));
//		WebElement password = driver.findElement(By.id("password"));
//		WebElement loginButton = driver.findElement(By.id("loginBtn"));
		
		
		//DIRREFERENCE BETWEEN IMPL AND EXPL
		//not a global wait, just specific element  you apply (emailid)
		//implicit does not have 500 milis priviledge 
		//csn be applied not only web elements
		
		// but THERE IS NO POINT TO APPLY TO ALL, ONCE ONE ELEMENT IS VISIABLE  -  ALL ELEMENTS WILL BE VISIABLE. 
		//Image is also a web element 
		// we will add this into UTIL folder
	}

}
