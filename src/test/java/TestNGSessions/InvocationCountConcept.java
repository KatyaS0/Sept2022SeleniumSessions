package TestNGSessions;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	@Test (invocationCount = 10) // it will execute the test 10 times. you can crreate 10 acounts if that is what you are testing 
	public void CreateUser () {
		System.out.println("create user test...");
		//hit ur API
	}

}
