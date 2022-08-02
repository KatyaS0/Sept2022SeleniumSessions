package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureTotalTextFields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://register.rediff.com/register/register.php");
		//List<WebElement> listInput = driver.findElements(By.tagName("input")); //but there can be many inputs. What if we want to capture input that has "text"? 
		//so we should not use By.tagName
		List<WebElement> listInput = driver.findElements(By.xpath("//input[@type='text']")); // we can use xpath. And it will find those inputs that contain "text". 
		//this is how you create xpath 
		System.out.println(listInput.size()); 
		//what is we want to go thru ecah and every input
		
		for(unt i=0; i<listInput.size(); i++) {
			listInput.get(i).sendKeys("Naveen"); //this is to put the values into the inputs that has Inpute"text". It will type in "Naveen" into them 
		}
		
	}

}
