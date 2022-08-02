package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html"); 
		
		Actions action = new Actions(driver);
		
		WebElement sourceElement = driver.findElement(By.id("draggable")); //you take the draggable and put it into droppable.  this is what we are doing here
		WebElement targetElement = driver.findElement(By.id("droppable"));
		
		action.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform(); 
		// so here "build" is literary meaning building your actions and performing. Without this you cannot perform your actions. It wont work. 
		// this is only for web element not file dropping 
		//or we cnause a direct method
		
		action.dragAndDrop(sourceElement, targetElement).build().perform(); 
		
		
	}

}
