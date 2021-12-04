package frameWorkClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	// Declare the WebDriver
	public static WebDriver driver;

	// Constructor of the base class
	public BasePage() {
		if (driver == null) {
			// Get parameter values
			String browser = getDataConfigProperties("browser");
			String systemUnderTest = getDataConfigProperties("systemUnderTest");
			String pdriverDirChrome = getDataConfigProperties("driverDirChrome");
			String pdriverDirFireFox = getDataConfigProperties("driverdirFireFox");
			String pdriverDirEdge = getDataConfigProperties("Edgedriver");

			// Check if parameter passed as chrome
			if (browser.equalsIgnoreCase("chrome")) {

				// Set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver", pdriverDirChrome + "chromedriver.exe");

				// Create an instance of chrome
				driver = new ChromeDriver();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("FireFox")) {

				// Set path to chromedriver.exe
				System.setProperty("webdriver.gecko.driver", pdriverDirFireFox + "geckodriver.exe");

				// Create an instance of chrome
				driver = new FirefoxDriver();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("Edge")) {

				// Set path to chromedriver.exe
				System.setProperty("webdriver.edge.driver", pdriverDirEdge + "MicrosoftWebDriver.exe");

				// Create an instance of chrome
				driver = new EdgeDriver();
				driver.get(systemUnderTest);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}

		}
	}

	// Create a method to read the config
	public String getDataConfigProperties(String propertyName) {

		// Properties set
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(propertyName);
	}

	// Create the method to wait for element
	public void waitForElement(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pLocator));
	}

	// Create the method to wait for URL
	public void waitForUrl(int elementWait, String pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.urlContains(pLocator));

	}

	// Create a method to wait for click
	public void waitForClick(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.elementToBeClickable(pLocator));

	}

	// Create the method to get element text
	public String getElementText(By pLocator) {
		waitForElement(20, pLocator);
		String h1 = getElement(pLocator).getText();
		return h1;
	}

	// Create the method to click element
	public void clickElement(By pLocator) {
		waitForClick(20, pLocator);
		getElement(pLocator).click();
	}

	// Create the method to get Element
	public WebElement getElement(By pLocator) {
		waitForClick(20, pLocator);
		return driver.findElement(pLocator);
	}

	// clean up (close the browser
	public void cleanup() {
		driver.close();
	}

	// Create the method to Enter text
	public void EnterText(By pLocator, String pText) {
		waitForClick(20, pLocator);
		driver.findElement(pLocator).sendKeys(pText);
	}

	// Create the method to to select the dropdown
	public void selectDropdown(By pLocator, String pValue) {
		// Creates an instance of a dropdown object
		Select sDrpDown = new Select(getElement(pLocator));
		// Populates the dropdown
		sDrpDown.selectByVisibleText(pValue);
	}
	
	public void closeChildBrowserTab() {
		Set<String> handles = driver.getWindowHandles();         //selenium will check how many windows are currently open, this will store the ID for both parent and child window
		Iterator<String> it = handles.iterator();                //using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
	    driver.switchTo().window(childWindowID);
	    driver.close();
	    driver.switchTo().window(parentWindowID);
	}

}
