package com.kisansarathi.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.LanguageMaster;
import com.kisansarathi.utilities.XLUtils;

public class Language_Master extends Base_test{
	int rownum;
	@Test(dataProvider = "languageMaster")
	public void languageMaster(String LanguageName) {
		LanguageMaster lm = new LanguageMaster(driver);
		lm.Navigationmenus();
		lm.addLanguage(LanguageName);
	}
	@DataProvider(name = "languageMaster")
	public String[][] getLanguagedata() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/languagemaster.xlsx";

		rownum = XLUtils.getRowCount(path, "languagemaster");
		int cellnum = XLUtils.getCellCount(path, "languagemaster", 1);
		System.out.println("rownum" + " " + rownum);
		System.out.println("cellnum" + " " + cellnum);
		String language[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				System.out.print(i + " ");
				System.out.println(j);
				System.out.println(language[i - 1][j] = XLUtils.getCellData(path, "languagemaster", i, j));
			}
		}
		return language;
	}
}
