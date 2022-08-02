package Selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListWithStreamAndFilter {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		By links = By.tagName("a"); 
				
		List<WebElement> linksList = driver.findElements(links);
		
		System.out.println(linksList.size());
		
		List<String> collectList = linksList //we want to filter out in this method. BTW "ele" is just name, we can put abc as well
				.stream()
					.filter(ele -> !ele.getText().equals("") && ele.getText().contains("Amazon")) //this will exclude all blanks here and also there are 2 filters. so we cna use many filters. 
							.map(ele -> ele.getText())
								.collect(Collectors.toList());
		
		//applying more filters:
		
		List<String> collectList2 = linksList 
				.stream()
					.filter(ele -> !ele.getText().isEmpty())
					.filter(ele -> !ele.getText().startsWith(" ")) //the ! will exlude the things you need. SO here it will exclude blank space
							.map(ele -> ele.getText().trim())
								.collect(Collectors.toList());
		
		//how will we itterate this list? We can use forEach loop
		
		collectList.stream().forEach(ele -> System.out.println(ele)); //350 milis
		collectList.parallelStream().forEach(ele -> System.out.println(ele)); //357 milis
		
		//LAMBDA came into the system after JDK 1.7. You need to use JDK 1.8 to use it or it will give you error
								
								
		
		
		
		
		
	}

}
