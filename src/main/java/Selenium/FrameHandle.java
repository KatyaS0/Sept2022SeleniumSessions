package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		WebElement frameElement = driver.findElement(By.name("main"));
		driver.switchTo().frame(frameElement); 
		
		//second way to get it
		
		driver.switchTo().frame("main"); // these methods will capture the text
		 
		// or by index
		driver.switchTo().frame(2); // there can be several frames 
		//driver is available in the frame sometimes a=so we have to take it back to the main page 
		
		driver.switchTo().defaultContent(); // this will bring the driver to the main page if driver is lost but its not compensary 
		
		
		String text = driver.findElement(By.cssSelector("body>h2")).getText(); // to find the frame, there wil be a tag if the frame is available. 
		//You rigth click on it and see view frame souce. Frame is a web element 
		System.out.println(text); 
		//sometiems there are frame in the frame in the frame. And the element is in the last frame (child frames). what if you need to capture the element in the child frame?
		// if the driver is available in the main page you would have to transfer the driver to parent frame to first child frame, to second chidl frame etc. And the
		//transfer the driver back to main page by using default method. Those are called nested frames. 
		
		
		
		
	}

}
