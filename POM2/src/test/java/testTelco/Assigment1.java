package testTelco;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pageObjectDemo.TableScraping;
import pageObjectsTelco.AddCustomer;
import pageObjectsTelco.TelcoLandingPage;


public class Assigment1 {
	TelcoLandingPage tlp = new TelcoLandingPage();
	AddCustomer ac = new AddCustomer();
	TableScraping ts = new TableScraping();
	
	
	@Test
	public void GIVEN_NavigationToAddCustomerPage_WHEN_AddCustomerPageIsDisplayed__THEN_Heading1_Displayed() {
		// GIVEN
		tlp.goHome();
		tlp.clickAddCustomer();
		ac.checkHeading1();


		// WHEN
		String actualAlertMessage = ac.checkHeading1();
		String expectedAlertMessage = "Guru99 telecom";

		// THEN
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
		
		
	}
	
	@Test
	public void GIVEN_NavigationToAddCustomerPage_WHEN_AddCustomerPageIsDisplayed__THEN_Heading2_Displayed() {
		// GIVEN
		tlp.goHome();
		tlp.clickAddCustomer();
		ac.checkHeading2();


		// WHEN
		String actualAlertMessage = ac.checkHeading2();
		String expectedAlertMessage = "Add Customer";

		// THEN
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
			
	}
	
	@Test
	public void GIVEN_NavigationToAddCustomerPage_WHEN_SpecialCharactersInAddressEntered_THEN_WarningIs_Displayed() {
		// GIVEN
		tlp.goHome();
		tlp.clickAddCustomer();
		ac.clickRadioButton();
		ac.enterFirstName("Luthando");
		ac.enterlastName("Maqungo");
		ac.enterEmail("tester@automation.co.za");
		ac.enterAddress("123 Testing Street,Testerville");
		ac.enterMobile("0852210521");

		// WHEN
		String actualAlertMessage = ac.checkSpecialCharacters();
		String expectedAlertMessage = "Special characters are not allowed";

		// THEN
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
		
		
	}
	

	@Test
	public void GIVEN_NavigationToAddCustomerPage_WHEN_InvalidDataEntered_AND_SubmitButtonClicked_THEN_WarningIs_Displayed() {
		// GIVEN
		tlp.goHome();
		tlp.clickAddCustomer();
		ac.clickRadioButton();
		ac.enterFirstName("Luthando");
		ac.enterlastName("Maqungo");
		ac.enterEmail("tester@automation.co.za");
		ac.enterAddress("123 Testing Street,Testerville");
		ac.enterMobile("0852210521");

		// WHEN

		ac.clickSubmitButton();

		String actualAlertMessage = ac.checkAlertMessage();
		String expectedAlertMessage = "please fill all fields";

		// THEN
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
		ac.clickOkOnAlert();
		
	}
	
	@Test
	public void GIVEN_NavigationToAddCustomerPage_WHEN_ValidDataEntered_AND_SubmitButtonClicked_THEN_ID_IsDisplayed() {
		// GIVEN
		tlp.goHome();
		tlp.clickAddCustomer();
		ac.checkHeading1();
		ac.checkHeading1();
		ac.clickRadioButton();
		ac.enterFirstName("Luthando");
		ac.enterlastName("Maqungo");
		ac.enterEmail("tester@automation.co.za");
		ac.enterAddress("123 Testing Street Testerville");
		ac.enterMobile("0852210521");

		// WHEN

		ac.clickSubmitButton();
		
		String customerId = ac.checkCustomerId();

		String actualCustomerId = ac.checkCustomerId();
		String expectedCustomerId = customerId;
		System.out.println("The customer Id is "+actualCustomerId);

		// THEN
		Assert.assertEquals(actualCustomerId, expectedCustomerId);
		
		
	}
	@Test
	public void TableDemoTest() {
		ts.gotToTablesDemo();
		ts.tablesDemo();
	}
	
	@AfterSuite
	public void cleanup() {
		ac.cleanup();

	}

}
