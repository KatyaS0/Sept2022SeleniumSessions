package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToEleemntConcept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
		//so sometimes there is a main tab and sub tabs. 
		
		Actions action = new Actions(driver); // this is availbale n=only seleenium. Here we have to pass the driver here.
		
		WebElement contentLink = driver.findElement(By.className("menulink"));
		
		action.moveToElement(contentLink).build().perform(); // this will move mouse and open the main menu and you will see sub menu
		//build means you collect this particular action and you perfome it

		//so how do we click on it		
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("COURSES")).click(); // this will click on the sub menu
		
		
		
		
		
	}

}
