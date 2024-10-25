package com.kisansarathi.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportFarmer {
	public WebDriver ldriver;
	WebDriverWait wait;

	public ReportFarmer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Reports']")
	WebElement reports;

	@FindBy(xpath = "//span[normalize-space()='Farmer Report']")
	WebElement farmer;

	public void navigationMenus() {
		reports.click();
		farmer.click();
	}

	public void displayfarmerreport() {
		ldriver.findElement(By.xpath("//select[@id='state_id']")).click();
		List<WebElement> listofstates = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/"
						+ "form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option"));
		for (WebElement state : listofstates) {
			if (state.getText().contains("LADAKH")) {
				state.click();
				ldriver.findElement(By.xpath("//select[@id='district_id']")).click();
				List<WebElement> listofdistricts = ldriver
						.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/select[1]/option"));
				for (WebElement district : listofdistricts) {
					if (district.getText().contains("KARGIL")) {
						district.click();
						ldriver.findElement(By.xpath("//button[@id='import_report']")).click();
						// Download
						//ldriver.findElement(By.xpath("//span[contains(text(),'Excel')]")).click();
						break;
						

					}
				}
			}
		}

	}

}
