package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_xpath_2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); 
		
		//two types of xpath: absolute xpath and relative/custom xpath
		//absolute://htm//div//div[2]//div[1]//div[3]//div//span  -- id
		//relative/custom: //span[@id='test'] 
		//we always prefer relative xpath in case someone will change something in DOM
		
		
		//The following are Xpath Axes:
		
		//keyword - following:
		//div(@class='input-group']//following::input  -  this will give you the follwing inputs available 
		//what if we need a specific  one:
		//div(@class='input-group']//following::input[@name'username'] 
		// or you can put: (//div(@class='input-group']//following::input)[1]
		
		//input[@name='username']//preceding::div
		//input[@name='username']//parent::div  -- if you need parent 
		//div[@class='input-group']//child::input[@name='username']  -- to move to child
		//input[@name='username']//preceding::div
		//div[@class='input-group']//ancestor::div //highest/old parent. this will go reverse direction
		
		//so now, lets say there is a name you want to check-box, check-box is next to it and you need to click it:
		//1.Inspect the name you want to select
		//2.type 'ancestor, which is the "old" parent, or exactly where the name is available
		//3. there will be many 'td' (in this case), those are called siblings. so you add: preceding-sibling. Pre - menas before, so it will select the 'td' before.YOU NEED TO LOOK WHERE CHECKBOX IS
		//4. you add'td' to the formula
		//5. to choose the check-box and click it you add: input. this is actualy from 'td' (parent) to 'input' (child of td)
		//here is the outcome:
		//span[text()='naveen k']//ancestor::td//preceding-sibling::td//input 
		//or:
		//span[text()='naveen k']//ancestor::td//preceding-sibling::td//child::input 
		
		//reversing xpath: travel in backaward direction child-parent-grandparent-superparent-top parent in DOM
		//input[@id='username']/../../../../../../../../../.. - we started from child and '/..' which will help jumping to parents. Each one is one level up 
		//this is an absolute xpath Not custom actually 
		//what if in the middle of this we aree trying to capture something? use getAttribute method 
		driver.findElement(By.xpath("input[@id='username']/../../../../../../../../..")).getAttribute("id"); 
		
		
		//how do we do generic method for the method above?
		
		WebElement emailId = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("loginBtn"));
		
		Actions action = new Actions (driver);
		action.sendKeys(emailId, "test@gmail.com").build().perform(); 
		action.sendKeys(password, "test@123").build().perform();
		action.click(loginButton).build().perform();
		
		Thread.sleep(4000);
		
		driver.navigate().to("https://app.hubspot.com/contacts/6372460/contacts/list/view/all/?");
		action.click(driver.findElement(By.xpath("//span[text()='naveen k']//ancestor::td//preceding-sibling::td//span[@class='private-checkbox_inner"))).build().perform(); 
		//so just inner as it was before would not work so we have to add one more span class. Span was actually highlighitng the checkbox 
	
		selectContact(action, driver,"navee k");
		selectContact(action, driver,"mohamed");
		
		//xpath for a different web: also this web has many coloms (web:FreeCRM)
		//a[contains(text(),'Lola')]//parent::td//preceding::td/input[@name='conatct_id' and @type='checkbox']
		//how do we go from left to right direction
		//a[contains(text(),'Lola')]//parent::td//following-sibling::td/a[@context='company']

		
		//this is a generic method 
	}
	
	public static void selectContact(Actions action, WebDriver driver, String contactName) {
		action.click(driver.findElement(By.xpath("//span[text()='"+contactName+"']//ancestor::td//preceding-sibling::td//span[@class='private-checkbox_inner"))).build().perform(); 

	}

}
