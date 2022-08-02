package MyTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsConcept {

	
	//lets write pre-conditions 
	/**
	 * BS -- DBConnection
		BT -- createUser
		BC -- launchBrowser/url
		
			BM -- loginToApp
			accountInfoTest // this is picked on alphabetical order thats why this is first 
			AM -- logout

			BM -- loginToApp
			profileTest
			AM -- logout
			
			BM -- loginToApp
			userInfoTest
			AM -- logout

		AC -- closeBrowser
		AT -- deleteUser
		AS -- disconnectDB 
	 */
	// these annotations are optional @beforeTest etc . only use if long pre-conditions. But this is a sequence 
	
	@BeforeSuite//1
	public void DBConnection() {
		System.out.println("BS -- DBConnection");
	}
	
	@BeforeTest//2
	public void createUser() {
		System.out.println("BT -- createUser");	
	}
	
	@BeforeClass//3
	public void launchBrowser() {
		System.out.println("BC -- launchBrowser//url");	
	}
	
	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM -- loginToApp");	
	}
	
	@Test // test 1
	public void userInfoTest () { //"test" has to be added in the end for this method (userInfoTest)
		System.out.println("userInfoTest");
	}
	
	@Test //test 2 - only two tests. 
	public void accountInfoTest () { //"test" has to be added in the end for this method
		System.out.println("accountInfoTest");
	}
	
	@Test // test 3
	public void profileTest () { //"test" has to be added in the end for this method (userInfoTest)
		System.out.println("profileTest");
	
	@AfterMethod
	public void logout() {
		System.out.println ("AM -- logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println ("AC -- closeBrowser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println ("AT -- deleteUser");
	}
	
	@AfterSuite
	public void disconnectDB () {
		System.out.println ("AS -- disconnectDB ");
		
	}
}
