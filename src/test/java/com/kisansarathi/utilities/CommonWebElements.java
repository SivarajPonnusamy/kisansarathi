package com.kisansarathi.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonWebElements {
	public WebDriver ldriver;
	public CommonWebElements(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(xpath = "//*[@id='state_id']")
	WebElement statedropdown;
	
	public void statedropdown() {
		statedropdown.click();
	}
	

}
