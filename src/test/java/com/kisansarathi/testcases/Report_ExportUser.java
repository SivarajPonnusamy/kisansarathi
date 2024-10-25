package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.ReportExportUser;

public class Report_ExportUser extends Base_test{
	@Test
	public void exportuserReports() {
		ReportExportUser eu = new ReportExportUser(driver);
		eu.navigationMenus();
		eu.displayuserreport();
	}

}
