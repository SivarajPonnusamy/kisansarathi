package com.kisansarathi.pageobjects;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistration {
	public WebDriver ldriver;
	public WebDriverWait wait;

	public UserRegistration(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(rdriver, 30);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//span[normalize-space()='Registration']")
	WebElement registrationtab;

	@FindBy(xpath = "//span[normalize-space()='User']")
	WebElement userstab;
	@FindBy(xpath = "//select[@id='Tbldispatchofficer_Gender']")
	WebElement gender;

	@FindBy(xpath = "//select[@name='Tbldispatchofficer[Language]']")
	WebElement primarylanguage;

	@FindBy(xpath = "//select[@id='state_id']")
	WebElement states;

	@FindBy(xpath = "//select[@id='district_id']")
	WebElement districts;

	@FindBy(xpath = "//select[@id='kvk_id']")
	WebElement kvkcenter;

	@FindBy(xpath = "//input[@id='submit_btn']")
	WebElement submitbutton;

	public void registrationSideNavigationBar() {
		registrationtab.click();
	}

	public void usersNavigationBar() throws InterruptedException {
		userstab.click();
		Thread.sleep(3000);

	}

	public void registrationForm(String username, String mothername, String fathername, String mobilenumber,
			String usermail, String officeid) {
		System.out.println("siva");
		ldriver.findElement(By.xpath("//select[@id='role_option']")).click();
		List<WebElement> listofroles = ldriver.findElements(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/select[1]/option"));
		int noofroles = listofroles.size();
		System.out.println("Number of roles present in the dropdown: " + noofroles);
		for (WebElement role : listofroles) {
			System.out.println("Role Name: " + role.getText());
			if (role.getText().equalsIgnoreCase("kvk executive")) {
				role.click();
			}

		}
		ldriver.findElement(By.xpath("//input[@id='Tbldispatchofficer_DoName']")).sendKeys(username);
		ldriver.findElement(By.xpath("//input[@id='Tbldispatchofficer_DoMotherName']")).sendKeys(mothername);
		ldriver.findElement(By.xpath("//input[@id='Tbldispatchofficer_DoFatherName']")).sendKeys(fathername);
		ldriver.findElement(By.xpath("//input[@oninput='checkphone1()']")).sendKeys(mobilenumber);
		ldriver.findElement(By.xpath("//input[@id='Tbldispatchofficer_EmailID']")).sendKeys(usermail);
		ldriver.findElement(By.xpath("//input[@id='Tbldispatchofficer_OfficeID']")).sendKeys(officeid);

	}

	public void gender() {
		gender.click();
		List<WebElement> listofgender = ldriver.findElements(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/select[1]/option"));
		System.out.println("Gender options: " + listofgender.size());
		for (WebElement gender : listofgender) {
			System.out.println("List of options: " + gender.getText());
			if (gender.getText().equalsIgnoreCase("male")) {
				gender.click();
			}
		}
	}

	public void primarylanguage() {
		primarylanguage.click();
		List<WebElement> listoflanguages = ldriver.findElements(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[3]/div[2]/div[1]/span[1]/select[1]/option"));
		System.out.println(listoflanguages.size());
		for (WebElement language : listoflanguages) {
			System.out.println("List of language options:" + language);
			if (language.getText().contains("Tamil")) {
				language.click();
			}
		}

	}

	public void state() {
		states.click();
		List<WebElement> listofstates = ldriver.findElements(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[5]/div[2]/div[1]/div[1]/select[1]/option"));
		System.out.println("List of states :" + listofstates.size());
		for (WebElement state : listofstates) {
			System.out.println("List of states in India: " + state.getText());
			if (state.getText().equalsIgnoreCase("UTTAR PRADESH")) {
				state.click();
			}
		}
	}

	public void district() {
		districts.click();
		List<WebElement> listofdistrict = ldriver.findElements(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[5]/div[3]/div[1]/div[1]/select[1]/option"));
		System.out.println("List of districts :" + listofdistrict.size());
		for (WebElement district : listofdistrict) {
			System.out.println("List of districts: " + district.getText());
			if (district.getText().equalsIgnoreCase("AZAMGARH")) {
				district.click();
			}
		}
	}

	public void kvkcentre() {
		kvkcenter.click();
		List<WebElement> listofkvkcenter = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]"
				+ "/div[2]/form[1]/div[5]/div[4]/div[1]/div[1]/select[1]/option"));

		System.out.println("List of kvkcenter :" + listofkvkcenter.size());
		for (WebElement kvkcentres : listofkvkcenter) {
			System.out.println("List of kvkcentres: " + kvkcentres.getText());
			if (kvkcentres.getText().equalsIgnoreCase("DIC test KVK")) {
				kvkcentres.click();
			}
		}
	}

	public void submitButton() {
		submitbutton.click();
		WebElement UserId = ldriver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/form[1]/h4[1]"));
		System.out.println("User Id and registration success message: " + UserId.getText());
		ldriver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

	}

}
