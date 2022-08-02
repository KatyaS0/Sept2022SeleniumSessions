package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://swisnl.github.oi/jQuery-contextMenu/demo.html"); 
		
		WebElement rightClickElement = driver.findElement(By.className("context-menu-one")); // will will right clikc on the button and so we will inspect that button on the webpage
		
		Actions action = new Actions(driver); 
		
		action.contextClick(rightClickElement).build().perform(); 
		//now lets say we want to click on copy. So we inspect copy: ul (parent tag) - li - and you will see class names, so we have to pick the unique ones.And then you go to span 
		
		String text = driver.findElement(By.xpath("//ul/li[contains(@class,'context-menu-icon-copy')]/span")).getText();
		// the menaing of this code is: you go to tag name ul, then go to li which contains that particular class name 
		System.out.println(text); // "copy" will be printed on the console 
		
		
		
	}

}
