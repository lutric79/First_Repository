package pageObjectTakeALot;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class ItemSelection extends BasePage{
	
	
	public void selecAddToCart1() throws InterruptedException {
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> it = handles.iterator();
		String parentWindowID = it.next();
		String childWindoID = it.next();
		driver.switchTo().window(childWindoID);
		clickElement(By.xpath("/html//div[@id='shopfront-app']/div[@class='pdp pdp-module_pdp_1CPrg']/div[@class='grid-container pdp-grid-container']/div[2]//a[@href='/']"));
		
	}
	
	public String getAddedToCartText() {
		return getElementText(By.cssSelector("span > span > .shiitake-children"));
	}
	
	public void selecAddToCart() throws InterruptedException {Set<String> MyHandles = driver.getWindowHandles(); // Get All the window handles
	System.out.println("Count of windows:"+MyHandles.size()); // Count the number of handles

	String currentWindowHandle = MyHandles.iterator().next(); // Get the current handle or default handle
	System.out.println("currentWindow Handle"+currentWindowHandle);

	MyHandles.remove(MyHandles.iterator().next()); // Remove the first/default handle
	String lastHandle = MyHandles.iterator().next(); // Get the last window handle
	System.out.println("last window handle"+lastHandle); //
	
	driver.switchTo().window(lastHandle); // Switch to second or last window, two windows (1 parent window) other window (2 child window)
		clickElement(By.cssSelector(".buybox-actions-module_add-to-cart-cell_3fXyS .add-to-cart-button-module_add-to-cart-button_1a9gT"));

}
	
	
	
	
	

}
