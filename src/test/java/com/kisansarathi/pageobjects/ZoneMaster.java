package com.kisansarathi.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZoneMaster  {
	WebDriver ldriver;

	public ZoneMaster(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//span[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//span[normalize-space()='Zone Master']")
	WebElement zonemaster;
	
	@FindBy(xpath="//button[@id='myBtn']")
	WebElement addzonebutton;
	
	@FindBy(xpath="//input[@id='addZonename']")
	WebElement addzone;
	
	public void Navigationmenus() {
		settings.click();
		zonemaster.click();
	}
	
	public void addZone(String zonename) {
		addzonebutton.click();
		
		ldriver.findElement(By.xpath("//input[@id='addZonename']")).sendKeys(zonename);
		ldriver.findElement(By.xpath("//button[normalize-space()='Save changes']")).click();
		
		Alert alert_1 = ldriver.switchTo().alert();
		String alertText_1=alert_1.getText();
		System.out.println("Alert text_Zone: " + alertText_1);
		alert_1.accept();
		
		ldriver.findElement(By.xpath("//input[@type='search']")).sendKeys(zonename);
		ldriver.findElement(By.xpath("//tbody/tr[1]/td[5]/button[1]/span[1]")).click();
		
		Alert alert_2 = ldriver.switchTo().alert();
		String alertText_2=alert_2.getText();
		System.out.println("Alert deactive: " + alertText_2);
		alert_2.accept();
		
		Alert alert_3 = ldriver.switchTo().alert();
		String alertText_3=alert_3.getText();
		System.out.println("Alert deactivesuccessful: " + alertText_3);
		alert_3.accept();
		
	}

}
