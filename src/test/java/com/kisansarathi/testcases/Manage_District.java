package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.ManageDistrict;

public class Manage_District extends Base_test{
	@Test
	public void managedistrict() throws InterruptedException {
		ManageDistrict md = new ManageDistrict(driver);
		md.manageSideNavigationBar();
		md.districtmenu();
		md.addDistrict("testcovai");
		md.savebutton();
		Thread.sleep(5000);
		
	}

}
