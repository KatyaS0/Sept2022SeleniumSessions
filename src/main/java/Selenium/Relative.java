package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://whenwise.com/sign-in");
		
		driver.findElement(By.id("email")).sendKeys("katya@gmail");
		driver.findElement(By.id("password")).sendKeys("23456");
		driver.findElement(By.id("login-btn'")).click();
		
		//we have two switch buttons for two questions, they have same class so this is how we choose the correct one
		
		driver.navigate().to("https://whenwise.com/users/2835/edit");
		
		WebElement ele = driver.findElement(By.xpath("//span[text()='Email on the booking confirmation?']"));
		
		driver.findElement(with(By.className("lever")).toRightOf(ele)).click();
		
		//toRightOf means of the element. Here the element is" Email on the booking confirmation?"
		
		
		
		
		
		
		
	}

}
