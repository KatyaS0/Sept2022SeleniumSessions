package Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotConcept {

	public static void main(String[] args) throws InterruptedException, IOException {

		// how do we do screenshot in selenium?
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login");
		
		Thread.sleep(5000);
		
		// this is a method that is an interface
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // this will take a screen shot
		FileUtils.copyFile(SrcFile, new File("./target/screenshots/page.png")); //This will copy the screen shot where you need. The blue is where you want to save the file
		// to see if it was saved, you need to right clikc on the project to refresh it and you will see it there. 
		//The "screenshot/page is written for the system to CREATE THOSE FORLDERS. They are not there currently. the system will create them 
		
		takePageScreenshot(driver, "loginpage"); // we called it from below becase its static. I was supposed to delete the above screenshot but this is for my reference
		// so the top is not suppised to be here. 
		

		WebElement emailId = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("loginBtn"));
		
		emailId.sendKeys("test@gmail.com");
		password.sendKeys("test123");
		loginButton.click(); 
		
		takeElementScreenshot(emailId, "emailId");
		takeElementScreenshot(password, "password");
		takeElementScreenshot(loginButton, "loginpage");
		
		takePageScreenshot(driver, "loginpageError"); // but for this to be done you have to uncommnent loginButton.click(); 

		
		driver.quit(); 
		
		
		
	}

	
	public static void takePageScreenshot(WebDriver driver, String fileName) {
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File("./target/screenshots/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void takeElementScreenshot(WebElement element, String fileName) { // this will take a screenshot of web element like where you rtite login, password 
		File SrcFile = ((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File("./target/screenshots/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
