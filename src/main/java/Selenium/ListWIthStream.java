package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListWIthStream {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		
		By industry_options = By.xpath("//select[@id='Form_submitionForm_Industry']/option"); 
		
		//lets create a list (sequential)
		List<WebElement> indus_list = driver.findElements(industry_options);
		
		long startTime = System.currentTimeMillis(); //this is timer
		
		indus_list.stream().forEach(ele -> System.out.println(ele.getText())); //give text of each and every element (ele)
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);


		//stream can be applied for list only. Stream will create a line of sequential values. To fetch the value in stream,  we use Lambda
		//paralel and sequential stream types
		// -> is a labmda arrow
		
		indus_list.parallelStream().forEach(ele -> System.out.println(ele.getText())); //we will get random order here. memory consumption will be higher then sequential
				
		//this is how you save time in selenium
		
		//paralel will take shorter time htan sequential. 

		
		
	}

}
