import com.google.threadclasses.GoogleFeatureThread;

public class GoogleTestRunner {

	public static void main(String[] args) {

//		//how to create a thread
//		
//		Thread t1 = new GoogleFeatureThread("chrome thread", "chrome"); // this is top casting
//		Thread t2 = new GoogleFeatureThread("firefox thread", "firefox");
//		
//		System.out.println("thread started ...");
//		//to start thread:
//		t1.start();
//		t2.start();
		
		//what if we want to use 4 chromes and 3 firefoxes? so we will slash the top methods and use th bottom for multiples 
		
		for(int k=0; k<5; k++) {
			new GoogleFeatureThread("chrome thread", "chrome").start();
			new GoogleFeatureThread("firefox thread", "firefox").start();
		}
		
		// what if we want felxebility 1 chrome, 2 firefox..?
		// "||" that is or or
		int chromeCount = Integer.parseInt(System.getProperty("chrome"));
		int firefoxCount = Integer.parseInt(System.getProperty("firefox"));

		for(int i=0; p=0; i<chromeCount || p<firefoxCount; i++, p++) {
			System.out.println("thread started ...");
			
			new GoogleFeatureThread("chrome thread", "chrome").start();
			new GoogleFeatureThread("firefox thread", "firefox").start();
			
			System.out.println("thread ended ...");
			
		}
		
	}

}
