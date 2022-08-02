package Selenium;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLogin {

	public static void main(String[] args) {

		//this is how to use Hashmap with selenium with logic credentials
		
        Map<String, String> userMap = new HashMap<String, String>();

        userMap.put("admin", "admin_admin");
        userMap.put("patient", "Tom@gmail.com_test123");
        userMap.put("doctor", "peter@gmail.com_test1234");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();      
        driver.get("https://app.hubspot.com/login");
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)) code does not work
        
        //driver.findElement(By.id("username")).sendKeys(userMap.get("patient").split("_")[0]); //string will give you an array
        //driver.findElement(By.id("password")).sendKeys(userMap.get("patient").split("_")[1]);    
		doLogin(driver, getUserMap(), "patient"); //you can pass getUserMap(); here in the middle
   
        
	}
	//we will create a generic method
	public static Map<String, String> getUserMap () {
		Map<String, String> userMap = new HashMap<String, String>();
        userMap.put("admin", "admin_admin");
        userMap.put("patient", "Tom@gmail.com_test123");
        userMap.put("doctor", "peter@gmail.com_test1234");
		return userMap;
		
		//you can also store these credentials in Excel file too and get ot from there.
		
	}
	public static void doLogin(WebDriver driver, Map<String, String> userMap, String userKey) {//hashmap can be passed as a paaram 
		driver.findElement(By.id("username")).sendKeys(userMap.get("patient").split("_")[0]);
        driver.findElement(By.id("password")).sendKeys(userMap.get("patient").split("_")[1]);
  	}

}
