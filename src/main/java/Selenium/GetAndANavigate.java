package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAndANavigate {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARTYOMKA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		
		driver.get("http://www.amazon.in/");
		driver.navigate().to("http://www.amazon.in/");
		System.out.println(driver.getTitle()); 
		
		//the difference between get and navigate is:
		//Get: the title will be printed AFTER the page is being loaded fully (when that circle disapears on the  tab)
		//Navigate: will not care if the page is loaded. Once it navigates it prints on the console. it does not wait until the page loads 
		//Get method is better because you have to wait until everything is loaded and then perform action 

	}

}
