package com.kisansarathi.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LanguageMaster {
	WebDriver ldriver;
	public LanguageMaster(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//span[normalize-space()='Language Master']")
	WebElement languagemaster;
	
	@FindBy(xpath="//button[@id='myBtn']")
	WebElement addlanguagebutton;
	
	public void Navigationmenus() {
		settings.click();
		languagemaster.click();
	}
	public void addLanguage(String languageName) {
		addlanguagebutton.click();
		ldriver.findElement(By.xpath("//input[@id='addLanguagename']")).sendKeys(languageName);
		ldriver.findElement(By.xpath("//button[normalize-space()='Save changes']")).click();
		Alert alert = ldriver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println("Alert text: " + alertText);
		
		if(alertText.contains("Language Already Exist")) {
			alert.accept();
			
		}
		else {
			alert.accept();
		}
	}
	

}
