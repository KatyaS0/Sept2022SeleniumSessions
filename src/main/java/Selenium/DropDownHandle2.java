package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle2 {

	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		
//		Select select1 = new Select(driver.findElement(country));
//		select1.deselectByVisibleText("India");
//		
//		Select select2 = new Select(driver.findElement(industry));
//		select2.deselectByVisibleText("Education");
		
		//what if we want to choose more than one option? We would need to create obj of select everytime. Here is what we can do
		
//		doSelectVisibleText(country,"india");
//		doSelectVisibleText(industry,"Education");
		
		selectDropDownValue(country, "index", "5"); 
		selectDropDownValue(industry, "visibletext", "Education");
		selectDropDownValue(country, "value", "India"); 
		
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator); 
	}
	
	public static void doSelectVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public static void doSelectDropDownByIndex (By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public static void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	//now how do we create one generic method here? 

	public static void selectDropDownValue(By locator, String type, String value) {
		
		Select select = new Select(getElement(locator));
		
		switch (type) {
		case "index":
			select.selectByIndex(Ineteger.parseInt(value)); //we do conversion here
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		
		default:
			System.out.println("please pass the correct selection criteria.....");
			break;
		}
		
		//we can also do enum class but I do not like the it.Too complicated.
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
