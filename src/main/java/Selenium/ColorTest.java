package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ColorTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		driver.findElement(By.id("email")).sendKeys("katya@gmail");
		driver.findElement(By.id("email")).sendKeys(Keys.TAB); //this will just do "tab"or you can do "enter" so it goes to the next value entering (pasword) 
		
		System.out.println(driver.findElement(By.cssSelector("div.form-group.form-error")).isDisplayed()); // this is the error that comes up when you enter improper email
		
		//we do not worry about color here (red or green light up when there is an error or correctly written value) 
		
	}

}
