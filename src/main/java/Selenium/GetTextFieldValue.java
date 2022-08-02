package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextFieldValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.id ("login1")).sendKeys("test@gmail.com"); // this will put email into the login1 
		String value = driver.findElement(By.id("login1")).getAttribute("value");
		System.out.println(value); //this will capture the value in the login if anything is entered there/ 
		//get text will get you the text only. Like "password" "Forgot password?" those that were already there in the web. 
		
		
		
		
		
	}

}
