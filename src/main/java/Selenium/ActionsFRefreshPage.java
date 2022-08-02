package Selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsFRefreshPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		Thread.sleep(4000);
		
		Actions act = new Actions(driver);
		//act.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).build().perform();
		act.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).build().perform(); 
		
		//either will work.
		
		//heatmap: its area of where the most users go - its literary a heatmap with colors of temperature. 
		//monkeytest - random testing - we do not know where the user will click, maybe random things. 
		
	}

}
