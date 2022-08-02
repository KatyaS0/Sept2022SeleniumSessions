package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {
		//headless means no UI
		//testing is happening behind the scene
		//faster than normal UI mode
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions(); //class that is responsible to run headless 
		co.addArguments("--headless");
		co.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver (co); //we have to pass in the chrome   driver constr. Only then it will work 
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//it will not launch the browser and just print onthe cosloe. This is what headless is. 
		//we can do firefox too
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		WebDriver driver2 = new FirefoxDriver (fo); 
		
		//pop up might not work with headless. Only for small apps not complex. 
		
		//incognito mode - open your browser in private or run test cases private 
		
		
		

		
		
		
	}

}
