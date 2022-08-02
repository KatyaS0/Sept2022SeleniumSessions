package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MonkeyTesting {

	public static void main(String[] args) {
		//monkeytest - random testing - we do not know where the user will click, maybe random things. 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		Thread.sleep(4000);
		
		List<WebElement> footerList = driver.findElements(By.cssSelector("div.navFooterVerticalRow li a")); 
		int footerCount = footerList.size(); //1-26
		System.out.println("Total footer links: " + footerCount);
		
		for(int i=-; i<footerCount; i++) {
			//lets generate random number
			int randomIndex = (int)Math.floor(Math.random() * footerCount); //generates random number "(int)" will return you whole number without decimal 
			System.out.println(randomindex);
			
			WebElement e = footerList.get(randomIndex); // capture the number and give me text
			System.out.println(e.getText());
			e.click(); // click on that element 
			driver.navigate().back(); // back  - basically go back to footer and do the for loop again 
			footerList = driver.findElements(BycssSelector("div.navFooterVerticalRow li a"));
			//so it will execute up to 26
		}
		
		
		
		
	}

}
