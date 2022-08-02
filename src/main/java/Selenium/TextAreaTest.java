package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextAreaTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoauto.xyz/signin");
		driver.findElement(By.id("email")).sendKeys("katya@gmail");
		driver.findElement(By.id("password")).sendKeys("23456");
		driver.findElement(By.cssSelector("button[type='submit'")).click();
		driver.findElement(By.id("sticky-note")).sendKeys("love is in the air...."); // this will type a text on the sticky note. 


		
		
		
	}

}
