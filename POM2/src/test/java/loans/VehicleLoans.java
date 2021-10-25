package loans;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class VehicleLoans {
	
	@Test
	public void ApprovedWithBalloonLoan() 
	{
		System.out.println("The loan has been approved with balloon payment");

}
	@AfterSuite
	public void GlobalViriablesReset() 
	{
		System.out.println("Reset global viriables");
		
		

}

}
