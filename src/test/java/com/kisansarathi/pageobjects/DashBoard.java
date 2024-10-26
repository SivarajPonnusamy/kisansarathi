package com.kisansarathi.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
	WebDriver ldriver;

	public DashBoard(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	WebElement dashboardtab;

	@FindBy(xpath = "//*[@id='state_id']")
	WebElement statedropdown;
	
	@FindBy(xpath="//body/div[1]/div[1]/ul[1]/li[2]/div[1]/div[3]/a[1]/span[1]")
	WebElement profileediting;

	public void dashBoardSideNavigationBar() {
		dashboardtab.click();
	}

	public void statedropdown() {
		statedropdown.click();
		List<WebElement> listofstates = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]"
				+ "/div[1]/div[1]/div[1]/div[1]/select[1]/option"));
		for (WebElement state : listofstates) {
			if (state.getText().equalsIgnoreCase("UTTAR PRADESH")) {
				state.click();
				ldriver.findElement(By.xpath("//select[@id='district_id']")).click();
				List<WebElement> listofdistricts = ldriver
						.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/select[1]/option"));
				for (WebElement district : listofdistricts) {
					if (district.getText().equalsIgnoreCase("AYODHYA")) {
						district.click();
						WebElement farmercard=ldriver.findElement(By.xpath("//body/div[@class='page-container']"
								+ "/div[@class='page-content']/div[@class='block']/div[3]/div[3]/div[1]/div[2]"));
						System.out.println("In dashboard Registered farmers count: "+farmercard.getText());
						break;
					}

				}
			}
		}
	}
	public void profileEditing(String MotherName,String FatherName) {
		profileediting.click();
		ldriver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		WebElement mothersname= ldriver.findElement(By.xpath("//input[@id='Tbldispatchofficer_DoMotherName']"));
		mothersname.clear();
		mothersname.sendKeys(MotherName);
		WebElement fathersname= ldriver.findElement(By.xpath("//input[@id='Tbldispatchofficer_DoFatherName']"));
		fathersname.clear();
		fathersname.sendKeys(FatherName);
		//ldriver.findElement(By.xpath("//input[@id='file']")).sendKeys(Profilepic);
		ldriver.findElement(By.xpath("//input[@id='submit_btn']")).click();	
		Thread.sleep(3000);)
		
		String profileupdate_successMess=ldriver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/form[1]")).getText();
		System.out.println("Profile update Mess:"+profileupdate_successMess);
		
	}
	
	

}
