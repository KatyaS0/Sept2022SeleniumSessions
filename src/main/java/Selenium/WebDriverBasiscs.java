package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasiscs {

	public static void main(String[] args) {
		
		// there is a webdriver that is being created and its an interface
		//we are not able to create an obj of webdriver but we can do reference of parent -child 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARTYOMKA\\Downloads\\chromedriver_win32\\chromedriver.exe"); // this is a server
		
		//Step # 1 : This is automation step
		WebDriver driver = new ChromeDriver (); //1. open the browser. But with only this line of code it will not launch it. You need some sort of server to help 
		//the selenium code work. So what will happen is the code will run thru the server and open the browser. and server will tell SEL. that your code was executed
		// meaning return some output. 
		//also with this command session iD wil be created, some random id. with every code you will execute, session id will be passed 
		
		//driver executables 
		//gecko - server for fire fox 
		//when it was selenium two, they were responsible for exporting web drivers but not after selenium 3
		//after launching the browser, we have to enter url
	
		//Step # 2
		driver.get("http://www.google.com"); //if you do not write "www" it will launch. This is automation step  
		
		//Step # 3
		//now get the titile of the page you can find the name on the page in the browser
		String title = driver.getTitle(); //get the title. This is automation steps
		System.out.println(title);
		
		//Step # 4 its actually finding bugs 
		//validation point: we are just checkin if that title correspond to "Google"
		if(title.equals("Google")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("in-correct tittle");
		}	
		
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource()); // this is the code of the page. You go to browser, right click and you will see page source. This helps testing 
		
		
		driver.quit(); // to close the browser. this is Session ID is null
		//another method you can use:
		driver.close();  //invalid session ID error. Its not null. 
		
		//the difference between two is: 
		//Quit: will not show you your session ID and make your session ID Null
		//Close: will show you your session ID and make it expired 
		
		//what if after you close the browser, you write this:
		
		System.out.println(driver.getTitle()); // this will gove you exception NoSuchSessionException: Sessions ID is null. Using webdriver after calling quit()?
		
		// what happens here is after you write command "quit", the session ID will become null. It will terminate your driver. and then when you write after 
		//quit getTittlw, again we send the request to that particular server with session id, since the session is is now null it will return responce back as null. 
		// this response is from the server not the driver. 
		
		//if you double click on the numbers on the left, you can have line breakpoint, which means the program will stop at that line. will not go further. 
		// and then try to run it on "debug as". then you press F6 that means it will execute where exactly the control is available where green highlight is. 
		//then the next line will turn gree, and if you mouse over on "driver" it will give you session ID. you copy it and then once you do F6 up to "quit" and 
		//then to the last one "getTittle", after it executes, if you mouse over on "driver", it will not have a session ID but will say null. 
		
	}

}
