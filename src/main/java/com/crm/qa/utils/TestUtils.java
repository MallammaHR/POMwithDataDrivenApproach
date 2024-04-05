package com.crm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtils extends TestBase
{
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=40;
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

	static Workbook workbook;
	static Sheet sheet;
	public static String TESTSHEET_DATA_PATH = "C:/Users/Mallukinnis/eclipse-workspace/RestAssuredAPIDemo/SeleniumCompleteAutomationFrameWorkDesign/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream fis=null;
		
		try 
		{
			 fis =new FileInputStream(TESTSHEET_DATA_PATH);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			 workbook=WorkbookFactory.create(fis);
		}
		catch (InvalidFormatException e) 
		{
			
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
}
