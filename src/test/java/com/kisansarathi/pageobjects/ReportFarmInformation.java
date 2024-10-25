package com.kisansarathi.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportFarmInformation {
	public WebDriver ldriver;
	WebDriverWait wait;

	public ReportFarmInformation(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Reports']")
	WebElement reports;
	@FindBy(xpath = "//span[normalize-space()='Farm Information']")
	WebElement farminfo;

	public void navigationMenus() {
		reports.click();
		farminfo.click();
	}

	public void displayfarminfo() {
		ldriver.findElement(By.xpath("//select[@id='state_id']")).click();
		List<WebElement> listofstates = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/select[1]/option"));
		for (WebElement state : listofstates) {
			if (state.getText().contains("LADAKH")) {
				state.click();
				ldriver.findElement(By.xpath("//select[@id='district_id']")).click();
				List<WebElement> listofdistricts = ldriver.findElements(By.xpath(
						"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/select[1]/option"));
				for (WebElement district : listofdistricts) {
					if (district.getText().contains("KARGIL")) {
						district.click();
						ldriver.findElement(By.xpath("//button[contains(text(),'Filter')]")).click();
						break;
					}
				}
			}
		}

	}
}
