package loans;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HomeLoan2 {
	
	@Test
	public void TypeOfLoan() 
	{
		System.out.println("This is a home loan 2");

}
	
	@Test(groups= {"Smoke"})
	public void GroupExercise() 
	{
		System.out.println("This is to test group exclusion");

}
	
	@Test
	public void LoanDeclined() 
	{
		System.out.println("Sorry, your loan has been declined");
		
		

}
	
	@Test
	public void Fraud() 
	{
		System.out.println("Set global variables");
		
		

}
	
	@BeforeSuite
	public void GlobalViriables() 
	{
		System.out.println("Global viriable setup");
		
		

}

}
