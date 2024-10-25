package com.kisansarathi.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportExportUser {
	public WebDriver ldriver;
	WebDriverWait wait;

	public ReportExportUser(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Reports']")
	WebElement reports;

	@FindBy(xpath = "//span[normalize-space()='Export User']")
	WebElement exportuser;

	public void navigationMenus() {
		reports.click();
		exportuser.click();
	}

	public void displayuserreport() {
		wait = new WebDriverWait(ldriver, 40);  // Waits up to 10 seconds
		ldriver.findElement(By.xpath("//select[@id='role_id']")).click();
		List<WebElement> listofroles = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/"
						+ "form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]/option"));
		for (WebElement role : listofroles) {
			if (role.getText().equalsIgnoreCase("ATARI Director")) {
				role.click();
				//ldriver.findElement(By.xpath("//button[@id='show_report']")).click();
				// Example: Waiting for an element to become clickable
				//WebElement User_result_report = wait.until(ExpectedConditions.elementToBeClickable(By.id("(//div[@class='col-lg-12 col-md-12 col-sm-12'])[1]")));
				//String ReportResult_User=User_result_report.getText();
				//String User_result_report = ldriver.findElement(By.xpath("//div[@id='result_div']")).getText();
				//System.out.println("Reports_no.of.Users: " + ReportResult_User);
				ldriver.findElement(By.xpath("//button[@id='import_report']")).click();
				break;
			}
		}

	}

}
