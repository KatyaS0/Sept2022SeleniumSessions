package Selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlePopUpWithList {
	public static void main(String[] args) {
		//AScenario: open orange - click on link - new window pop up - close the new window. SECOND WAY with using LIST ARRAY
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		// we need to move the driver from main to pop up windown. Once we close, the driver will be lost so we need to put it back to main windown 
		Set<String> handles = driver.getWindowHandles();
		
		List<String> handlesList = new ArrayList<String>(handles);
		String parentWindow = handlesList.get(0);
		String childWindow = handlesList.get(1);
		
		driver.switchTo().window(childWindow); // so we have to pass the ID. So now driver is on the child window 
		// lets say we want to capture the tittle on the pop up page
		System.out.println("child window title is : " + driver.getTitle());
		//so now we have to close the window.
		driver.close(); // if you use quit method, it will close both windows so better "close"
		//so now driver is lost. We need to switch back. 
		driver.switchTo().window(parentWindow); //now the driver is back to parent window 
		System.out.println("parent window title is: " + driver.getTitle());
		driver.quit();

		//if there are too many pop ups like advertisement/random/ you cannot predict a pop up , you can handle with selenium but its complex, so you ask your developer to block the pop-ups
		//NEVER AUTOMATE/CCANOT AUTOMATE: (with selenium):
		//1. OTP
		//2. CAPTCHA/RE-CAPTCHA - IT SI TO PREVENT AUTOMATION
		//3. TWO-FACTOR AUTH 
		//4. RANDOM POP UPS 
		//5. PERFOMANCE TESTING
		//6. API
		//7. GMAIL/EMAIL AND FACEBOOK LOGINS - YOU WILL BE BLOCKED FROM THESE CITES, YOU SHOULD ALWAYS USE APIs FOR THESE NOT SELENIUM
		//8. LOAD/STRESS/PERFOMANCE TESTING - SELENIUM NOT CREATED FOR PERFOMANCE JOB
		//9. LINK SPIDERING - YOU CAN DO IT, BUT NOT A GOOD PRACTICE.
		//GOOD WEB FOR MORE INFO: https://www.selenium.dev/documentation/test_practices/discouraged/
		//selenium is NTO A TESTING TOOL. Just web automation tool. Simulate user actions 
		//Selenium is just a LIBRARY/FRAMEWORK/TOOL/SET OF APIs/
}
