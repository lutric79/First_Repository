package testTakeALot;

import java.text.NumberFormat;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import frameWorkClasses.BasePage;
import frameWorkClasses.ReadExcel;
import pageObjectTakeALot.Cart;
import pageObjectTakeALot.DataImport;
import pageObjectTakeALot.ItemSelection;
import pageObjectTakeALot.TakeALotLandingPage;


public class ItemSearch extends BasePage{
	TakeALotLandingPage tLandingPage = new TakeALotLandingPage();
	ItemSelection Iselection = new ItemSelection();
	Cart Mycart = new Cart();
	ReadExcel readExcel = new ReadExcel();
	DataImport excelData = new DataImport();
	
	double totalCartValue = 0;
	public double totalCalculatedCartValue = 0;
	double TruePriceOfItem = 0;
	NumberFormat currency = NumberFormat.getCurrencyInstance();

	@BeforeTest
	public void Restore() 
	{
		tLandingPage.acceptCookies();
	}

	@Test
	public void GIVEN_ItemIsSelected_WHEN_AddToCartIsClicked_THEN_AddToCartButtonIsDisplayed() throws InterruptedException  {

		tLandingPage.goHome();
		tLandingPage.enterSearchItem("Office & Stationery");
		tLandingPage.clickSearchButton();
		tLandingPage.BrandSelection();
		tLandingPage.FirstItemSelection();
		Iselection.selecAddToCart1();
		System.out.println(Iselection.getAddedToCartText());


		String ActualAddToCartText = Iselection.getAddedToCartText();
		String ExpectedAddToCartText = "Added to cart";

		Assert.assertEquals(ActualAddToCartText, ExpectedAddToCartText);

	}

	@Test
	public void GIVEN_YouAreDailyDeals_WHEN_ItemIsSelected_THEN_SkipTheTestCase() throws InterruptedException  {

		tLandingPage.goHome();
		tLandingPage.clickDailyDeals();
		tLandingPage.noOfDeals();

		String NumberOfDeals = tLandingPage.noOfDeals();
		System.out.println(NumberOfDeals);
		String formattedNoOfDeals = NumberOfDeals.replaceAll("\\D+", "");
		System.out.println(formattedNoOfDeals);

		int finalDealsNumber = Integer.parseInt(formattedNoOfDeals);

		if(finalDealsNumber > 0) {
			System.out.println("At least 1 item is available on the selected brand");
			Assert.assertTrue(true);
		}else System.out.println("No items available on the selected brand");
		throw new SkipException("This is a skipped test case");
	}

	@Test
	public void GIVEN_NavigationToHomePage_WHEN_DoingItemSearch_AND_SelectABrand_THEN_MoreThanZeroItemsDisplayed() {
		tLandingPage.goHome();
		//tLandingPage.acceptCookies();
		tLandingPage.enterSearchItem("Office & Stationery");
		tLandingPage.clickSearchButton();
		tLandingPage.BrandSelection();

		String NumberOfItemsResults = tLandingPage.noOfItems();
		System.out.println(NumberOfItemsResults);
		String NumberOfItems = NumberOfItemsResults.replaceAll("\\D+", "");
		System.out.println(NumberOfItems);

		int finalNumber = Integer.parseInt(NumberOfItems);

		if(finalNumber > 0) {
			System.out.println("At least 1 item is available on the selected brand");
			Assert.assertTrue(true);
		}else System.out.println("No items available on the selected brand");


	}


	@Test
	public void GIVEN_YouNavigateToCart_WHEN_QuantityIsSelected_THEN_CartValueIsDisplayedCorrectly() throws InterruptedException {
		tLandingPage.goHome();
		tLandingPage.enterSearchItem("Office & Stationery");
		tLandingPage.clickSearchButton();
		tLandingPage.BrandSelection();
		tLandingPage.FirstItemSelection();
		String PriceOfItem = Mycart.ItemPrice();
		System.out.println("The price of item is " +PriceOfItem);
		String cutTheRPriceOfItem = PriceOfItem.replaceAll("\\D+", "");
		System.out.println("The price of an item without the Char is "+cutTheRPriceOfItem);
		int TruePriceOfItem = Integer.parseInt(cutTheRPriceOfItem);
		System.out.println("The price of formatted item price  is "+ currency.format(TruePriceOfItem));
		tLandingPage.cleanup();

		
		
		Iselection.selecAddToCart();
		Mycart.GoToCart();

		Mycart.SelectQuantity();
		Thread.sleep(5000);

		String CartValue = Mycart.PriceOfCartItems2();
		System.out.println("The price of item multiplied by quantity is " +CartValue);
		String CartPrice = CartValue.replaceAll("\\D+", "");
		System.out.println("The price of the cart value without the Char is "+CartPrice);
		int TrueCartPrice = Integer.parseInt(CartPrice);
		System.out.println("The formatted price of cart value is "+ currency.format(TrueCartPrice));

		
		




		WebElement quantityList = getElement(By.id("cart-item_undefined"));
		Select sel = new Select(quantityList);
		sel.selectByIndex(1);

		List<WebElement> SelectedQuantity = sel.getOptions();
		String QuantityValue = SelectedQuantity.get(1).getText();

		System.out.println("The quantity value is " +QuantityValue);
		int TrueQuantityValue = Integer.parseInt(QuantityValue);

		int totalPrice = TruePriceOfItem*TrueQuantityValue;

		//System.out.println("The price of cart items is " +CartValue);

		System.out.println("The total price is "+ currency.format(totalPrice));


		//System.out.println("The formatted price is "+ "R"+CartPrice);




		//System.out.println("The formatted CartPrice is "+ "R"+TrueCartPrice);

		if(totalPrice==TrueCartPrice) {
			System.out.println("Cart Value is displayed correctly");
			Assert.assertTrue(true);
		}else System.out.println("Cart Value is displayed incorrectly");


	}

	@Test(dataProvider="excelBrandData")
//	public void dataImportList(String Brand,String Quantity) throws InterruptedException {
//		tLandingPage.goHome();
//		System.out.println("The brand name is "+ Brand + " and the quantity is " + Quantity );
//		tLandingPage.enterSearchItem(Brand);
//		tLandingPage.clickSearchButton();
//		tLandingPage.clearSearch();
//		tLandingPage.FirstItemSelection();
//		String PriceOfItem = Mycart.ItemPrice();
//		String formattedPriceOfItem = PriceOfItem.substring(2);
//		try {
//		double TruePriceOfItem = Double.parseDouble(formattedPriceOfItem);
//		}catch(NumberFormatException ex) {
//			//handling number formatting exception
//		}
//		System.out.println("The true price is " + TruePriceOfItem);
//		//tLandingPage.cleanup();
//		System.out.println(Brand+ " is a selected brand");
//		Iselection.selecAddToCart();
//		Mycart.GoToCart();
//		Mycart.brandQuauntity(Quantity);
//		Thread.sleep(5000);
//
//		String CartValue = Mycart.PriceOfCartItems2();
//		System.out.println("The price of excel item is " +CartValue);
//
//		String formattedPriceExcelOfItem = CartValue.substring(2);
//		System.out.println("The price of formatted item price  is "+ "R"+formattedPriceExcelOfItem);
//		
//		try {
//		double TruePriceOfExcelItem = Double.parseDouble(formattedPriceExcelOfItem);
//		}catch(NumberFormatException ex) {
//			//handling number formatting exception
//		}
//		int TrueExcelQuantity = Integer.parseInt(Quantity);
//		
//		totalCartValue =  Mycart.GetTotalPrice(TruePriceOfItem, TrueExcelQuantity);
//
//		System.out.println("The price of total Cart Value is "+ "R"+totalCartValue);
//		
//		totalCalculatedCartValue=totalCalculatedCartValue+totalCartValue;
//		System.out.println("Total calculated cart summary : "+ totalCartValue);
//		String total =  "R " + String.format("%,d", totalCartValue);
//		//to validate if the actual cart value is equal to the calculated
//		Assert.assertEquals(CartValue.trim(), total);
//		
//		//	   System.out.println("The price of formatted quantity  is "+ TrueExcelQuantity);
////				int totalExcelPrice = TruePriceOfExcelItem*TrueExcelQuantity;
////				System.out.println("The total excel price is "+ totalExcelPrice);
//		
//		//Mycart.closeCurrentBrowserTab();
//
//	}
//	
//
//
//
//	@DataProvider(name = "excelBrandData")
//	public Object[][] getDatafromExcel()
//	{
//		String excelDirectory = readExcel.getDataConfigProperties ("excelDataDir");
//		Object[][] arrObj = readExcel.getExcelData(excelDirectory +"Brands.xlsx", "Sheet1");
//		return arrObj;

//	}
//
//	//@AfterSuite
//	public void cleanup() {
//		tLandingPage.cleanup();
//
//	}
//
//}
	public void dataImportList(String Brand,String Quantity) throws InterruptedException {
		tLandingPage.goHome();
		System.out.println("The brand name is "+ Brand + " and the quantity is " + Quantity );
		tLandingPage.enterSearchItem(Brand);
		tLandingPage.clickSearchButton();
		tLandingPage.clearSearch();
		tLandingPage.FirstItemSelection();

		System.out.println(Brand+ " is a selected brand");
		String PriceOfExcelItem = Mycart.ItemPrice();
		System.out.println("The price of " +Brand + " is " +PriceOfExcelItem);
		String formattedPriceExcelOfItem = PriceOfExcelItem.replaceAll("\\D+", "");
		System.out.println("The formatted price of " +Brand + " is "+ "R"+formattedPriceExcelOfItem);
		int TruePriceOfExcelItem = Integer.parseInt(formattedPriceExcelOfItem);
		System.out.println("The True formatted price of " +Brand + " is "+ "R"+TruePriceOfExcelItem);
		tLandingPage.cleanup();
		
		
		Iselection.selecAddToCart();
		Mycart.GoToCart();
		Mycart.brandQuauntity(Quantity);
		int TrueExcelQuantity = Integer.parseInt(Quantity);

		

		

				
				
				
			   
		//	   System.out.println("The price of formatted quantity  is "+ TrueExcelQuantity);
				int totalExcelPrice = TruePriceOfExcelItem*TrueExcelQuantity;
				System.out.println("The total price of " +Brand + " is "+ "R"+ totalExcelPrice);
				
				String CartValue = Mycart.PriceOfCartItems2();
				String CartPrice = CartValue.replaceAll("\\D+", "");
				int TrueCartPrice = Integer.parseInt(CartPrice);
				//NumberFormat currency = NumberFormat.getCurrencyInstance();
				//currency.format(TrueCartPrice);
				System.out.println("The price of formatted item price  is from youtube "+ currency.format(TrueCartPrice));
				//System.out.println("The price of formatted item price  is from youtube "+ "R"+CartPrice);
				
				//Assert.assertEquals(TrueCartPrice, totalExcelPrice);
				
				if(TrueCartPrice==totalExcelPrice) {
					System.out.println("The True Cart Price is displayed correctly");
					Assert.assertTrue(true);
				}else System.out.println("The True Cart Price is displayed incorrectly");

	}


	@DataProvider(name = "excelBrandData")
	public Object[][] getDatafromExcel()
	{
		String excelDirectory = readExcel.getDataConfigProperties ("excelDataDir");
		Object[][] arrObj = readExcel.getExcelData(excelDirectory +"Brands.xlsx", "Sheet1");
		return arrObj;

	}

	//@AfterSuite
	public void cleanup() {
		tLandingPage.cleanup();

	}

}
	
	
	


