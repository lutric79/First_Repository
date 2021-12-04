package pageObjectTakeALot;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkClasses.BasePage;

public class TakeALotLandingPage extends BasePage {
	
	public void goHome() {
		driver.get(getDataConfigProperties("systemUnderTest"));
		//clickElement(By.xpath("//img[@class='top-nav-module_logo_R1oac']"));
	}
	
	public void acceptCookies() { 

		//try {
			if( driver.findElement(By.xpath("//button[@class='button cookies-banner-module_dismiss-button_24Z98']")).isDisplayed())
		{
			//System.out.println("First");
			clickElement(By.xpath("//button[@class='button cookies-banner-module_dismiss-button_24Z98']"));
		}
		//}catch (Exception e)
		
//		{System.out.println("Second");
//	}
	}
	
	public void enterSearchItem(String serchItem) {
		EnterText(By.xpath("//input[@name='search']"), serchItem);
		
	}
		
		public void clearSearch(){
			driver.findElement(By.xpath("//input[@name='search']")).clear();
		}
		
		

	public void clickSearchButton() {
		clickElement(By.xpath("//button[@type='submit']"));
	}
	
	public void BrandSelection() {
		clickElement(By.xpath("//div[@class='entry-label  entry-label-module_entry-label_1fAP5']"));
	}
	
	public String noOfItems() {
		return getElementText(By.xpath("//div[@class='search-count toolbar-module_search-count_P0ViI search-count-module_search-count_1oyVQ']"));
	}
	
	public String noOfDeals() {
		return getElementText(By.xpath("//div[@class='search-count toolbar-module_search-count_P0ViI search-count-module_search-count_1oyVQ']"));
	}
	
	public void FirstItemSelection() {
		   clickElement(By.xpath("//a[@class='product-anchor product-card-module_product-anchor_TUCBV']"));
		   }
	
	public void clickDailyDeals() {
		   clickElement(By.xpath("//img[@alt='Daily Deals Flyout x2.png']"));
		   }
	
	public void cleanup() {
		driver.close();
	}
	
	



}
