package Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {

	public static void main(String[] args) {
		//AScenario: open orange - click on link - new window pop up - close the new window. 
		
		//browser window pop up / new tab window / new browser window
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		// we need to move the driver from main to pop up windown. Once we close, the driver will be lost so we need to put it back to main windown 
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		String parentWindowID = it.next(); 
		System.out.println("parent windown id is: " + parentWindowID); 
		
		String childWindowID = it.next();
		System.out.println("parent windown id is: " + childWindowID); 

		//switching driver to child window 
		driver.switchTo().window(childWindowID); 
		System.out.println("child window url: " + driver.getCurrentUrl());
		
		driver.close(); //close the child. if you write quit, it will close the parent. 
		//driver is lost now, 
		driver.switchTo().window(parentWindowID);
		//if without switching, you are interavting with parent windown:
		//it will throw: NoSuchWindowException: no such window: target window already closed 
		String parentWindowTitle =driver.getTitle();
		System.out.println("parent window url: " + driver.getCurrentUrl());
		
		driver.quit(); 

		
		
		
		// this lesson is the same as WindowPopUpHandle 
		
		
	}

}
