package testDstv;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pageObjectsDstv.LandingPage;
import pageObjectsDstv.SignIn;

public class MovieMagicTests {
	// instantiate the page objects
	LandingPage lp = new LandingPage();
	SignIn sn = new SignIn();

	@Test
	public void GIVEN_NavigationToSignInPagePage_WHEN_OnlyPasswordEntered_AND_SignInButtonClicked_THEN_Error() {
		//GIVEN
		//goHome
		lp.clickSignIn();
		sn.enterPassword("whatever");
		
		//WHEN
		sn.clickSignInButton();
		
		String actual = sn.checkUserNameError();
		String expected = "Email or Mobile number is required";
		
		//THEN
		Assert.assertEquals(actual, expected);
		
		
		
	}
	@AfterSuite
	public void cleanup() {
		lp.cleanup();
	
	}

}
