package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImageCount {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("htpps://www.amazon.in");
		
		//lets get images. tag in inspection is "img". 
		
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		System.out.println(imagesList.size());
		
		for (int i=0; i<imagesList.size(); i++) {
			String imageUrl = imagesList.get(i).getAttribute("src"); // this will be in yellow. src is the attribute. 
			//This will capture your url for the image because of src (source)
			System.out.println(imageUrl); 
		}
		
		// this concept is called "web Scrapping" because if you have these urls or images you can use it in your web application. 

	}

}
