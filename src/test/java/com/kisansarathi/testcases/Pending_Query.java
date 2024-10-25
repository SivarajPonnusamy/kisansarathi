package com.kisansarathi.testcases;

import org.testng.annotations.Test;

import com.kisansarathi.base.Base_test;
import com.kisansarathi.pageobjects.PendingQuery;

public class Pending_Query extends Base_test{
	
	@Test
	public void pendingquery() {
		PendingQuery pq= new PendingQuery(driver);
		pq.managequery();
		pq.queriesTable();
		
	}

}
