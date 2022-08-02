package TestNGSessions;

import org.testng.annotations.Test;

public class PriorityTest {
	// sequence will be 1 2 3 no matter how you put it . but if you use "priority" it will be by priority 
	//non-priority will be done first. Then will take priority 
	//if tests have same priority, it will go by alphabetical order. 
	// you can have a negative priority (priority=-1), it will come first because -1 comes before 1. 
	//you can also have priority=0, 
	//but better not use -1, -2 etc
	
	
	@Test(priority=3)
	public void test1() {
		System.out.println("test 1");
	}
	
	@Test(priority=2)
	public void test2() {
		System.out.println("test 2");
	}
	
	@Test(priority=1)
	public void test3() {
		System.out.println("test 3");
	}
	
	@Test()
	public void test4() {
		System.out.println("test 4");
	}
	@Test()
	public void test5() {
		System.out.println("test 5");
	}
	@Test(priority=1)
	public void test6() {
		System.out.println("test 6");
	}
	
	
	
	

}
