package Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopUpHandle {

	public static void main(String[] args) {

		//pop up page of like a new window of the browser. SO how do you handle it. 
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		//so when the pop up page comes up, its a child page of main parent page. Parent page has the driver and that driver needs to be passed on to child 
		//to perform any action. Once you close the pop up, the driver is lost so you need it to come back to parent class. 
		//you cannot use directly driver.getEliment(By.title) etc ont he child window, because driver control is available on the parent window.
		//so how do you switch from parent to child and back? 
		//every window having their own window id. and we can switch the windows 
		
		driver.findElement(By.linkText("Good PopUp #3")).click(); //so we need 2 window ids
		
		Set<String> handles = driver.getWindowHandles(); // the moment you create this line, "Set" it does not maintain any index or order or hold dublicate values.
		//it will store on the bases. Here "handles" obj will be created and divide into two memory alocatiosn: Child ID and Parent ID. We need to use iterator
		
		Iterator<String>it = handles.iterator(); //it will work like a loop but "iterator" is for codes that do not maintan the order. it will come inside the memory 
		//and it will point just abie the memory of that object. lets say your obj is on the line 2, so IT. will point on line 1. But you need to find your IDs.
		//so you simply write it.next(); and it will move to the parent/child window and capture the ID, and you keep coding "next" and it will capture next ID.
		
		String parentWindowID = it.next(); //this is how you move iterator. 
		System.out.println("parent window id is: " + parentWindowID);
		
		String childWindowID = it.next(); 
		System.out.println("child window id is: " + childWindowID);
		//now we have to jump into the objects. the first one will be parent. So we need to switch drivers now
		
	
		driver.switchTo().window(childWindowID); // so we have to pass the ID. So now driver is on the child window 
		// lets say we want to capture the tittle on the pop up page
		System.out.println(driver.getTitle());
		//so now we have to close the window.
		driver.close(); // if you use quit method, it will close both windows so better "close"
		//so now driver is lost. We need to switch back. 
		driver.switchTo().window(parentWindowID); //now the driver is back to parent window 
		System.out.println("parent window title is: " + driver.getTitle());
		driver.quit(); // since we using just one window we can use it, but you can use any 
		
		//so what if you open 2 popup windows? there are 2 aproaches:
		//>>FIRST APPROACH: Parent window will open child and another child pop up. Move the driver to PopUp 1, then close, then the lost driver move to popup 2, 
		//and then move the driver back to parent
		//>>SECOND APPROACH: open first pop up, switch the driver to it, close it, switch back to parent, open 2nd pop up switch driver and then back to parent.
		//!!!Second approach is better because you are maintaining one window (and ID) at the time, but in first approach you try to maintain 2 windows at the same time. 
		//>>RARE CASE: If you have parent pop up link, then child opens up and has another pop up link and it opens another pop up window, you would close each one 
		//and move the driver from the second pop up, close it, and to the first pop up, close it, and move to the parent back. 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
