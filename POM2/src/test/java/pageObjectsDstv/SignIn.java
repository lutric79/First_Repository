package pageObjectsDstv;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class SignIn extends BasePage{
	
	public void enterPassword(String moviePassword) {
		EnterText(By.xpath("//input[@id='Password']"), moviePassword);
	}
	
	public void clickSignInButton() {
		clickElement(By.xpath("//button[@id='btnSubmit']"));
	}
	
	public String checkUserNameError() {
		return getElementText(By.xpath("//span[@id='EmailOrMobileNumber-error']"));
	}

}
