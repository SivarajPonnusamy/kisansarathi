package com.kisansarathi.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.kisansarathi.base.Base_test;

public class CommonFunc extends Base_test{
	public void scrollDown(WebElement element) {
		 System.out.println("Siva test123...");
	        
	        // Debug statement to check if 'driver' is null
	        if (driver == null) {
	            System.out.println("Error: 'driver' is null in CommonFunc!");
	        } else {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            // Scroll to the specific element
	            js.executeScript("arguments[0].scrollIntoView(true);", element);
	        }
	    }
		
		

}
