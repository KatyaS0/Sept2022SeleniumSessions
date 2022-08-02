package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("Http://app.hubspot.com/login"); 
//		JavascriptExecutor js = (JavascriptExecutor) driver; //this is the convertor 
//		js.executeScript("alet('hi')");
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver); //we need to create an obj
		String title = jsUtil.getTitleByJS();
		System.out.println(title); 
		
		//jsUtil.generateAlert("this is my js pop up"); //in the console, when inspecting, type "alert", and it will give you the message
		
		String innerText = jsUtil.getPageInnerText(); //give me the text of the entire page
		System.out.println(innerText.contains("customer service")); // this is form different web actually not hub spot
		//this method is powerful because it capture whole text of rthe page, while in sleenium you get the text of the specific element 
		
		jsUtil.refreshBrowserByJS(); // write history.go(0) this is javscript for console in the 'inspect'
		
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']")); //we want to highlight thwe login button so inspect the button 
		WebElement loginForm = driver.findElement(By.id("loginForm"));
		jsUtil.drawBorder(login); //just literary creating a red border (its red because of util folder)
		// you can use this in case of taking a screenshot to draw attention 
		
		WebElement emailId = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));
		jsUtil.flash(emailId);
		emailId.sendKeys("test@gamil.com");
		jsUtil.flash(password);
		password.sendKeys("34567"); 
		
		jsUtil.flash(login); //this method will highlight the element. It will flash green-red-green-red
		jsUtil.flash(loginForm);
		
		//FLASH METHOD is not availbale in Selenium, only JavaScript. 
		
		WebElement register = driver.findElement(By.linkText("register"));
		jsUtil.clickElementByJS(password);
		
		//ways to use click:
		//WE - click
		//Actions - click
		//actions-MoverElement - click
		//JS - click
		//Explicitly Wait - we - click 
		
		jsUtil.scrollPageDown(); 
		//JavaScript code:
		//window.scrollTo(0,document.body 
		//window.scrollTo(0,document.body.scrollHeight) - will go form top to bottom
		//window.scrollTo(document.body.scrollHeight,0) - will go from bottom to top
		//SELENIUM DOES NOT HAVE SCROLL METHOD 
		
		jsUtil.scrollPageDown();
		Thread.sleep(3000);
		jsUtil.scrollPageUp();
		Thread.sleep(3000); 
		jsUtil.scrollPageDown("300"); //this is the height
		WebElement heading = driver.findElement(By.xpath("//span[text()='Popular products in PC internationally']");
		jsUtil.scrollIntoView(heading);
		System.out.println(heading.getText());
		//THIS METHOD IS NOT AVAILABLE IN SELENIIUM DIRECTLY 
		
		//document.getElementById('input-email').value="kat" this will put kat into the email. 
		WebElement emailId2 = driver.findElement(By.id("input-email"));
		emailId.sendKeys("kat@gmail"); 
		//System.out.println(emailId2.getText()); but this wil not work to capture the text, so use the next method
		String val = emailId2.getAttribute("value");
		System.out.println(val); // this is how to capture the text value 
		
		//convert your driver to java script executor 
		//document.title on the console when you inspect the page. Document is the "DOM"
		//JavaScript is an interface 
		

	}

}
