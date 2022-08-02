package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		//maintain one parent ID separatly when you close child window (driver will get lost so this is a method for it) below:
		String parentWindowId = driver.getWindowHandle(); //capture window id immediately 
		
		driver.switchTo().newWindow(WindowType.WINDOW); //Selenium 4.x feature added - one more window browser will open. So not in one window, but two. You can also use code WindowType.tab
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.close();//close child window  
		//driver is lost, now we need to come back to parent window:
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());

		
	}

}
