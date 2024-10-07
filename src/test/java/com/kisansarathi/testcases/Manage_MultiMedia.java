package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.ManageMultiMedia;

public class Manage_MultiMedia extends Base_test{
	@Test
	public void manageMultimedia() throws InterruptedException {
		ManageMultiMedia mm = new ManageMultiMedia(driver);
		mm.multimediaSideNavigationBar();
		mm.createAdvisory();
		mm.domain();
		mm.subDomain();
		mm.crops();
		mm.problemType();
		mm.titlefield();
		mm.description();
		mm.draftdetails();
		Thread.sleep(5000);
		}

}
