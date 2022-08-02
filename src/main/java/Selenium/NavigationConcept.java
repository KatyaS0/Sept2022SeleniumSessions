package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARTYOMKA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		
		driver.get("http://www.google.com");
		
		System.out.println(driver.getTitle());
		
		driver.navigate().to("http://www.amazon.in/");
		//how to move from google to amazon with back and forward errows? this is called back-forward navigation. 
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		//refresh 
		
		driver.navigate().refresh(); 
		
		//now what is the difference between driver.get and driver.navigate? to understand the concept go to class "GetAndNavigate"
		

	}

}
