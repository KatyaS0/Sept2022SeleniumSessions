package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login");
		
		By emailId = By.name("username");
		By password = By.name("password");
		By loginBtn = By.xpath("loginbBtn");
		
		getElementWithWait(driver, emailId, 6).sendKeys("kk@gmail.com"); //so if you put 2 secondsm it will give you Null POinter excpetion
		driver.findElement(password).sendKeys("123");
		driver.findElement(loginBtn).click(); 

	}
	
	public static WebElement getElementWithWait(WebDriver driver, By locator, int timeout) throws InterruptedException {
		WebElement element = null; 
		for(int i=0; i<timeout; i++) {
			
			try {
				element = driver.findElement(locator); 
				break;
			}
			catch(Exception e) {
				System.out.println("waititng for element to be present on the page -->" + i + "secs"); // this will print on the consolse how many sec it too to find the elements
				try {
					Thread.sleep(1000); 
				} catch (InterruptedException e1) {
				}
			}
				
		}
		return element; 
		
	}
	
	
	public static boolean idElementDisplayed(WebDriver driver, By locator, int timeout) throws InterruptedException {
		WebElement element = null; 
		boolean flag = false; 
		for(int i=0; i<timeout; i++) {
			
			try {
				element = driver.findElement(locator); 
				flag = element.isDisplayed();
				break;
			}
			catch(Exception e) {
				System.out.println("waititng for element to be present on the page -->" + i + "secs"); // this will print on the consolse how many sec it too to find the elements
				try {
					Thread.sleep(1000); 
				} catch (InterruptedException e1) {
				}
			}
					
		}
		return flag; 

}
