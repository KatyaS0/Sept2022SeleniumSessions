package Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtil {  // so this class is being made to call the methods 

	/**
	 * This method is used to get all the values form drop down
	 * @param element
	 */	
	public static ArrayList<String> getDropDownValues(WebElement element) { //so we pass params
		Select select = new Select (element);
		
		List<WebElement> dropList = select.getOptions(); 
		System.out.println("total number of values in drop down: " + dropList.size());	
		//we can create an array List
		ArrayList<String> ar = new ArrayList<String>();
					
		for(int i=0; i<dropList.size(); i++) {
			String text = dropList.get(i).getText();
			//System.out.println(text); 
			ar.add(text); 
		}
		
		return ar; // so instead of void in the method we will put ArrayList<String>
		
	}	
	/**
	* *This method is used to select the value from a drop down on the basis of given text 
	* @param element
	* @param value
	*/
	public static void selectValueFromDropDownByText(WebElement element, String value) { // we have to pass params here. we will make it static so we can call it directly 			
		Select select =  new Select (element);
		select.selectByValue(value);
			
	}
	/**
	* *This method is used to select the value from a drop down on the basis of given index 
	* @param element
	* @param index
	*/
	public static void selectValueFromDropDownByIndex(WebElement element, String index) { // we have to pass params here. we will make it static so we can call it directly 			
		Select select =  new Select (element);
		select.selectByValue(index);
			
	}
	
	/**
	 * this method is used to select teh values form the drop down without sleect class
	 * @param driver
	 * @param locator
	 * @param value
	 */
	
	public static void selectDropDownValueWithoutSelect(WebDriver driver, String locator, String value) {
	List<WebElement> dropList = driver.findElements(By.xpath(locator)); 
	System.out.println(dropList.size());
	
	for( int i=0; i<dropList.size(); i++) {
		String text = dropList.get(i).getText(); 
		System.out.println(text); 
			 if(text.equals(value)) { 
				 dropList.get(i).click();
				 break;
				 
	 }
	}	 
}
