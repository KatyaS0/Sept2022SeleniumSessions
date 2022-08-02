package com.google.threadclasses;

import com.pages.GooglePage;

public class GoogleFeatureThread extends Thread { //need to use if we want to do multithreading 

	//contructor of this class:
	
	public String browserName;
	GooglePage googlePage; 
	
	public GoogleFeatureThread(String threadName, String browserName) {
		super(threadName); 
		this.browserName = browserName; 
		googlePage = new GooglePage();
		
	}
	
	@Override 
	public void run() {
		
		System.out.println("thread -- started" + Thread.currentThread().getName());
		
		try {
			Thread.sleep(1000); 
			googlePage.setUp(this.browserName);  //set up will launch the browser and returen the driver
			googlePage.googleSearchTest();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	finally {
		googlePage.tearDown(); //no ,atter if the excpetions coming, the finally will be executed 
	}
		
	System.out.println("thread - ended" + Thread.currentThread().getName());
	
}
