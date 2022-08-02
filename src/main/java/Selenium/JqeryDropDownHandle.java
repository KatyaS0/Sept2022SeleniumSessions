package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqeryDropDownHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //old code because of old pom
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		//List<WebElement> choiceList = driver.findElements(By.xpath("//div[@class='comboTreeDropDownContainer']//il/lo/span[@class='comboTreeItemTitle']"));
//		
//		for(int i=0; i<choiceList.size(); i++) {
//			System.out.println(choiceList.get(i).getText()); // print the list,
//				String text = choiceList.get(i).getText(); //get the text of the list 
//					if(text.equals("choice 2 3")) { //and choice choice 2.3
//						choiceList.get(i).click();
//						break; 
//					}
//		}
		//so how do we choose multiple choices?
		
//		selectChoiceValues(driver,"choice 2");
//		selectChoiceValues(driver,"choice 2 3");
//		selectChoiceValues(driver,"choice 6 2 3");
		
		//the problem with this approach is what if you want to call it 10 times? select 10 values? How do we solve it?
		//you change in the method below: WebDriver driver, String...value) the three dots represnet an array - this emans youcan pass multiple choices 
		
		//selectChoiceValues(driver,"choice 2", "choice 2 3", "choice 6 2 3");// but what if we want to select all values?
		selectChoiceValues (driver, "ALL"); // you pass "ALL" key word when you want to choose all. 


	}
	/**
	 * 
	 * @param driver
	 * @param value
	 */
	
	public static void selectChoiceValues(WebDriver driver, String... value) {
		List<WebElement> choiceList = driver.findElements(
				By.xpath("//div[@class='comboTreeDropDownContainer']//il/lo/span[@class='comboTreeItemTitle']"));
		//for ALL:
		if(!value[0].equalsIgnoreCase("ALL")) { //ignore because anyone can write ALL Differently: all, All, ALL. This will directly jump into else part because the sattement is FALSE
			for(int i=0; i<choiceList.size(); i++) {
				System.out.println(choiceList.get(i).getText());
				String text = choiceList.get(i).getText(); 
		
					for(int k=0; k<value.length; k++) {
						if(text.equals(value[k])) { 
							choiceList.get(i).click();
							break;
					}
				}
			}
		
		}
		//select all the values here now:
		else {
			try {
				for(int all=0; all<choiceList.size(); all++)) {
					choiceList.get(all).click(); 
				}
			}catch(Exception e) {
				//the exeception will be gone
			}
		} // now here we have 44 choices, but only up to choice 7 is visibale, other choices will come out black on the counsol, so how do we solve the 
		//"ElementNotInteractableExceptio" which are the blanks ones? we add try-catch block. 
	}
}
		
		// specific choice:
//		for(int i=0; i<choiceList.size(); i++) {
//			System.out.println(choiceList.get(i).getText()); // print the list,
//			String text = choiceList.get(i).getText(); //get the text of the list 
//			if(text.equals(value)) { //and choice choice 2.3
//				choiceList.get(i).click();
//				break; 
			//the problem with this approach is what if you want to call it 10 times? select 10 values? lets see the code below
		
		// here we are doing array for loop for multiple choices:
//		for(int i=0; i<choiceList.size(); i++) {
//			System.out.println(choiceList.get(i).getText());
//			String text = choiceList.get(i).getText(); 
//		
//				for(int k=0; k<value.length; k++) {
//					if(text.equals(value[k])) { 
//						choiceList.get(i).click();
//						break;
//					}
		
				
