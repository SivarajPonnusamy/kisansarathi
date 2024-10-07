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

public class ManageDistrict {
	WebDriver ldriver;
	public WebDriverWait wait;
	public ManageDistrict(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(rdriver, 30);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@FindBy(xpath = "(//span[contains(text(), 'Manage') and @class =\"xn-text\"])[2]")
	WebElement managetab;
	
	@FindBy(xpath="//a[contains(text(), 'District')]")
	//a[contains(text(), 'District')]//span[contains(@class, 'fa-sitemap')]
	WebElement district;
	
	@FindBy(xpath="//button[contains(text(),'Add District')]")
	WebElement adddistrictbt;
	
	public void manageSideNavigationBar() {
		managetab.click();
	}
	public void districtmenu() {
		district.click();
	}
	public void addDistrict(String districtname) {
		adddistrictbt.click();
		
		WebElement state_dropdown = ldriver.findElement(By.xpath("//select[@name='state_id_modal']"));
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click();", state_dropdown);

		
		//ldriver.findElement(By.xpath("//select[@name='state_id_modal']")).click();
		System.out.println("Siva 1...");
		List<WebElement>listofstates=ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[1]/div[2]"
				+ "/div[1]/div[1]/div[2]/select[1]/option"));
		System.out.println("Siva 2...");
		for(WebElement state:listofstates) {
			if(state.getText().equalsIgnoreCase("TAMIL NADU")) {
				state.click();
				ldriver.findElement(By.xpath("//input[@id='addDistrict']")).sendKeys(districtname);
				break;
			}
			
		}	
	}
	public void savebutton() throws InterruptedException {
		ldriver.findElement(By.xpath("//button[contains(text(),'Save changes')]")).click();
		Alert alert = ldriver.switchTo().alert();
		Thread.sleep(4000);
		String alertText=alert.getText();
		System.out.println("Alert text: " + alertText);
		alert.accept();
		
	}
	

}
