package com.kisansarathi.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public WebDriver ldriver;
	public WebDriverWait wait;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(rdriver, 30);
		rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//input[@id='LoginForm_username']")
	WebElement mobileno;

	@FindBy(xpath = "//input[@id='newbutton']")
	WebElement nextbutton;

	@FindBy(xpath = "//input[@id='LoginForm_password']")
	WebElement pinno;

	@FindBy(xpath = "//input[@id='submit-btn']")
	WebElement submitbutton;

	public void setmobileNO(String mobilenumber) {
		wait.until(ExpectedConditions.visibilityOf(mobileno));
		mobileno.clear();
		mobileno.sendKeys(mobilenumber);
	}

	public void nextButton() {
		nextbutton.click();
	}

	public void setpinNo(String pinnumber) {
		wait.until(ExpectedConditions.visibilityOf(pinno));
		pinno.clear();
		pinno.sendKeys(pinnumber);
	}

	public void loginButton() {
		submitbutton.click();
	}

}
