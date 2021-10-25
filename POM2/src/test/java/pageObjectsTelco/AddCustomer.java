package pageObjectsTelco;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class AddCustomer extends BasePage {

	public String checkHeading1() {
		return getElementText(By.linkText("Guru99 telecom"));
	}

	public String checkHeading2() {
		return getElementText(By.xpath("//h1[text()='Add Customer']"));
	}

	public void clickRadioButton() {
		clickElement(By.xpath("//label[contains(text(),'Done')]"));
	}
	
	public void clickPendingRadioButton() {
		clickElement(By.xpath("//label[contains(text(),'Pending')]"));
	}

	public void enterFirstName(String firstName) {
		EnterText(By.xpath("//input[@id='fname']"), firstName);
	}

	public void enterlastName(String lastName) {
		EnterText(By.xpath("//input[@id='lname']"), lastName);
	}

	public void enterEmail(String email) {
		EnterText(By.xpath("//input[@id='email']"), email);
	}

	public void enterAddress(String address) {
		EnterText(By.xpath("//textarea[@id='message']"), address);
	}
	
	public String checkSpecialCharacters() {
		return getElementText(By.id("message3"));
	}

	public void enterMobile(String mobile) {
		EnterText(By.xpath("//input[@id='telephoneno']"), mobile);
	}

	public void clickSubmitButton() {
		clickElement(By.name("submit"));
	}
	
	public String checkCustomerId() {
		return getElementText(By.xpath("//h3"));
		 
	}
	
	
	public String checkPendingCustomerId() {
		return getElementText(By.xpath("//h3"));
	}
	
	

//	Alert alert = driver.switchTo().alert();
	public String checkAlertMessage() {
		return driver.switchTo().alert().getText();
	}

	public void clickOkOnAlert() {
		driver.switchTo().alert().accept();
	}
}
