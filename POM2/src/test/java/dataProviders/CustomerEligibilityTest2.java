package dataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomerEligibilityTest2 {
	
	@Test(dataProvider="getData")
	public void customerEligibilityList(String firstname, String lastname, int age,Boolean isHighEarner,Boolean hasCriminalRecord) {
		System.out.println("This is a customer eligibility data import test");
		System.out.println(firstname + " " + lastname + " " + age + " " + isHighEarner + " " + hasCriminalRecord);
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[10][5];
		
		//1st set
		data[0][0]="Luthando";
		data[0][1]="Maqungo";
		data[0][2]=17;
		data[0][3]=false;
		data[0][4]=false;
		
		//2nd set
		data[1][0]="Sam";
		data[1][1]="Smith";
		data[1][2]=47;
		data[1][3]=false;
		data[1][4]=true;
		
		//3rd set
		data[2][0]="Luyanda";
		data[2][1]="Mani";
		data[2][2]=35;
		data[2][3]=true;
		data[2][4]=false;
		
		//4th set
		data[3][0]="Anda";
		data[3][1]="Mayina";
		data[3][2]=27;
		data[3][3]=true;
		data[3][4]=true;
		
		//5th set
		data[4][0]="Khelina";
		data[4][1]="Talent";
		data[4][2]=19;
		data[4][3]=false;
		data[4][4]=false;
		
		//6th set
		data[5][0]="Lilian";
		data[5][1]="Mhlongo";
		data[5][2]=59;
		data[5][3]=false;
		data[5][4]=false;
		
		//7th set
		data[6][0]="Enhle";
		data[6][1]="Fani";
		data[6][2]=32;
		data[6][3]=true;
		data[6][4]=false;
		
		//8th set
		data[7][0]="Dube";
		data[7][1]="Pedi";
		data[7][2]=31;
		data[7][3]=true;
		data[7][4]=false;
		
		//9th set
		data[8][0]="Theo";
		data[8][1]="Mafikizolo";
		data[8][2]=42;
		data[8][3]=true;
		data[8][4]=true;
		
		//10th set
		data[9][0]="Nhlanhla";
		data[9][1]="Gillwood";
		data[9][2]=45;
		data[9][3]=false;
		data[9][4]=true;
		
		
		return data;
	}

}
