package TestNGSessions;

import org.testng.annotations.Test;

public class DependsOnMethod {
	
	@Test (priority=1)
	public void loginTest () {
		System.out.println("login test ...");
		int i = 9/0; // this will fail, but it wont stop on this, it will keep executing tests 
	}
	
	@Test (priority = 2, dependsOnMethods="loginTest") // with using this feature, it will skip these tests. if login will fail, so do not execute the rest. 
	//you can also create multiple dependencies with this method
	public void homePageTest () {
		System.out.println("home page test ...");
	}
	
	@Test (priority = 3,  dependsOnMethods={"loginTest", "homePageTest"})
	public void SearchTest () {
		System.out.println("search test ...");
	}

	//hack: to see your results on test go to : project (Selenium) - refresh - test_output - index.htm - properties - copy location - open browser - paste in search bar
	// then you go to: the location on the browser, copy it,in the project (Selenium), create a "source folder", name it src/test/runner, then create:
	//folder, and inside the folder create file, must be "xml" at the end wehn you name it. and paste what you copied from browser. 
	//By creating this, it will create a test suite and it will execute all test classes together. You can right click on the xml file and run "TestNG Suite"
	// when creating sanity file, you execute only important tests 
	//"verbose" - kind of info we will get in console. Meaning a lot or little, It can go from 1-10, so 2 will be very limited info given to us on console when we 
	//execute the test 
}
