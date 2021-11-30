package pageObjectTakeALot;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import frameWorkClasses.ReadExcel;

public class DataImport{
	ReadExcel readExcel = new ReadExcel();

	public void dataImportList(String Brand, String Quantity) {
		System.out.println("This is an excel data import test");
		System.out.println("The brand name is "+Brand + " " + Quantity);
		
	}
	@DataProvider(name = "excelData")
	public Object[][] getDatafromExcel() throws IOException
	{
		String excelDirectory = readExcel.getDataConfigProperties ("excelDataDir");
		Object[][] arrObj = readExcel.getExcelData(excelDirectory +"Brands.xlsx", "Sheet1");
		
		
		
		return arrObj;
	}

}
