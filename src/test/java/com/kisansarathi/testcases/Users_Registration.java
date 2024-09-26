package com.kisansarathi.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.UserRegistration;
import com.kisansarathi.utilities.XLUtils;

public class Users_Registration extends Base_test {
	int rownum;

	@Test(dataProvider = "UserRegistration")
	public void usersResgistration(String Name, String Mother_Name, String Father_Name, String Primary_mobile_number,
			String Email, String OfficeID) throws InterruptedException {
		UserRegistration ur = new UserRegistration(driver);
		ur.registrationSideNavigationBar();
		ur.usersNavigationBar();
		for (int i = 1; i <= rownum;) {
			ur.registrationForm(Name, Mother_Name, Father_Name, Primary_mobile_number, Email, OfficeID);
			ur.gender();
			ur.primarylanguage();
			ur.state();
			ur.district();
			ur.kvkcentre();
			ur.submitButton();
			break;
		}
		Thread.sleep(3000);
	}

	@DataProvider(name = "UserRegistration")
	public String[][] getUserData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/userregistration.xlsx";

		rownum = XLUtils.getRowCount(path, "usr_reg");
		int cellnum = XLUtils.getCellCount(path, "usr_reg", 1);
		System.out.println("rownum" + " " + rownum);
		System.out.println("cellnum" + " " + cellnum);
	

		String userdata[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < cellnum; j++) {
				System.out.print(i + " ");
				System.out.println(j);

				System.out.println(userdata[i - 1][j] = XLUtils.getCellData(path, "usr_reg", i, j));
			}
		}

		return userdata;
	}

}
