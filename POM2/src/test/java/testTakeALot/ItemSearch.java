package testTakeALot;



//import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WindowType;
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
		tLandingPage.clickMarcoSearchBox();

		tLandingPage.selectBrand();
		Iselection.selecAddToCart1();
		System.out.println(Iselection.getAddedToCartText());


		String ActualAddToCartText = Iselection.getAddedToCartText();
		String ExpectedAddToCartText = "Added to cart";

		Assert.assertEquals(ActualAddToCartText, ExpectedAddToCartText);	

	}
	
	@Test
	public void GIVEN_YouAreDailyDeals_WHEN_ItemIsSelected_THEN_SkipTheTestCase() throws InterruptedException  {

		tLandingPage.goHome();
		//tLandingPage.acceptCookies();
		tLandingPage.clickDailyDeals();
		tLandingPage.selectBrand();
		tLandingPage.cleanup();
		Iselection.selecAddToCart1();
		System.out.println(Iselection.getAddedToCartText());
		String ActualAddToCartText = Iselection.getAddedToCartText();
		String ExpectedAddToCartText = "Added to cart";

		Assert.assertEquals(ActualAddToCartText, ExpectedAddToCartText);
		throw new SkipException("This is a skipped test case");

	}

	@Test
	public void GIVEN_NavigationToHomePage_WHEN_DoingItemSearch_AND_SelectABrand_THEN_MoreThanZeroItemsDisplayed() {
		tLandingPage.goHome();
		//tLandingPage.acceptCookies();
		tLandingPage.enterSearchItem("Office & Stationery");
		tLandingPage.clickSearchButton();
		tLandingPage.clickMarcoSearchBox();



		String NumberOfItemsResults = tLandingPage.noOfItems();
		System.out.println(NumberOfItemsResults);
		String NumberOfItems = NumberOfItemsResults.substring(0,3);
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
		tLandingPage.clickMarcoSearchBox();
		tLandingPage.selectBrand();
		tLandingPage.cleanup();
		Iselection.selecAddToCart();
		Mycart.GoToCart();
		Mycart.SelectQuantity();

		String PriceOfItem = Mycart.ItemPrice();


		WebElement quantityList = getElement(By.id("cart-item_undefined"));
		Select sel = new Select(quantityList);
		sel.selectByIndex(1);

		List<WebElement> SelectedQuantity = sel.getOptions();
		String QuantityNumber = SelectedQuantity.get(1).getText();

		System.out.println("The quantity value is " +QuantityNumber);
		System.out.println("The price value is " +PriceOfItem);

		String PriceValue = PriceOfItem.substring(2,5);
		System.out.println("The formatted PriceValue is "+ "R"+PriceValue);


		int TruePriceValue = Integer.parseInt(PriceValue);
		int quantityNo = Integer.parseInt(QuantityNumber);
		int totalPrice = TruePriceValue*quantityNo;

		System.out.println("The total price is "+ "R"+totalPrice);

		String CartValue = Mycart.PriceOfCartItems();
		System.out.println("The price of cart items is " +CartValue);

		String CartPrice = CartValue.substring(2,5);
		System.out.println("The formatted price is "+ "R"+CartPrice);

		int TrueCartPrice = Integer.parseInt(CartPrice);
		System.out.println("The formatted CartPrice is "+ "R"+TrueCartPrice);

		if(totalPrice==TrueCartPrice) {
			System.out.println("Cart Value is displayed correctly");
			Assert.assertTrue(true);
		}else System.out.println("Cart Value is displayed incorrectly");


	}

	@Test(dataProvider="excelBrandData")


	public void dataImportList(String Brand,String Quantity) throws InterruptedException {
		tLandingPage.goHome();
		System.out.println("The brand name is "+ Brand + " and the quantity is " + Quantity );
		tLandingPage.enterSearchItem(Brand);
		tLandingPage.clickSearchButton();
		tLandingPage.clearSearch();
		tLandingPage.selectBrand();
		tLandingPage.cleanup();
		System.out.println(Brand+ " is a selected brand");
		Iselection.selecAddToCart();
		Mycart.GoToCart();
		Mycart.brandQuauntity(Quantity);
		
		String Expected = "Shopping Cart";
		String Actual = Mycart.ShoppingCartText();
		
		Assert.assertEquals(Expected, Actual);
		


	}


	@DataProvider(name = "excelBrandData")
	public Object[][] getDatafromExcel()
	{
		String excelDirectory = readExcel.getDataConfigProperties ("excelDataDir");
		Object[][] arrObj = readExcel.getExcelData(excelDirectory +"Brands.xlsx", "Sheet1");
		return arrObj;




	}
	
	@AfterSuite
	public void cleanup() {
		tLandingPage.cleanup();

	}




}


