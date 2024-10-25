package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.MessageMaster;

public class Message_Master extends Base_test{
	@Test
	public void messageMaster() {
		MessageMaster  mm = new MessageMaster(driver);
		mm.Navigationmenus();
		mm.addMessage();
		
	}

}
