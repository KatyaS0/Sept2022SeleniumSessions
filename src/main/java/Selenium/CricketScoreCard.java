package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketScoreCard {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.espncricinfo.com/series/19430/scorecard/1187009/india-vs-south-africa-3rd-test-icc-word-test-champtionship-2019-2021");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); 
		
		List<WebElement> scoreList = driver.findElements(By.xpath("//a[contains(text(),'Am Rahane')]//parent::div//following-sibling::div[@class='cell runs']"));
		System.out.println(scoreList.size());
		
		for(int i=0; i<scoreList.size(); i++) {
			System.out.println(scoreList.get(i).getText());
			
		}
		
		
		
	}

}
