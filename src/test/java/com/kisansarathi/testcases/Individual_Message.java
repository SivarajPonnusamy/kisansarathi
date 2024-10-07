package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.IndividualMessage;

public class Individual_Message extends Base_test {
	@Test
	public void individualMessage() {
		IndividualMessage im = new IndividualMessage(driver);
		im.messagetab();
		im.mobileNumber();
		im.keywordContent();
	}

}
