package dataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserNameAndPasswordTest {
	
	@Test(dataProvider="getData")
	public void userNameAndPasswordList(String username, String password) {
		System.out.println("This is a username and password data import test");
		System.out.println(username + " " + password);
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		
		//1st set
		data[0][0]="firstusername";
		data[0][1]="firstpassword";
		
		//2nd set
		data[1][0]="secondusername";
		data[1][1]="secondpassword";
		
		//3rd set
		data[2][0]="thirdusername";
		data[2][1]="thirdpassword";
		
		return data;
	}
	

}
