package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		
		String day = "//select[@id='day']/option";
		String month = "//select[@id='month']/option";
		String year = "//select[@id='year']/option";

		
		DropDownUtil.selectDropDownValueWithoutSelect(driver, day, "13");
		DropDownUtil.selectDropDownValueWithoutSelect(driver, month, "Jun");
		DropDownUtil.selectDropDownValueWithoutSelect(driver, year, "1987");
		
		//this will be selected and printed

		
		
//		List<WebElement> daysList = driver.findElements(By.xpath("//select[@id='day']/option")); // we will not use any select class here. We will go by ID
//		System.out.println(daysList.size());
//		
//		for( int i=0; i<daysList.size(); i++) {
//			String text = daysList.get(i).getText(); 
//			System.out.println(text); 
//				 if(text.equals("25")) { //  this will make the system not print after 25 and wlill select 25. 
//					 daysList.get(i).click();
//					 break;
//					 
		//We moved this method in Util
//				 }
			
		
		}
		
		
	}

}
