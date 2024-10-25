package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.ReportExportUser;
import com.kisansarathi.pageobjects.ReportFarmer;

public class Report_Farmer extends Base_test{
	@Test
	public void farmerReports() {
		ReportFarmer rf = new ReportFarmer(driver);
		rf.navigationMenus();
		rf.displayfarmerreport();
	}

}
