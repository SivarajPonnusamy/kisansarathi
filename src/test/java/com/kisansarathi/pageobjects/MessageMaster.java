package com.kisansarathi.pageobjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageMaster {
	WebDriver ldriver;

	public MessageMaster(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//span[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//span[normalize-space()='Message Master']")
	WebElement messagemaster;
	
	@FindBy(xpath="//span[@class='btn btn-primary custom-btn text-white addstate']")
	WebElement addmessagebutton;
	
	public void Navigationmenus() {
		settings.click();
		messagemaster.click();
	}
	
	public void addMessage() {
		addmessagebutton.click();
		ldriver.findElement(By.xpath("//select[@id='language']")).click();
		List<WebElement> listoflanguages=ldriver.findElements(By.xpath("//option[contains(text(),'')]"));
		for(WebElement language:listoflanguages) {
			if(language.getText().equalsIgnoreCase("English"))
			{
				language.click();
				ldriver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("abcdefghijklmnop1223___^7");
				ldriver.findElement(By.xpath("//input[@name='submit']")).click();
				Alert alert = ldriver.switchTo().alert();
				String alertText=alert.getText();
				System.out.println("Alert text: " + alertText);
				alert.accept();
				break;
			}
		}
	}
	
	

}
