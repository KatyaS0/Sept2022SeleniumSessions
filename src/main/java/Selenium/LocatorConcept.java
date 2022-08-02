package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) throws InterruptedException {
		
		//lets say we want to launch browser and then try to get web eliments which are Login eliment, password, login button etc.
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARTYOMKA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		
		driver.get("hhtps://app.hubspot.com/login"); //no such element exception. Why? because here the browser needs 5 seconds to load, and selenium cannot wait for it. 
		//so we have to create a break code so selenium can wait. It says page needs to load 5 seconds so we will break for "5000" miliseocnds so selenium can perform 
		// the next code. We need to write that code after we launch url. See below:
		Thread.sleep(5000); // it will become red, so you have to click on it and add "throws exception" 
		
		// THIS IS ONLY WITH THIS SITE, SO THATS WHY WE NEED THAT CODE. 
		
		
		//we go to the browser, click on the element and right click "inspect" and it will give us the whole code of the element
				//html tag is the "input" whatever goes after "<" in teh code and attributes are "Id" and "Username" prob all of those 
		
		//1 option: ID CONCEPT: unique - not gonna be dublicated
		
		WebElement email = driver.findElement(By.id("username"));
		//"By" is a class in selenium 
		email.sendKeys("katya@gmail.com");
		
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("Test@12345");
		
		//you can also do this:
		driver.findElement(By.id("username")).sendKeys("test@gmail.com");
		driver.findElement(By.id("password")).sendKeys("test@123");
		
		//FIRST APPROACH IS BETTER BECAUSE WHAT IF TOMORROW YOU WANT TO USE THAT SPECIFIC ELEMENT?
		//lets say tomorrow somewhere in the scrpit you want to use that Email data you wrote in your code, in the second approach you cannot. 
		//You would have to keep writing that code.
		
		//little note, "sendKeys" is used when you trying to type in something in the element. Pass some letters or numbers 
		
		//lets click on the "log in" button
		driver.findElement(By.id("loginBtn")).click(); // so not snedKeys but "click"
		
		//2 option: Name : if ID not avaialbe. 99% it will not be dublicated and so one with these methods 
		driver.findElement(By.name("email")).sendKeys("test@gmail.com"); // here if you perform "inspect" on this site, there will be no "name" available in the code
		//but id will be there, if you go to other site, sometimes you see in the login element faded "username" or faded "password. If you see that then name will appear
		//as name:"Username", thats why we can use this "name" method it just depends on the web.  SO we would say By.name ("username"). 
		
		//3 option: xpath: is a locator. It is a dynamic ID
		// so if you want to find xpath of whatever element,  you right click on html tag, click "copy XPath" and paste it below. And it will always be a string 
		driver.findElement(By.xpath("//*[@id='usename']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("test3333"); 
		
		//4 option: Css selector. --> so if you want to find CSS of whatever element,  you right click on html tag, click "copy selector" and paste it below
		driver.findElement(By.cssSelector("#username")).sendKeys("test@gmail.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("test45678"); 
		
		//5 option: class name: to find this we just go to inspect and copy whatever follows "class". (should end before "value"). 
		//driver.findElement(By.className("form-control private-form__control login -email")).sendKeys("test@gmail.com"); // this will give error. Why? see below
	
		//there are 3 cascated classes : 1. form-control, 2. private-form__control, 3. login -email. These are called cascated classes. 
		// what do they do: Since we took this from Username element they perform how the elemtn will look: font, color, texture, round corners of the elemnt, sharp
		//corners, shadows etc. Basically, the design. To see the what is located in the class, you can see it on the right side window. 
		//so "class" will always perform the way something looks. We cannot use all classes together due to space in between all three. 
		//so we need a unique class key. Lets see below to compare: 
		//1. form-control private-form__control login -email
		//2. form-control private-form__control login-password m-bottom-3	
		// 2 of the classes are the same above, so we need to use the class that is unique: login -email and login-password
		driver.findElement(By.className("login -email")).sendKeys("test@gmail.com");
		driver.findElement(By.className("login -password")).sendKeys("test@gmail.com");
		
		//6 option Link text: only used for links available on the web page. 
		//lets say we want to do this with "Sign up" link. We inspect it, and we will see "sign up" available there, and we copy it and paste it to the code. 
		driver.findElement(By.linkText("Sign up")).click(); 
		//but there is a condition: it should be a link. How do we recognize it? When we see the element tag "i18n-string", its coming under "<a", (this will be located higher)
		//and it can be "<a" the way you can understand if tahts a link (a parent), or under parent which is "i18n-string" in this case, dpeends on the website 
		// all the links are represented by "<a" tag
		
		//i18n stands for "internalization", or "localization". is the process of planning and implementing products and services so that they can easily
		//be adapted to specific local languages and cultures, a process called localization. 
		
		//7 option: partial link text:
		driver.findElement(By.partialLinkText("Sign")).click(); 
		//this is a bad approach because what is you have "sign in" and "sign up"? selenium will get confused what do you want to execute. So what is the use case?
		//lets say this is a link: sign up with google and get cool offers!. Here you can use partial link text which lets say will be " sign up with google".
		//so you do not have to write the whole thing. So this is good for long case link situations 

		//driver.findElement(By.className()); 
	
		// so over all there are 8 LOCATORS. 

		
		
		
		
		
		
	}

}
