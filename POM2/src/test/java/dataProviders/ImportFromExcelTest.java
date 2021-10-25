package dataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;

public class ImportFromExcelTest {
	ReadExcel readExcel = new ReadExcel();
	
	@Test(dataProvider="excelData")
	public void dataImportList(String Name, String Loan_Account_No, String Account_Status) {
		System.out.println("This is an excel data import test");
		System.out.println(Name + " " + Loan_Account_No + " " + Account_Status);
		
	}
	
	@DataProvider(name = "excelData")
	public Object[][] getDatafromExcel() throws IOException
	{
		String excelDirectory = readExcel.getDataConfigProperties ("excelDataDir");
		Object[][] arrObj = readExcel.getExcelData(excelDirectory +"ExcelData.xlsx", "Sheet1");
		
		
		
		return arrObj;
	}
}
