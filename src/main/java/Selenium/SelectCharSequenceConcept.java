package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCharSequenceConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=accoutn/login");
		
		WebElement email = driver.findElement(By.id("input-email"));
		
		//StringBuilder, StringBuffer,String, Keys
		StringBuilder username = new StringBuilder() // or you can use any of the above
				.append("Katya")
				.append(" ")
				.append("automatio")
				.append(" ")
				.append("labs")
				.append(" ")
				.append("Selenium")
		
		String space = " ";
		
		StringBuilder userInfo = new StringBuilder()
				.append("test")
				.append(" ")
				.append("WebDriver")
				
		String author = "Naveen Khunteta";
		
		email.sendKeys(username, space, userInfo, space, author, Keys.TAB); //tab is just go to next field. // you cannot pass null here
		//this code will enter all values with append into the email field 
		
		
		
		
	}

}
