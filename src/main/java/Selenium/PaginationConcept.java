package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://babynames.merchat.com/popular.cgi");
		
		List<WebElement> nameList = driver.findElements(By.xpath("(//a[contains(text(),'Hela'])"));
		
		while(true) {
			if(!(nameList.size() == 1)) { //list count will be 0 since i
				//"next" logic button. So if its not found on first page, what do we do?
				driver.findElement(By.linkText("Next")).click(); //this will continue to click "next"
				nameList = driver.findElements(By.xpath("(//a[contains(text(),'Hela'])")); // this will update the list everytime it is runing 

			}
			else {
				String title = driver.findElement(By.xpath("//a[contains(text(), 'Hela')]/../parent::td//following-sibling::td)[2]//a")).getAttribute("title");
				System.out.println("title");
				break;
			}
		}

		
	}

}
// so "if" part will run and search, and else is when value is found
//we need to write findElements.