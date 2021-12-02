package pageObjectTakeALot;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.poifs.property.Parent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import frameWorkClasses.BasePage;

public class Cart extends BasePage {

	
//	public void GoToCart() throws InterruptedException {Set<String> allHandles = driver.getWindowHandles(); // Get All the window handles
//	System.out.println("Count of windows:"+allHandles.size()); // Count the number of handles
//
//	String currentWindowHandle = allHandles.iterator().next(); // Get the current handle or default handle
//	System.out.println("currentWindow Handle"+currentWindowHandle);
//
//	allHandles.remove(allHandles.iterator().next()); // Remove the first/default handle
//	String lastHandle = allHandles.iterator().next(); // Get the last window handle
//	System.out.println("last window handle"+lastHandle); //
//	
//	driver.switchTo().window(lastHandle); // Switch to second or last window, two windows (1 parent window) other window (2 child window)
//		clickElement(By.xpath("//button[@class='button checkout-now dark']"));
//	}
	
	public String ItemPrice() {
		return getElementText(By.xpath("//span[@class='currency plus currency-module_currency_29IIm']"));
	}
	
	public String PriceOfCartItems() {
		return getElementText(By.xpath("//*[contains(text(),'Cart Summary')]/..//span[contains(@class,'currency plus currency-module_currency_29IIm')]"));
	}
	public void SelectQuantity() {
		clickElement(By.xpath("//select[@id='cart-item_undefined']//option[@value='2']"));
	}
	
	
//	public String cartValue() {
//		return getElementText(By.xpath("//span[@class='currency plus currency-module_currency_29IIm']"));
//	}
	
	public void GoToCart() throws InterruptedException {
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> it = handles.iterator();
		String parentWindowID = it.next();
		String childWindoID = it.next();
		driver.switchTo().window(childWindoID);
		clickElement(By.xpath("//button[@class='button checkout-now dark']"));
		
	}
	
	public void brandQuauntity(String bQuantity) {
		clickElement(By.xpath("//select[@id='cart-item_undefined']"));
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='cart-item_undefined']")));
		sel.selectByValue(bQuantity);
	}
	
	
	

}
