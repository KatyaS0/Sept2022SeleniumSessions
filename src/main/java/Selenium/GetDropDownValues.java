package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDropDownValues {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		Select select = new Select (day);
		
		List<WebElement> daysList = select.getOptions(); // the options are available (chidl options) form select drop down menu
		System.out.println("total days: " + daysList.size()) // we will see how many values are there in the first drop down which is "day" 
		
		//how do we print all values form drop down
		
		for(int i=0; i<daysList.size(); i++) {
			String text = daysList.get(i).getText();
			System.out.println(text); //we will get all 31 days here printed onthe console. 
			
		}
		//so here same problem, we would need to do this for every drop donw menu. Can we create one generic method?
		
		getDropDownValues(day);
		getDropDownValues(year);
		getDropDownValues(month);

		
		
	}
	/**
	 * This method is used to get all the values form drop down
	 * @param element
	 */
	
	public static void getDropDownValues(WebElement element) { //so we pass params
		Select select = new Select (element);
		
		List<WebElement> dropList = select.getOptions(); 
		System.out.println("total number of values in drop down: " + dropList.size());		
		
		for(int i=0; i<dropList.size(); i++) {
			String text = dropList.get(i).getText();
			System.out.println(text); 
			
		}
		
	}
	
	
	
	
	
}