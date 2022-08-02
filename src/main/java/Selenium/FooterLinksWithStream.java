package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinksWithStream {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freworks.com/");
		
		driver.findElements(By.cssSelector("ul.footer-nav li a")) //this is way fastre than forEach loop
			.stream()
				.filter(ele -> !ele.getText().isEmpty()) //exclude  empty text 
				.forEach(ele -> System.out.println(ele.getText()));
	}

}
