package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomHandle {
	
	//html DOM --> iframe --> shadow DOM element -->
	
	//or
	
	//br --> page --> iframe --> shadow dom --> element 

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://selectorshub.com/xpath-practice-page/"); //html body DOM
		
		driver.switchTo().frame("pact"); //iframe
		
		JavascriptExecutor jse = (JavascriptExecutor)driver; //convert driver here into javascript executor
		WebElement element = (WebElement)jse.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.quesrySelector(\"#tea\")"); 
		//copy JS path here which is "document.querySelector(\"#snacktime\").shadowRoot.quesrySelector(\"#tea\")"
		
		String js = "arguments[0].setAttribute('value', 'Green Tea')";
		jse.executeScript(js, element);
		
		//you can see shadow-dom when you inspect the frame where you write Green tea and since you cannot create xpath for shadow dom - this is how you handle it.
		//this is very rare 
		//java script executor or css selector will only work 
		//ShadowDOM - its part of DOM structure, but it has its own DOM basically 
		//Application: Shadow Root application
		//web driver IO - also app for shadow DOM
	}

}
