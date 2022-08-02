package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowsers {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String parentWindowId = driver.getWindowHandle();
		//you are switching to domain
		
//		WebDriver driver1 = new ChromeDriver();
//		driver.get("https://www.amazon.com");
//		driver1.close();
		
		//with the same domain:
		//driver.navigate().to("amazon.com");
		
		
		//switch to different domain method:
		driver.switchTo().newWindow(WindowType.WINDOW); //this code will switch to one domain to another domain
		driver.get("https://www.amazon.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();

		
	}

}
