package Selenium;

import Excel.Xls_Reader;

public class ExelUtilTest {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("/Selenium/src/main/java/Excel/SampleExcel.xlsx");
		String sheetName = "login";
		
		System.out.println(reader.getCellData(sheetName, "username", 3));
		String data = reader.getCellData(sheetName, 0, 2); 
		System.out.println(data); //since i think i have no excel, it does not work, should print NAVEEN. 
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: "+ rowCount); //3
		
		reader.addColumn(sheetName, "status"); //you have to close excel and then execute the code 
		reader.addSheet("Registration"); 
		
		if(! reader.isSheetExist("Registration")) {  //! will not add the sheet if there is a sheet already like that 
			reader.addSheet("Registration"); 
		}
		
		reader.setCellData(sheetName, "status", 2, "PASS"); //we have to close it and then start the code 
		
		reader.getCellData(sheetName, "username", 3);
		
		System.out.println(reader.getColumnCount(sheetName));
		
		reader.removeColumn("Registration", 0);
		
		System.out.println(reader.getCellData("Registration", "Phonenumber", 2)); //so when we put data into Excel, like numbers, we have to put "'" comma, so the print out is correct. 
		System.out.println(reader.getCellData("Registration", "age", 2));  
		//for any blank values, just add the single appostrophie before that value 
		
		
	}

}
