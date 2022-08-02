package Excel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://app.hubspot.com/login");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); this code does not work for some reason 
		
		WebElement userName = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		
		Xls_Reader reader = new Xls_Reader("/Selenium/src/main/java/Excel/SampleExcel.xlsx");
		String sheetName = "login"; 
		
		int rowCount = reader.getRowCount(sheetName);
		
		for(int rowNum =2; rowNum<=rowCount; rowNum++) {
			String loginId = reader.getCellData(sheetName, "username", rowNum);
			String password = reader.getCellData(sheetName, "password", rowNum);
			
			System.out.println(loginId + " " + password);
			
			userName.clear();
			userName.sendKeys(loginId);
			
			pwd.clear();
			pwd.sendKeys(password);
			
			
		}
		
		
	}

}
