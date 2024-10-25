package com.kisansarathi.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.ZoneMaster;
import com.kisansarathi.utilities.XLUtils;

public class Zone_Master extends Base_test {
	int rownum;
	@Test(dataProvider="zonemaster")
	public void zoneMaster(String ZoneName) {
		ZoneMaster zm = new ZoneMaster(driver);
		zm.Navigationmenus();
		zm.addZone(ZoneName);
		
	}
	
	@DataProvider(name = "zonemaster")
	public String[][] getZonedata() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/zonemaster.xlsx";

		rownum = XLUtils.getRowCount(path, "zonemaster");
		int cellnum = XLUtils.getCellCount(path, "zonemaster", 1);
		System.out.println("rownum" + " " + rownum);
		System.out.println("cellnum" + " " + cellnum);
		String zone[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				System.out.print(i + " ");
				System.out.println(j);
				System.out.println(zone[i - 1][j] = XLUtils.getCellData(path, "zonemaster", i, j));
			}
		}
		return zone;
	}

}
