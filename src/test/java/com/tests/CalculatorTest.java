package com.tests;

import pages.CalculatorPage;

public class CalculatorTest {
	
	CalculatorPage calPage;
	
	
	@BeforeTest
	public void setup() {
		calPage = new CalculatorPage();
				
	}
	
	@Test(priority=1)
	
	public void sumTest () {
		String res = calPage.doSum("10", "20");
		Assert.assertEquals(res, "30");
		
		
	}

}
