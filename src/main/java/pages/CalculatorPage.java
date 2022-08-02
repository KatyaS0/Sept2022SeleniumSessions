package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorPage { // so thi sclass requeires some downloads I could not do. Some claculator dowloads. But we can use any application as long as its "ng"
	
	WebDriver driver;
	NgWebDriver ngWebDriver; 
	JavascriptExecutor jsDriver; 
	
	//all these are ng-model - we have to use by angular locator
	ByAngularModel  first = ByAngular.model("first"); 
	ByAngularModel  second = ByAngular.model("second"); 
	ByAngularModel  operator = ByAngular.model("operator"); 
	//button is ng-click there
	ByAngularButtonText go = new ByAngular.buttonText("Go!");
	
	By result = By.tagName("h2"); 
	
	//lets create a constructor
	
	public CalculatorPage () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		jsDriver = (JavascriptExecutor)driver;
		ngWebDriver = new ngWebDriver(jsDriver);
		driver.get("https://localhost:3456"); //this does not exist btw
		ngWebDriver.waitForAngularRequestsToFinish(); // this is used not to use all those exp/imp waits, this code will do it automatically, 
		
	}

	public String doSum(String v1, String v2) {
		driver.findElement(first).clear();
		driver.findElement(first).sendKeys(v1);

		driver.findElement(second).clear();
		driver.findElement(second).sendKeys(v2);
		
		driver.findElement(operator).sendKeys("+");
		driver.findElement(go).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		
		System.out.println(driver.findElement(result).getText());
		return driver.findElement(result).getText();


		//we can create division, multiplictaion etc constructors like this
		
		
	}

}
