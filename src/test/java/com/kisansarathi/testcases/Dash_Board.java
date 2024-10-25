package com.kisansarathi.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.DashBoard;
import com.kisansarathi.utilities.XLUtils;

public class Dash_Board extends Base_test {
	int rownum;
	@Test(dataProvider="DashBoard")
	public void dashboard(String MotherName,String FatherName,String ProfilePic) throws InterruptedException {
		DashBoard db = new DashBoard(driver);
		db.dashBoardSideNavigationBar();
		db.statedropdown();
		for(int i = 1; i <= rownum;) {
		db.profileEditing(MotherName, FatherName);
		break;
		}
		Thread.sleep(5000);

	}
	@DataProvider(name = "DashBoard")
	public String[][] getdashboardData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/dashboard.xlsx";

		rownum = XLUtils.getRowCount(path, "dash_board");
		int cellnum = XLUtils.getCellCount(path, "dash_board", 1);
		System.out.println("rownum" + " " + rownum);
		System.out.println("cellnum" + " " + cellnum);
		String dashboarddata[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < cellnum; j++) {
				System.out.print(i + " ");
				System.out.println(j);

				System.out.println(dashboarddata[i - 1][j] = XLUtils.getCellData(path, "dash_board", i, j));
			}
		}

		return dashboarddata;
	}


}
