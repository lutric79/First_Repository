package pageObjectsTelco;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class AddTariffToCustomer extends BasePage  {
	
	AddCustomer ac = new AddCustomer();
	
	public String checkHeading1() {
		return getElementText(By.linkText("Guru99 telecom"));
	}

	public String checkHeading2() {
		return getElementText(By.xpath("//h1[text()='Add Tariff Plan to Customer']"));
	}
	
	public void enterCustomerId(String customerId) {
		EnterText(By.xpath("//input[@id='customer_id']"), customerId);
	}
	
	public void enterPendingCustomerId(String PendingcustomerId) {
		EnterText(By.xpath("//input[@id='customer_id']"), PendingcustomerId);
	}
	
	
	public void clickSubmitButton() {
		clickElement(By.name("submit"));
	}
	
	public String checkCustomerStatus() {
		return getElementText(By.xpath("//font[contains(text(),'ACTIVE')]"));
	}
	
	public String checkPendingCustomerStatus() {
		return getElementText(By.xpath("//font[contains(text(),'INACTIVE')]"));
	}
	
	public String get_row_column_value() {
		return getElementText(By.xpath("//tbody/tr[1]/td[4]"));
		

	}
	
	public void checkLabel() {
		clickElement(By.xpath("//tbody/tr[1]/td[1]"));
	}
	
	public void selectTariffPlan() {
		clickElement(By.xpath("//input[@name='submit']"));
	}
	
	public String successMessageDisplay() {
		return getElementText(By.xpath("//h2[contains(text(),'Congratulation Tariff Plan assigned')]"));
	
	}


}
