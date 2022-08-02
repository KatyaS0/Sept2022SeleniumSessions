package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalPageLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//we want to check how many links are available on the page ( every link has "a" attached to it in the code. 
		driver.get("htpps://www.amazon.in");
		List<WebElement> linkslist = driver.findElements(By.tagName("a")); //this method is used to find "multiple similar elements" while findEliment searches for a specific element
		// this will store the values by indexing (0, 1, 2)
		System.out.println("total number of links: " + linkslist.size()); //306 links.but there can be hidden links. They do not have any text
		
		for(int i=0; i<linkslist.size(); i++) {
			String text = linkslist.get(i).getText(); //this captures text of the link. whatever it says on the link like link "about us". Captures from left to right, top to bottom 
			System.out.println(text); //if you see a big space between texts, thats the system printing the links without text.
			
		}
		// you can use this method above for any web element. 
		
		
	}

}
