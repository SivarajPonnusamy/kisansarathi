package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.LoginPage;


public class Login_Page extends Base_test{
	String mobileno ="8300923739";
	String pinno ="1609";
	
	@Test
	public static void loginPage() {
		LoginPage login = new LoginPage(driver);
		login.setmobileNO("8300923739");
		login.nextButton();
		login.setpinNo("1609");
		login.loginButton();
		
		
	}


}
