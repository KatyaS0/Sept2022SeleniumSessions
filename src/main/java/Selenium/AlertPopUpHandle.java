package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//you can actually execute your own pop up alert on the browser by clicking "inspect" -> "Console" -> write "alert ('abc...');" 
		//java script pop up. 
		//you cannot inspsect error, because this is not a web element. 
		
		driver.get("http://mail.rediff.com/cgi-bin/login.cgi");
		//lets inspect "go" button, and since there is no "id", we will use "name"
		driver.findElement(By.name("proceed")).click();//clicking on "Go" button
		
		Thread.sleep(5000);
		
		//we have to switch from main page to pop up page.(we did not but any credentials into log in thats why its giving pop up)
		Alert alert = driver.switchTo().alert();  // this alert is an interface, cannot create obj bit can create reference. This is only responsible for JAVASCRIPT pop up
		String text = alert.getText(); 
		System.out.println(text);
		//lets text it:
		
		if(text.equals("Please enter a valid user name")) {
			System.out.print("correct error message...");
		}
		else {
			System.out.print("incorrect error msg...");
		}
		alert.accept(); //it will click on "ok" button
		
		alert.dismiss();//cancel the alert 
		

	}

}
