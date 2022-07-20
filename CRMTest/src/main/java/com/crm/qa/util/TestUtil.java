package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openxml4j.document.spreadsheet.ExcelDocument;

import com.crm.qa.base.TestBase;
import com.mongodb.MapReduceCommand.OutputType;

import net.bytebuddy.description.ModifierReviewable.OfAbstraction;*/

public class TestUtil extends TestBase {

	public TestUtil() throws FileNotFoundException {
		super();
		
	}

	public static long PAGE_LOAD_TIMEOUT=90;
	public static long IMPLICIT_WAIT=30;
	
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
		
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
	
	
	
}
