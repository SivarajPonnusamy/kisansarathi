package com.kisansarathi.testcases;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.FarmerRegistration;
import com.kisansarathi.pageobjects.UserRegistration;
import com.kisansarathi.utilities.XLUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Farmers_Registration extends Base_test {
	int rownum;
	
	@Test(dataProvider = "FarmerRegistration")
	public void farmersRegistration(String FarmersName, String DOB, String MobileNumber, String Address,
			String Pincode, String Acre) throws InterruptedException {
		
		FarmerRegistration fr = new FarmerRegistration(driver);
		fr.registrationSideNavigationBar();
		fr.farmersNavigationBar();
		for (int i = 1; i <= rownum;) {
		fr.farmerregistrationForm(FarmersName, DOB, MobileNumber);
		fr.gender();
		fr.address(Address);
		fr.state();
		fr.district();
		fr.blocks();
		fr.villages();
		fr.pincode(Pincode);
		fr.kvkcentre();
		fr.language();
		fr.landsize(Acre);
		
		//fr.advisory();
		fr.saveButton();
		break;
		}
	
	} 
	
	@DataProvider(name = "FarmerRegistration")
	public String[][] getfarmerData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/farmerregistration.xlsx";

		rownum = XLUtils.getRowCount(path, "farmer_reg");
		int cellnum = XLUtils.getCellCount(path, "farmer_reg", 1);
		System.out.println("rownum" + " " + rownum);
		System.out.println("cellnum" + " " + cellnum);
	

		String farmerdata[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < cellnum; j++) {
				System.out.print(i + " ");
				System.out.println(j);

				System.out.println(farmerdata[i - 1][j] = XLUtils.getCellData(path, "farmer_reg", i, j));
			}
		}

		return farmerdata;
	}


}
