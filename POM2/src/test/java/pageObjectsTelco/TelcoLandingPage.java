package pageObjectsTelco;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class TelcoLandingPage extends BasePage {

	public void clickAddCustomer() {
		clickElement(By.linkText("Add Customer"));
	}

	public void clickAddTarrifToCustomer() {
		clickElement(By.linkText("Add Tariff Plan to Customer"));
	}

	public void goHome() {
		driver.get(getDataConfigProperties("systemUnderTest2"));
	}

}
