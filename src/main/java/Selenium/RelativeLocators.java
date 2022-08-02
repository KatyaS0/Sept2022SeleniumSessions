package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*; 


import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.aqi.in/dashboard/canada");
		WebElement ele = driver.findElement(By.linkText("williamms-Lake, Canada")); //we have to always create the base element and then go from there 
		
		String aqNum = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(aqNum); 
		
		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(rank); 
		
		String rank1 = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(rank1); 
		
		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowCity);
		
		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);
		
		String name = driver.findElement(with(By.tagName("p")).near(ele)).getText(); //within 15px distance. It will capture nearest "P"
		System.out.println(name);

		//this method helps us not to write conplex xpaths
		//import static org.openqa.selenium.support.locators.RelativeLocator.*; has to be entered manually  



		
		
		
		
		

	}

}
