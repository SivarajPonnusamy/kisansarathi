package com.kisansarathi.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {

	Properties pro;

	public Readconfig() {
		String file1 = (System.getProperty("user.dir") + "/src/test/resources/configfiles/login.properties");
		try {
			FileInputStream signin = new FileInputStream(file1);
			pro = new Properties();
			pro.load(signin);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());

		}
	}

	public String getmobileNO() {
		String mobileNO = pro.getProperty("mobileno");
		return mobileNO;
	}

	public String getPin() {
		String pin = pro.getProperty("pinno");
		return pin;
	}

}
