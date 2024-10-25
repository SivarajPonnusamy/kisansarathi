package com.kisansarathi.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PendingQuery {
	WebDriver ldriver;
	public WebDriverWait wait;

	public PendingQuery(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Manage Query']")
	WebElement managequery;

	@FindBy(xpath = "//a[normalize-space()='Pending Queries']")
	WebElement pendingquery;

	public void managequery() {
		managequery.click();
		pendingquery.click();
	}

	public void queriesTable() {
		// Locate Zone
		ldriver.findElement(By.xpath("//select[@id='zone_id']")).click();
		List<WebElement> listofzones = ldriver
				.findElements(By.xpath("//select[@name='zone_id']//option[contains(value,'')]"));
		for (WebElement zone : listofzones)
			if (zone.getText().equalsIgnoreCase("ATARI, Zone VIII, Pune")) {
				zone.click();
				// Locate state
				ldriver.findElement(By.xpath("//select[@id='state_id']")).click();
				List<WebElement> listofstates = ldriver
						.findElements(By.xpath("//select[@name='state_id']//option[contains(value,'')]"));
				for (WebElement state : listofstates) {
					if (state.getText().equalsIgnoreCase("GOA")) {
						state.click();
						// Locate District
						ldriver.findElement(By.xpath("//select[@id='district_id']")).click();
						List<WebElement> listofdistricts = ldriver
								.findElements(By.xpath("//select[@name='district_id']//option[contains(value,'')]"));
						for (WebElement district : listofdistricts) {
							if (district.getText().equalsIgnoreCase("NORTH GOA")) {
								district.click();
								// Locate KVK's
								ldriver.findElement(By.xpath("//select[@id='kvk_id']")).click();
								List<WebElement> listofkvks = ldriver
										.findElements(By.xpath("//select[@name='kvk_id']//option[contains(value,'')]"));
								for (WebElement kvk : listofkvks) {
									if (kvk.getText()
											.equalsIgnoreCase("Krishi Krishi Vigyan Kendra,\r\n"
													+ "ICAR Research Complex for Goa, Ela,\r\n" + "Old Goa\r\n"
													+ "Taluka Tiswadi")) {
										kvk.click();

										break;

									}
								}
							}

						}
					}
				}
			}
		ldriver.findElement(By.xpath("//input[@value='Submit']")).click();
		Alert alert = ldriver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println("Alert text: " + alertText);
		alert.accept();
		

		// Locate the table by ID or other locator
		WebElement table = ldriver.findElement(By.xpath("//div[@class='panel-body']"));

		// Locate all rows in the table (excluding the header row)
		List<WebElement> rows = table.findElements(By.xpath("//tbody//tr"));

		// Iterate through each row
		for (WebElement row : rows) {
			// Locate all columns (cells) in the row
			List<WebElement> columns = row.findElements(By.tagName("td"));

			// Iterate through each column in the row and print the cell values
			for (WebElement column : columns) {
				if (column.getText().equals("1424")) {
					String actualvalue="Query_id actually users clicks: "+column.getText();
		            column.click();  // Perform the click 
		            String RealValue=ldriver.findElement(By.xpath("//th[normalize-space()='Query ID']")).getText()+" "+ ldriver.findElement(By.xpath("//td[normalize-space()='1424']")).getText();
		            break;  // Exit after finding the desired element
		        }
				System.out.print(column.getText() + " "); // Print cell content
			}
			System.out.println(); // Move to the next row after finishing one
			
		}
		

	}
}
