package testTelco;

import org.testng.annotations.Test;

import pageObjectDemo.TableScraping;
import pageObjectDemo.TableScrapingSmallPrac;

public class TableScrapingTest {
	TableScrapingSmallPrac tsp = new TableScrapingSmallPrac();
	
	@Test
	public void TableDemoTest() {
		tsp.gotToTablesDemo();
		tsp.tablesDemo();
		tsp.get_row_column_value();
	}

}
