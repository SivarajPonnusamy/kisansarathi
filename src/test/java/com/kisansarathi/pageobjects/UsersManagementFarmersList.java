package com.kisansarathi.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersManagementFarmersList {
	public WebDriver ldriver;
	public WebDriverWait wait;

	public UsersManagementFarmersList(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(rdriver, 30);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@FindBy(xpath = "//span[contains(text(),'Users Management')]")
	WebElement usersmanagementtab;

	@FindBy(xpath = "//body/div[1]/div[1]/ul[1]/li[5]/ul[1]/li[2]/a[1]")
	WebElement farmerslist;

	public void usersmanagementSideNavigationBar() {
		usersmanagementtab.click();
	}

	public void farmerslist() {
		farmerslist.click();
	}

	public void zonestatedistrictblock() {
		ldriver.findElement(By.xpath("//select[@id='zone_id']")).click();
		List<WebElement> listofzones = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"
						+ "/form[1]/div[1]/div[1]/div[2]/select[1]/option"));
		for (WebElement zone : listofzones) {
			if (zone.getText().contains("ATARI, Zone I, Ludhiana")) {
				zone.click();
				ldriver.findElement(By.xpath("//select[@id='state_id']")).click();
				List<WebElement> listofstates = ldriver
						.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"
								+ "/form[1]/div[1]/div[2]/div[2]/select[1]/option"));
				for (WebElement state : listofstates) {
					if (state.getText().contains("LADAKH")) {
						state.click();
						ldriver.findElement(By.xpath("//select[@id='district_id']")).click();
						List<WebElement> listofdistricts = ldriver
								.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"
										+ "/form[1]/div[1]/div[3]/div[2]/select[1]/option"));
						for (WebElement district : listofdistricts) {
							if (district.getText().contains("KARGIL")) {
								district.click();
								ldriver.findElement(By.xpath("//select[@id='block_id']")).click();
								List<WebElement> listofblocks = ldriver.findElements(
										By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/"
												+ "form[1]/div[1]/div[4]/div[2]/select[1]/option"));
								for (WebElement block : listofblocks) {
									if (block.getText().contains("DRASS")) {
										block.click();
										ldriver.findElement(By.xpath("//select[@id='kvk_id']")).click();
										List<WebElement> listofkvks = ldriver.findElements(
												By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/"
														+ "form[1]/div[2]/div[1]/div[2]/select[1]/option"));
										for (WebElement kvk : listofkvks) {
											if (kvk.getText().contains("Krishi Vigyan Kendra,SKUAST (K)")) {
												kvk.click();
												break;
											}

										}
									}
								}

							}
						}

					}
				}
			}
		}

	}

	public void mess_selection() {
		ldriver.findElement(By.xpath("//thead/tr[2]/td[3]/a[1]/button[1]/span[1]")).click();
		// check button 
		ldriver.findElement(By.xpath("//input[@id='ajaxbtn']")).click();
		
		/*ldriver.findElement(By.xpath("//body/div[1]/div[2]/form[1]/div[1]/div[1]"
				+ "/div[2]/div[6]/div[1]/div[1]")).sendKeys("qwerty");*/

		ldriver.findElement(By.xpath("//input[@placeholder='Enter Keywords']")).sendKeys("A");
		List<WebElement>keywords=ldriver.findElements(By.xpath("//div[@class='tt-menu tt-open']//div"));
		System.out.println("Size of the suggest keyword: "+keywords.size());

		for(WebElement keyword:keywords) {
			System.out.println("asbcds: "+keyword.getText());
			if(keyword.getText().equalsIgnoreCase("Agriculture")) {
				
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
