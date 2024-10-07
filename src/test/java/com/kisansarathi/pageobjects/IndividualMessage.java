package com.kisansarathi.pageobjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndividualMessage {
	WebDriver ldriver;

	public IndividualMessage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Messages')]")
	WebElement messagetab;

	@FindBy(xpath = "//input[@id='select_tag']")
	WebElement mobilenumber;

	public void messagetab() {
		// JavascriptExecutor js = (JavascriptExecutor) ldriver;
		// js.executeScript("arguments[0].scrollIntoView(true);", messagetab);
		messagetab.click();
		ldriver.findElement(By.xpath("//a[normalize-space()='Compose']")).click();
		ldriver.findElement(By.xpath("//a[normalize-space()='Individual']")).click();

		/**/
	}

	public void mobileNumber() {
		mobilenumber.click();
		mobilenumber.sendKeys("9092147170");
		// check button
		ldriver.findElement(By.xpath("//input[@id='ajaxbtn']")).click();
	}

	public void keywordContent() {
		ldriver.findElement(By.xpath("//input[@placeholder='Enter Keywords']")).sendKeys("A");
		List<WebElement> keywords = ldriver.findElements(By.xpath("//div[@class='tt-menu tt-open']//div"));
		System.out.println("Size of the suggest keyword: " + keywords.size());

		for (WebElement keyword : keywords) {
			System.out.println("asbcds: " + keyword.getText());
			if (keyword.getText().equalsIgnoreCase("Agriculture")) {

				keyword.click();
				break;

			}

		}
		ldriver.findElement(By.xpath("//input[@type='radio']")).click();

		ldriver.findElement(By.xpath("//textarea[@id='msgbox']")).sendKeys("abcdefghijklmnopqrstuvwxyz");
		WebElement radiobutton = ldriver.findElement(By.xpath("//input[@id='checktnc']"));

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		// Scroll to the specific element
		js.executeScript("arguments[0].scrollIntoView(true);", radiobutton);
		radiobutton.click();
		ldriver.findElement(By.xpath("//input[@id='tnc']")).click();

		Alert alert = ldriver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text: " + alertText);
		alert.accept();
	}

}
