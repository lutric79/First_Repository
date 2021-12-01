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
//		if (ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button cookies-banner-module_dismiss-button_24Z98']"))!= null)
//		clickElement(By.xpath("//button[@class='button cookies-banner-module_dismiss-button_24Z98']"));
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
	
	public void clickMarcoSearchBox() {
		clickElement(By.xpath("//div[@class='entry-label  entry-label-module_entry-label_1fAP5']"));
	}
	
	public String noOfItems() {
		return getElementText(By.xpath("//div[@class='search-count toolbar-module_search-count_P0ViI search-count-module_search-count_1oyVQ']"));
	}
	
	public void selectBrand() {
		   clickElement(By.xpath("//a[@class='product-anchor product-card-module_product-anchor_TUCBV']"));
		   }
	
	public void clickDailyDeals() {
		   clickElement(By.xpath("//img[@alt='Daily Deals Flyout x2.png']"));
		   }
	
	public void cleanup() {
		driver.close();
	}
	
	
//
//	
//	public void selectBrand() {
//		clickElement(By.xpath("//div[@class='product-card-module_add-to-cart-button-wrapper_3HLmD']"));
//	}
//	
//	public void selectBrand1() {
//		clickElement(By.xpath("//div[@class='card-section product-card-module_card-section_1Zz_k']"));
//	}
//	
//	public void selectBrand2() {
//		clickElement(By.xpath("//div[@class='product-thumb-wrapper product-card-module_product-thumb-wrapper_3XM-L']"));
//	}
//	
   
//	
//	public void selectProduct() {
//		clickElement(By.xpath("//a[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT ghost']"));
//	}
//	
//	public void selectCart() {
//		clickElement(By.xpath("//button[@class='button badge-button mini-cart-button dark-green  badge-button-module_badge-button_3TXVp badge-button-module_badge-icon_LvKrF badge-button-module_badge-count_28PIS']"));
//	}
//	
//	public void clickQuantityDropdown() {
//		clickElement(By.xpath("//select[@id='cart-item_undefined']//option[@value='2']"));
//	}
//	
//	public void selectQuantity() {
//		clickElement(By.xpath("//option[@value='2']"));
//	}
//	
//	public void selecAddToCart() {
//		clickElement(By.xpath("//a[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT']"));
//	}
//	
//	public void selectCartOut() {
//		clickElement(By.xpath("//action[@class='badge-button-module_badge-icon_LvKrF']"));
//	}
//	
//	public void selecQuantity() {
//		clickElement(By.xpath("//option [@value='2']"));
//	}
//	


}
