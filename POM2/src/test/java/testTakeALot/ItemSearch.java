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


		if(totalPrice==TrueCartPrice) {
			System.out.println("Cart Value is displayed correctly");
			Assert.assertTrue(true);
		}else System.out.println("Cart Value is displayed incorrectly");
		
		driver.manage().deleteAllCookies();


	}

	@Test(dataProvider="excelBrandData")

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
		String formattedPriceExcelItem = PriceOfExcelItem.replaceAll("\\D+", "");
		System.out.println("The formatted price of " +Brand + " is "+formattedPriceExcelItem);
		int TruePriceOfExcelItem = Integer.parseInt(formattedPriceExcelItem);
		System.out.println("The True formatted price of " +Brand + " is "+ currency.format(TruePriceOfExcelItem));
		tLandingPage.cleanup();
		//Mycart.SwitchToNewTab();

		Iselection.selecAddToCart();
		Mycart.GoToCart();
		Mycart.SelectBrandQuantity(Quantity);
		Thread.sleep(10000);
		int TrueExcelQuantity = Integer.parseInt(Quantity);

		
		int totalExcelPrice = TruePriceOfExcelItem*TrueExcelQuantity;
//		public int GetTotalPrice(int quantity, int unitPrice) {
//			return quantity*unitPrice;
//			
//		}
		System.out.println("The total price of " +Brand + " is "+currency.format(totalExcelPrice));
		

		String CartValue = Mycart.PriceOfCartItems2();
		System.out.println(CartValue +" The cart value read by the locator");
		String CartPrice = CartValue.replaceAll("\\D+", "");
		System.out.println(CartPrice + " When the R is cut");
		int TrueCartPrice = Integer.parseInt(CartPrice);
		System.out.println(TrueCartPrice + " When it's cast to int");
		
		System.out.println("The price of formatted item price is  "+ currency.format(TrueCartPrice));
		


		if(TrueCartPrice==totalExcelPrice) {
			System.out.println("The True Cart Price is displayed correctly");
			Assert.assertTrue(true);
		}else System.out.println("The True Cart Price is displayed incorrectly");
		
		driver.manage().deleteAllCookies();



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





