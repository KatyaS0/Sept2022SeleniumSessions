package com.pages;

import org.openqa.selenium.By;

public class GooglePage extends BasePage{
	
	//page actions:
	public void googleSearchTest() {
		
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("Katya");
		driver.findElement(By.name("q")).submit();
		driver.findElement(By.xpath("//h3")).stream().forEach(ele -> System.out.print(ele.getText()));
		
	}
	
	public void tearDown() {
		driver.quit();
	}

}
