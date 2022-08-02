package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://ixigo.com/");
		
		//(//table[@class='rd-days'])[4]//div[text()='5']
		
		driver.findElement(By.xpath("//input[@placeholder ='Depart' and @type=)'text']")).click();
	
		//here we will need to figure out how to click on the arrow that clicks thru months on the calendar 
		Thread.sleep(2000);
		
		String startMonthValue = driver.findElement(By.xpath("(//div[@class='rd-month-label'])[1]")).getText();
		
		while(!startMonthValue.contains("February 2021")) {
			driver.findElement(By.xpath("(//button[@class='ixi-icon-arrow rd-next'])[1]")).click(); //next arrow now
			startMonthValue = driver.findElement(By.xpath("(//div[@class = 'rd-month-label'])[1]")).getText();
		}
		//start date: 
		List<WebElement> startDateList = 
				driver.findElements(By.xpath("(//div[@class='rd-month'])[1]/table//div[contains(@class, 'day')]"));
		
		for(WebElement e : startDateList) {
			if(e.getText().equals("19")) {
				e.click();
				break; //this will select date 19 
			}
		}
		
	
		//end date: inspect "return" date 
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder ='Return' and @type=)'text']")).click();
		
		Thread.sleep(2000);
	
		String endMonthValue = driver.findElement(By.xpath("[//div[@class='rd-month-label'])[4]")).getText();
		
		while(!endMonthValue.contains("September 2021")) {
			driver.findElement(By.xpath("(//button[@class='ixi-icon-arrow rd-next'])[2]")).click(); //next arrow now
			endMonthValue = driver.findElement(By.xpath("(//div[@class = 'rd-month-label'])[4]")).getText();
		}
		
		List<WebElement> endDateList = 
				driver.findElements(By.xpath("(//div[@class='rd-month'])[4]/table//div[contains(@class, 'day')]"));
		
		for(WebElement e : endDateList) {
			if(e.getText().equals("18")) {
				e.click();
				break; //this will select date 19 
			}
		}
		
	}

}
