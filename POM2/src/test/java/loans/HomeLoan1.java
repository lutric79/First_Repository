package loans;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeLoan1 {
	
	@Test
	public void LoanType() 
	{
		System.out.println("This is a home loan");
		//Assert.assertTrue(false);
		String expected = "Passed test";
		String actual = "Failed test";
		
		Reporter.log("actual is " +actual);
		Reporter.log("expected is " +expected);
		Assert.assertTrue(false);
				

}
	
	@Test
	public void LoanType2() 
	{
		System.out.println("This is a home loan for Big dogs of the game");

}
	@Test
	public void LoanFraud() 
	{
		System.out.println("There's an ID theft suspected");
		
		String expected = "Passed";
		String actual = "Not Really";
		
		Reporter.log("actual is " +actual);
		Reporter.log("expected is " +expected);

}
	
	@Test
	public void LoanApproved() 
	{
		System.out.println("Congratulations, your loan has been approved");

}
	
	@BeforeTest
	public void Restore() 
	{
		System.out.println("Restore DB before testing begins");

}
	
	@BeforeTest
	@AfterTest
	public void Restore1() 
	{
		System.out.println("DB has been restored");

}
	
}
