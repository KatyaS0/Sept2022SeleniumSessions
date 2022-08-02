package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxWithStream {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html/");
		driver.findElements(By.cssSelector("td.select-checkbox")) //this will choose cehckbox 
				.stream() 
					.forEach(ele -> ele.click()); 
		
		//Stream() is = "FOREACH LOOPS"	just modified forEach Loop
		
	}

}
