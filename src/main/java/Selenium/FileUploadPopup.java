package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopup {

	public static void main(String[] args) {
		
		//so how to handle if you need to upload file from your operating system? Lets say you want to upload somehting in the browser. You click on "choose file"
		//and then it takes you to your operating systme to choose it. Once that file from your op. sys. pops up, selenium is blocked. It cannot do anything with your
		//op.sys. Only web browsers. So how do you handle this situation? 
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://cgi-lib.berkeley.edu/ex/fup.html");
		driver.findElement(By.name("upfile")).sendKeys(") "
		//so the reason why not "click" is because if you click on "choose file" selenium will be blocked
		//but if you use sendKeys, you will just need to pass the location of that particular file you want to pass. the file you want to upload 
		
		// but there is one catch: if you inspect the "choose file" and the "type ="file"" is not there, this code will not work
		// you would have to use different language to make it work
		//so what do you do if its not there? you go to developer and ask to add it in the code


	}

}
