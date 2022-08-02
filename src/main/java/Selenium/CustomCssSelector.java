package Selenium;

public class CustomCssSelector {

	public static void main(String[] args) {

		//will not give many options as xpath can give 
		
		//id is availbe: use #[id]
		//you can use multiple id too

		// #username - this is a CSS selector - # is the id in this case
		// input #username 
		// input[id+'username']
		// input[id+'username'][type='email']
		// button#loginBtn
		
		//what if the class is availabe? dot represents class "." also for removign space between words in class, use dot as well to remove the space
		//class: .[classname]
		//.form-control.private-form_control.login-email
		//input.form-control.private-form_control.login-email
		//input.login-email 
		
		//you can use multiple classes too
		//button.login-submit
		
		//use cases with text
		//input[id^='username'] - starting the text
		//input[id$='username'] - ending text
		//inout[id$='name']
		
		//contains : '*'
		//input[id*='username'] - id contains user taht how you translate it. 
		
		//parent - child: '>' go to the child that is what the symbol means 
		//div>input[id='username'] - parent- child concept 
		//div.private-form__inout-wrapper>input#username  - this is for class and id
		
		//css selector is slightly faster then xpath 
		//but is basic then better use css selector 
		


		
		

		
		
		
		
		
		
	}

}
