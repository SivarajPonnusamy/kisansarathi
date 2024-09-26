package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.UsersManagement;

public class Users_Management extends Base_test {
	@Test
	public void usersmanagement() {
		UsersManagement um = new UsersManagement(driver);
		um.usersmanagementSideNavigationBar();
		um.myatariandkvks();
		um.statedisblockDetails();
		um.specificUsers();
	
	}

}
