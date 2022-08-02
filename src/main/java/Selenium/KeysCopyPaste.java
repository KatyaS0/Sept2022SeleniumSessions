package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeysCopyPaste {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/account/about/");
		
		WebElement element = driver.findElement(By.xpath("//*[test() = 'Create an account']"));
		
		element.click();
		
		WebElement firstName = driver.findElement(By.id("firstName"));
		WebElement userName = driver.findElement(By.id("userName"));
		
		firstName.sendKeys("Katya");
			
		Actions act = new Actions(driver);
		//windows -- Keys.CONTROL
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform(); //select
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform(); //copy

		userName.click();
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform(); //paste
		
		//keyDown - means press the key on the keybaord
		//KeyUP - MEANS RELEASE THE KEY

		
		
		
		
		
	}

}
