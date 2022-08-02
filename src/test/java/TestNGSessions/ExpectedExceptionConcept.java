package TestNGSessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	@Test (expectedExceptions = ArithmeticException.class)// this is the expectation, so we tell the test run it anyway. but it will not execute line 11. 
	//And it must be the exact exception name or superclass which is "exception", or "Throwable" if you do not know what exception
	//is coming because it is a superclass of exception class. if you ge multiple excetion you do this: 
	//@Test (expectedExceptions = {ArithmeticException.class, NullPointerException.class}) this is just 2 random exceptions
	public void loginTest() {
		System.out.println("login test...."); // this will be excetuted 
		int i = 9/0; //ArithmeticException 
		System.out.println("login test....ending"); // this will not  
	}
	
	
	
	
	

}
