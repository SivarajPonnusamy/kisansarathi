package com.kisansarathi.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kisansarathi.utilities.CommonFunc;

public class FarmerRegistration {
	public WebDriver ldriver;
	public WebDriverWait wait;
	public CommonFunc cf;

	public FarmerRegistration(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(rdriver, 30);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//span[normalize-space()='Registration']")
	WebElement registrationtab;

	@FindBy(xpath = "//span[normalize-space()='Farmer']")
	WebElement farmerstab;

	@FindBy(xpath = "//select[@id='Tbluser_Gender']")
	WebElement gender;

	@FindBy(xpath = "//select[@id='state_id']")
	WebElement states;

	@FindBy(xpath = "//select[@id='district_id']")
	WebElement districts;
	@FindBy(xpath = "//select[@id='block_id']")
	WebElement blocks;
	@FindBy(xpath = "//select[@id='village_id']")
	WebElement villages;
	@FindBy(xpath = "//select[@id='kvk_id']")
	WebElement kvkcenter;
	@FindBy(xpath = "//select[@id='language_id']")
	WebElement language;
	// @FindBy(xpath="//input[@name='submit_basic']")
	// WebElement savebutton;

	public void registrationSideNavigationBar() {
		registrationtab.click();
	}

	public void farmersNavigationBar() throws InterruptedException {
		farmerstab.click();
		Thread.sleep(3000);

	}

	public void farmerregistrationForm(String farmername, String dob, String mobilenumber) {

		ldriver.findElement(By.xpath("//input[@id='Tbluser_UserName']")).sendKeys(farmername);
		ldriver.findElement(By.xpath("//input[@id='date_of_birth']")).sendKeys(dob);
		ldriver.findElement(By.xpath("//input[@id='Tbldispatchofficer_Mobile1']")).sendKeys(mobilenumber);
		ldriver.findElement(By.xpath("//input[@id='Tbldispatchofficer_Mobile1']")).sendKeys(mobilenumber);

	}

	public void gender() {
		gender.click();
		List<WebElement> listofgender = ldriver.findElements(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/select[1]/option"));
		System.out.println("Gender options: " + listofgender.size());
		for (WebElement gender : listofgender) {
			System.out.println("List of options: " + gender.getText());
			if (gender.getText().equalsIgnoreCase("female")) {
				gender.click();
				break;
			}
		}
	}

	public void address(String address) {
		ldriver.findElement(By.xpath("//textarea[@id='Tbluser_Address']")).sendKeys(address);
	}

	public void state() {
		states.click();
		List<WebElement> listofstates = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]"
						+ "/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/select[1]/option"));
		System.out.println("List of states :" + listofstates.size());
		for (WebElement state : listofstates) {
			System.out.println("List of states in India: " + state.getText());
			if (state.getText().equalsIgnoreCase("UTTAR PRADESH")) {
				state.click();
				break;
			}
		}
	}

	public void district() {
		districts.click();
		List<WebElement> listofdistrict = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]"
				+ "/div[2]/div[1]/div[1]/form[1]/div[2]/div[4]/div[1]/select[1]/option"));
		System.out.println("List of districts :" + listofdistrict.size());
		for (WebElement district : listofdistrict) {
			System.out.println("List of districts: " + district.getText());
			if (district.getText().equalsIgnoreCase("AZAMGARH")) {
				district.click();
				break;
			}
		}
	}

	public void blocks() {
		blocks.click();
		List<WebElement> listofblocks = ldriver.findElements(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/select[1]/option"));
		System.out.println("List of Blocks :" + listofblocks.size());
		for (WebElement blocks : listofblocks) {
			System.out.println("List of Blocks: " + blocks.getText());
			if (blocks.getText().equalsIgnoreCase("Sagri")) {
				blocks.click();
				break;
			}
		}
	}

	public void villages() {
		villages.click();
		List<WebElement> listofvillages = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]"
				+ "/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/select[1]/option"));
		System.out.println("List of Villages :" + listofvillages.size());
		for (WebElement Villages : listofvillages) {
			System.out.println("List of Villages: " + Villages.getText());
			if (Villages.getText().equalsIgnoreCase("Abbhan Patti")) {
				Villages.click();
				break;
			}
		}
	}

	public void pincode(String pincode) {
		ldriver.findElement(By.xpath("//input[@id='Tbluser_Pincode']")).sendKeys(pincode);
	}

	public void kvkcentre() {
		kvkcenter.click();
		List<WebElement> listofkvkcenter = ldriver.findElements(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/div[4]/div[1]/select[1]/option"));
		System.out.println("List of kvkcenter :" + listofkvkcenter.size());
		for (WebElement kvkcentres : listofkvkcenter) {
			System.out.println("List of kvkcentres: " + kvkcentres.getText());
			if (kvkcentres.getText().equalsIgnoreCase("DIC test KVK")) {
				kvkcentres.click();
				break;
			}
		}
	}

	public void language() {
		language.click();
		List<WebElement> listoflanguages = ldriver.findElements(By.xpath(
				"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/div[1]/div[1]/select[1]/option"));
		System.out.println("List of languages :" + listoflanguages.size());
		for (WebElement language : listoflanguages) {
			System.out.println("List of language: " + language.getText());
			if (language.getText().equalsIgnoreCase("English")) {
				language.click();
				break;
			}
		}
	}

	public void landsize(String acre) {
		System.out.println("Siva 1");
		WebElement landsize = ldriver.findElement(By.xpath("//input[@id='land_size']"));
		System.out.println("Siva 2");
		// cf.scrollDown(landsize);

		landsize.sendKeys(acre);

	}

	public void advisory() {

		ldriver.findElement(By.xpath("//input[@id='flexCheckDefault_Agriculture']")).click();
		System.out.println("Siva 3");
		ldriver.findElement(By.xpath(
				"//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[9]/div[2]/div[1]/div[2]/div[1]/input[6]"))
				.click();
	}

	public void saveButton() {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		// Scroll to the specific element

		System.out.println("Siva 4");
		WebElement savebutton = ldriver.findElement(By.xpath("//input[@name='submit_basic']"));
		js.executeScript("arguments[0].scrollIntoView(true);", savebutton);
		// cf.scrollDown(savebutton);
		savebutton.click();
	}

}
