package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.UsersManagementFarmersList;

public class UsersManagement_FarmersList extends Base_test {
	@Test
	public void usersmanagementFarmersList() {
		UsersManagementFarmersList umf = new UsersManagementFarmersList(driver);
		umf.usersmanagementSideNavigationBar();
		umf.farmerslist();
		umf.zonestatedistrictblock();
		umf.mess_selection();
	}

}
