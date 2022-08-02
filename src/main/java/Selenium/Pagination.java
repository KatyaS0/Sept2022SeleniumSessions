package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {
	static WebDriver driver;
	
	public static void selectContact(String name) {
		//Scenario: you have 16 pages available in the contacts and you need to find a person within those 16 pages. You would have to click on each to find the name
		// how will we do that?
		String checkBoxXpath = "//a[text() = '" + name
				+ "']/parent::td/preceding-sibling::td/child::input[@type = 'checkbox' and @name='contact-id
		driver.findElement(By.xpath(checkBoxXpath)).click();	
	}

	public static void main(String[] args) throws InterruptedException { 
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("http://classic.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("kikimao");
		driver.findElement(By.name("password")).sendKeys("345678");
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		Thread.sleep(3000);
		
		List<WebElement> pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
		
		//while loop is useful when we do not know how many iterations are there like in this case how many time we have to click to find a spec. name - we do not know
		//in FOR loop, we use it when we KNOW how many time we have to click 
		int i =0;
		while(true) {
			if(driver.findElements(By.linkText("Humpty Dumptu")).size()==1) { //this whole code wikk try to find the name, will keep checking each page
				selectContact("Humpty Dumptu");
				break;
			}
			//pagination logic:
			else {
				try {
				pages.get(i).click(); //next link, next link....
				}
				catch(Exception e) {
					System.out.println("paginayion is over... and did not find any contact"); // this is the pagination is over and it will catch exception
					break;
				}
				pages = driver.findElements(By.xpath("//div[@class='pagination'])[1]/a"));
			}
			i++;
		}
		
		//there is a thing in the "inspect" sometimes named as "shadow-root", xpath cnanot be created for it. Copy jsPath. See shadowDom class
	}
	
	
}
