package pageObjectDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class TableScrapingSmallPrac extends BasePage {

	public void gotToTablesDemo() {
		driver.get("http://demo.guru99.com/test/web-table-element.php");
	}

	public void tablesDemo() {
		gotToTablesDemo();
		// To locate table
		WebElement mytable = getElement(By.xpath("//tbody"));

		// To locate rows of table
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate number of rows
		int rows_count = rows_table.size();
		System.out.println("The number of rows is " + rows_count);
		// Loop will execute till the last row
		// for (int row = 0; row < rows_count; row++) {
		// To locate no of columns(cells) in that specific row
		List<WebElement> Columns_row = rows_table.get(1).findElements(By.tagName("td"));
		// To locate no of columns(cells) in that specific row
		int columns_count = Columns_row.size();
		System.out.println("The number of columns is " + columns_count);

	}
	// }

	public void get_row_column_value() {
		String row_column_value = getElementText(By.xpath("//tbody/tr[4]/td[4]"));
		System.out.println("The value of a cell is " + row_column_value);

	}
}
