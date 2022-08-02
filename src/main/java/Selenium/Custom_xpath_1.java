package Selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_xpath_1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login");
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); does not work for some reason 
		//how to create xpath for lets say email
		// //htmltag[@prop1='value']
		// //input[@id='username']
		
		//what if we want multiple values?
		// //htmtag[@prop1='value' and @ ptop2='value']
		//input[@id='username' and@type='email'] and you can keep adding 
		
		//class attribute xpath: we have to pass exact class value 
		
		// //input[@class='form-control private-form_control login-email']
		
		//"containns" keyword in xpath:
		//htmltag[contains(@prop,'value')] 
		//input[contains(@class,'login-email')] - here we can use simple class
		//input[contains(@id,'username')]
	
		//input[@id='username'and contains(@class, 'login email')] we can do this too. One is direct, one is contains().
		//input[@id='username'and contains(@class, '')]
		
		//contains used for dynamic ids:
//		<input id='test_123'> 
//		<input id='test_232'>
//		<input id='test_143'>
//		<input id='test_153'>
		//this is called dynamic ids - everytime new id will generate 
		//so once ids are always changing, we can use contains because if we use (By.) it will give you excpetion since its coontantly changing (rare)
		//input[contains(@id,'test_') test_ because that part is constant
		
		//what if we have 2 elements menaing two "inputs" ? how do we filter it
		//(//input[contains(@class,'form-control')])[1]
		//(//input[contains(@class,'form-control')])[2]
		//or you can use position:
		//(//input[contains(@class,'form-control')])[position()=1]
		//(//input[contains(@class,'form-control')])[position()=2]
		//what if there are 10 elements? what if you want last element
		//(//input[contains(@class,'form-control')])[last()] 
		//you can use ChroPath(press inspect-on the right click 3 dots - ChroPath but you have to download it i think but only for simple xpath not like last, or contains etc. 
		//(//i18n-string)[1] this is also valid xpath

		
		//how to use text in xpath:
		//lets say no id, no name is available. Lets use "forgot password"
		// //htmltag[text()='value']
		//i18n-string[text()='Forgot my password']
		//"email doe snot exist"
		//h2[text]="That email address doesn't exist."] if you put single quote it wont work because it has a single quote in 'Doesn't'. 
		//"show password"
		//span[text()='Show password']
		
		//now lets use text with contains:
		//span[contains(text(),'Show Password')]
		//span[contains(text(),'Show')]
		//span[contains(text(),'Password')]
		
		//capture text of the website/header:
		//h1[@class='private page_title']
		//h1[text()='Sales Dashboard']
		
		//the moment you log in, you will see name taht is loged in, you want to check if taht name is avaialble/to validate /if user logged in sucessfully 
		//span[text ()='Naveen']
		//span[starts-with(@class, 'account'] so what it starts with 
		
		//how to use it on the text functions:
		//span[starts-with(text(),'Naveen')]
		//span[starts-with(@class,'account')] this is using class
		//h1[starts-with(text(),'Sales')]
		
		//"*" means any element 
		//*[@id='username'] you can use star or input - but it will give you 000 elements that contain 'username'
		//div//input[@id='username'] this is by using parent-child html tag - also double slash is indirect child. More exactly direct+indirect child
		//div/input - one slash is direct child 
		
		
		WebElement emailId = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("loginBtn"));
		
		Actions action = new Actions (driver);
		action.sendKeys(emailId, "test@gmail.com").build().perform(); 
		action.sendKeys(password, "test@123").build().perform();
		action.click(loginButton).build().perform();
		
		Thread.sleep(4000); 
		
		
		String headerValue = driver.findElement(By.xpath("h1[@class='private page_title']")).getText();
		System.out.println(headerValue);
		Thread.sleep(4000); 
		System.out.println(driver.findElement(By.xpath("//h1[text()='Sales Dashboard']")).isDisplayed()); // this will fins if that text is avaialle, basically varify it. It will also return true or false. 
		
		
	
		
		
	
	}

}
