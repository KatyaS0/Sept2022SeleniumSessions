package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//how do we handle drop down menu. We need to inspect drop down menu first. You see the tag is "<select" that is a class in sleenium
		driver.get("https://www.facebook.com/");
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		//we need to create an obj of s"select" class
		
		Select select = new Select(day); // we need to pass a web element which here is year, month and day
//		select.selectByVisibleText("5");
//		
//		select.selectByIndex(10); // you can also use this one instead of Visible text but visible is better because it can change next day. This is only for constant data
//		
//		Select select1 = new Select (month);
//		select.selectByVisibleText("may");
//		select.selectByIndex(8);
//		
//		
//		Select select2 = new Select (year);
//		select.selectByVisibleText("1995"); 
//		
//		//problem is we have to keep creating. WHta if there are 20 drop downs? We would need to create 20 of them. How to fix it?
//		
//		
//		//we create this
//		selectValueFromDropDown(day, "5");
//		selectValueFromDropDown(month, "May");
//		selectValueFromDropDown(year, "1990");
		
		select.isMultiple(); // can i select multi-selection drop down for this case will return "false" but hardly can they be found. So this is like when you put into one
		//selection multiple like when you put skills on application. 


		
		
	}
	//we will come out of main method and have one method
	
	//this is called generic approach
	
	/**
	 * *This method id used to select teh vlaue from a drop down on the basis of given text 
	 * @param element
	 * @param value
	 */
	public static void selectValueFromDropDownByText(WebElement element, String value) { // we have to pass params here. we will make it static so we can call it directly 
		
		Select select =  new Select (element);
		select.selectByValue(value);
		
	}
	public static void selectValueFromDropDownByIndex(WebElement element, String value) { // we have to pass params here. we will make it static so we can call it directly 
		
		Select select =  new Select (element);
		select.selectByValue(value);
		
		
	}	

	//***** SELECT METHOD IS ONLY AVAILBALE IF YOU HAVE "SELECT" TAG IN THE CODE. OTHERWISE YOU CANNOT USE IT.
	
	
}
