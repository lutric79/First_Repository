package pageObjectDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class TableScraping extends BasePage {
	
	public void gotToTablesDemo() {
		driver.get("http://demo.guru99.com/test/table.html");
	}
	
	public void tablesDemo() {
		gotToTablesDemo();
		//To locate table
		WebElement mytable = getElement(By.xpath("//tbody"));
		
		//To locate rows of table
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		//To calculate number of rows
		int rows_count = rows_table.size();
		//Loop will execute till the last row
		for (int row = 0; row < rows_count; row++) {
			//To locate no of columns(cells) in that specific row
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			//To locate no of columns(cells) in that specific row
			int columns_count = Columns_row.size();
			System.out.println("Number of cells in Row "+ "is " + columns_count);
			//Loop will execute till the last cell of specific row
			for(int column = 0; column < columns_count; column++) {
				//To retrieve text from that specific cell
				String celtext = Columns_row.get(column).getText();
				System.out.println("Cell value of row number " +column + " is " + celtext);
			}
		}
	}

}
