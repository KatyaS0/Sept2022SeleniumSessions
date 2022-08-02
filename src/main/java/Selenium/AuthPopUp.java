package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopUp { // its a pop up that comes up in the top middle asking for user name and password, its not a web element and you cannot inspect it

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARTYOMKA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth"); //thsi will put in credentials into the fields. but one you run this code, the window
		//wont pop up anymore while running the code 
		
		
		
	}

}
