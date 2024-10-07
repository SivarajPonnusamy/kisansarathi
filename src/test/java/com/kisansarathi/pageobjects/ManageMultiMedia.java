package com.kisansarathi.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;

public class ManageMultiMedia {
	public WebDriver ldriver;
	public WebDriverWait wait;

	public ManageMultiMedia(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(rdriver, 30);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//span[contains(text(),'Manage Multimedia')]")
	WebElement multimediatab;
	@FindBy(xpath = "//a[normalize-space()='Create Advisory']")
	WebElement createadvisory;
	@FindBy(xpath = "//select[@id='Tbldraftmessage_domainid']")
	WebElement domain;
	@FindBy(xpath = "//select[@id='Tbldraftmessage_subdomainid']")
	WebElement subdomain;
	@FindBy(xpath = "//select[@id='Tbldraftmessage_cropid']")
	WebElement crops;
	@FindBy(xpath = "//select[@id='problemtypeid']")
	WebElement problemtype;
	@FindBy(xpath = "//textarea[@id='Tbldraftmessage_title']")
	WebElement titlebox;
	@FindBy(xpath = "//textarea[@id='Tbldraftmessage_description']")
	WebElement description;
	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	WebElement nextbutton;
	@FindBy(xpath = "//h4[contains(text(),'Draft ID ')]")
	WebElement draftid;

	public void multimediaSideNavigationBar() {
		multimediatab.click();
	}

	public void createAdvisory() {
		createadvisory.click();
	}

	public void domain() {
		domain.click();
		List<WebElement> listofdomains = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/"
						+ "div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/select[1]/option"));
		for (WebElement domain : listofdomains) {
			System.out.println("List of domains: " + domain.getText());
			if (domain.getText().equalsIgnoreCase("Agriculture")) {
				domain.click();
				break;
			}

		}

	}

	public void subDomain() {
		subdomain.click();
		List<WebElement> listofsubdomains = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]"
						+ "/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/select[1]/option"));

		for (WebElement subdomain : listofsubdomains) {
			System.out.println("List of subdomains: " + subdomain.getText());
			if (subdomain.getText().equalsIgnoreCase("Oilseeds")) {
				subdomain.click();
				break;
			}
		}

	}

	public void crops() {
		crops.click();
		List<WebElement> listofcrops = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]"
						+ "/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/select[1]/option"));
		for (WebElement crop : listofcrops) {
			System.out.println("List of crop: " + crop.getText());
			if (crop.getText().equalsIgnoreCase("Sunflower")) {
				crop.click();
				break;
			}
		}

	}

	public void problemType() {
		problemtype.click();
		List<WebElement> listofproblems = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]"
						+ "/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/select[1]/option"));
		for (WebElement problem : listofproblems) {
			System.out.println("List of crop: " + problem.getText());
			if (problem.getText().contains("Nutrient management")) {
				problem.click();
				break;
			}
		}

	}

	public void titlefield() {
		titlebox.sendKeys("1234567890");
	}

	public void description() {
		description.sendKeys("12345678901234567890");
		nextbutton.click();
	}

	public void draftdetails() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 50);
		String id_draft = draftid.getText();
		System.out.println("Draft_id:" + id_draft);
		// ldriver.findElement(By.xpath("//button[@id='editbtn']")).click();
		ldriver.findElement(By.xpath("//input[@id='tnc']")).click();
		ldriver.findElement(By.xpath("//a[@id='pills-profile-tab']")).click();
		ldriver.findElement(By.xpath("//textarea[@id='select']")).sendKeys("9092147170");
		ldriver.findElement(By.xpath("//input[@id='ajaxbtn']")).click();
		

		/*WebElement memberdetails = ldriver
				.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]"));

		wait.until(ExpectedConditions.elementToBeSelected(memberdetails));
		System.out.println("1234466666");
		String actual_memberdetails = memberdetails.getText();
		System.out.println("12344" + actual_memberdetails);
		String expected_memberdetails = "Mobile Number :-  9092147170 Name :-  Narayanan (Farmer) Response :-  All Mobile Numbers Are Valid";
		// Assert.assertEquals(actual_memberdetails, expected_memberdetails, "Values
		// should be equal");
		if (actual_memberdetails.contains(expected_memberdetails)) {
			ldriver.findElement(By.xpath("//input[@id='btn']")).click();
		}*/
		
		ldriver.findElement(By.xpath("//input[@id='btn']")).click();
		Thread.sleep(5000);
		Alert alert = ldriver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println("Alert text: " + alertText);
		alert.accept();

	}

}
