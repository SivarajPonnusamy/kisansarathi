package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.ReportFarmInformation;
import com.kisansarathi.pageobjects.ReportFarmer;

public class Report_FarmInformation extends Base_test {
	@Test
	public void farmerReports() {
		ReportFarmInformation fi = new ReportFarmInformation(driver);
		fi.navigationMenus();
		fi.displayfarminfo();
	}

}
