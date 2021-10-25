package pageObjectsDstv;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage {
	
	public void hiWorld () {
		System.out.println("This is a landing page");
	}
	
	public void clickSignIn() {
		clickElement(By.xpath("//img[@alt='Sign in']"));
	}

}
