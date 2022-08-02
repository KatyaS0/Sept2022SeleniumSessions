package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

	public static void main(String[] args) throws InterruptedException {
		//SVG - vector graphs - css selector willl not work, so need a specific SVG xpath. Usually when you inspect, you will see lenthy d= number. "G" meanth graph
		//search icon can be SVG. 
		//use local hiphen name
		//we always use * for svg path 
		// //*[local-name()='svg'and @id='map-svg']//*[name()='g' and @id='states'/*[name()='g'] 
		//unger[g] we have to go to 'path" and get name
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("Https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(5000);
		String svgXpath = "//*[local-name()='svg'and @id='map-svg']//*[name()='g' and @id='states'/*[name()='g'] /*[name()='path']";
		
		List<WebElement> statesList = driver.findElements(By.xpath(svgXpath));
		Actions act = new Actions(driver);
		for(WebElement e : statesList) {
			act.moveToElement(e).perform(); //this is "mouse over" command
			String name = e.getAttribute("name");
				if(name.equals("delaware")) {
					e.click();
					break;
				}
		}
		// //*[local-name()='svg']/*[name()='g' and @fill-rule='evenodd']  - "flipcart" web search item	xpath
		
		//fun fact about LOG4j dependencies - CVE is a cyber security issue where issues are registered  (security vulnurbility database)
		//log4j - is an API that is used for getting all logins IDs etc all data base. 

}
