package testTelco;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pageObjectsTelco.AddCustomer;
import pageObjectsTelco.AddTariffToCustomer;
import pageObjectsTelco.TelcoLandingPage;

public class Assignment2 {
	TelcoLandingPage tlp = new TelcoLandingPage();
	AddTariffToCustomer at = new AddTariffToCustomer();
	AddCustomer ac = new AddCustomer();
	
	
	@Test
	public void GIVEN_NavigationToAddCustomerPage_WHEN_AddCustomerPageIsDisplayed__THEN_Heading1_Displayed() {
		// GIVEN
		tlp.goHome();
		tlp.clickAddTarrifToCustomer();
		at.checkHeading1();
		
		//WHEN
		String actualHeading1 = at.checkHeading1();
		String expectedHeading1 = "Guru99 telecom";
		
		
		//THEN
		Assert.assertEquals(actualHeading1, expectedHeading1);
		
		}
	
	@Test
	public void GIVEN_NavigationToAddCustomerPage_WHEN_AddCustomerPageIsDisplayed__THEN_Heading2_Displayed() {
		// GIVEN
		tlp.goHome();
		tlp.clickAddTarrifToCustomer();
		at.checkHeading2();
		
		// WHEN
		String actualHeading2 = at.checkHeading2();
		String expectedHeading2 = "Add Tariff Plan to Customer";

		// THEN
		Assert.assertEquals(actualHeading2, expectedHeading2);
			
	}
	
	@Test
	public void GIVEN_AciveCustomer_WHEN_Submit__THEN_Active_IsDisplayed()  {
		// GIVEN
		tlp.goHome();
		tlp.clickAddCustomer();
		ac.clickRadioButton();
		ac.enterFirstName("Luthando");
		ac.enterlastName("Maqungo");
		ac.enterEmail("tester@automation.co.za");
		ac.enterAddress("123 Testing Street Testerville");
		ac.enterMobile("0852210521");
		
		
	
		//WHEN
		
		ac.clickSubmitButton();
		
		String DonecustomerId = ac.checkCustomerId();
		System.out.println("The customer Id is "+DonecustomerId);
		
		tlp.goHome();
		tlp.clickAddTarrifToCustomer();
		at.enterCustomerId(DonecustomerId);
		at.clickSubmitButton();
		
		
		
		String actualCustomerStatus = at.checkCustomerStatus();
		String expectedCustomerStatus = "ACTIVE";
		
		//THEN
		Assert.assertEquals(actualCustomerStatus, expectedCustomerStatus);
	
}
	@Test
	public void GIVEN_InactiveCustomer_WHEN_Submit_THEN_INactive_IsDisplayed() {
		// GIVEN
		tlp.goHome();
		tlp.clickAddCustomer();
		ac.clickPendingRadioButton();
		ac.enterFirstName("Luthando");
		ac.enterlastName("Maqungo");
		ac.enterEmail("tester@automation.co.za");
		ac.enterAddress("123 Testing Street Testerville");
		ac.enterMobile("0852210521");

		// WHEN

		ac.clickSubmitButton();
		
		String PendingcustomerId = ac.checkPendingCustomerId();

//		String actualPendingCustomerId = ac.checkPendingCustomerId();
//		String expectedPendingCustomerId = PendingcustomerId;
		System.out.println("The customer Id is "+PendingcustomerId);
		
		tlp.goHome();
		tlp.clickAddTarrifToCustomer();
		at.enterPendingCustomerId(PendingcustomerId);
		at.clickSubmitButton();
		
		String actualPendingCustomerStatus = at.checkPendingCustomerStatus();
		String expectedPendingCustomerStatus = "INACTIVE";

		// THEN
		Assert.assertEquals(actualPendingCustomerStatus, expectedPendingCustomerStatus);
	
}
	@Test
	public void GIVEN_AciveCustomer_WHEN_Submit__THEN_AtleastOneApprovedTarrif_IsDisplayed()  {
		// GIVEN
		tlp.goHome();
		tlp.clickAddCustomer();
		ac.clickRadioButton();
		ac.enterFirstName("Luthando");
		ac.enterlastName("Maqungo");
		ac.enterEmail("tester@automation.co.za");
		ac.enterAddress("123 Testing Street Testerville");
		ac.enterMobile("0852210521");
		
		
	
		//WHEN
		
		ac.clickSubmitButton();
		
		String DonecustomerId = ac.checkCustomerId();
		System.out.println("The customer Id is "+DonecustomerId);
		
		tlp.goHome();
		tlp.clickAddTarrifToCustomer();
		at.enterCustomerId(DonecustomerId);
		at.clickSubmitButton();
		
		
		
		String actualCustomerStatus = at.get_row_column_value();
		String expectedCustomerStatus = "100";
		
		//THEN
		Assert.assertEquals(actualCustomerStatus, expectedCustomerStatus);
	
}
	
	@Test
	public void GIVEN_AtleastOneApprovedTarrifIsSelected_WHEN_AddTarrif__THEN_SuccessMessage_IsDisplayed() throws InterruptedException  {
		// GIVEN
		tlp.goHome();
		tlp.clickAddCustomer();
		ac.clickRadioButton();
		ac.enterFirstName("Luthando");
		ac.enterlastName("Maqungo");
		ac.enterEmail("tester@automation.co.za");
		ac.enterAddress("123 Testing Street Testerville");
		ac.enterMobile("0852210521");
		
		
	
		//WHEN
		
		ac.clickSubmitButton();
		
		String DonecustomerId = ac.checkCustomerId();
		System.out.println("The customer Id is "+DonecustomerId);
		
		tlp.goHome();
		tlp.clickAddTarrifToCustomer();
		at.enterCustomerId(DonecustomerId);
		at.clickSubmitButton();
		at.checkLabel();
		at.selectTariffPlan();
		Thread.sleep(1000);
		
		
		String actualCustomerStatus = at.successMessageDisplay();
		String expectedCustomerStatus = "Congratulation Tariff Plan assigned";
		
		//THEN
		Assert.assertEquals(actualCustomerStatus, expectedCustomerStatus);
	
}
	
	@AfterSuite
	public void cleanup() {
		ac.cleanup();

	}
	
}
