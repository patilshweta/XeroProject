package com.training.in.SeleniumXeroProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethods {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest Logger;
	
	public static void StartReport(String testcase, boolean replaceExisting  )
	{
		extent =new ExtentReports(System.getProperty("user.dir")+"/test-output/XeroExtentReport.html",replaceExisting);
		Logger=extent.startTest(testcase);
	}
	
	public static void Initialisedriver()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		driver=(WebDriver) new ChromeDriver();
	}
	public static void LaunchUrl(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		if(driver.getCurrentUrl().equals(url))
		{
			Logger.log(LogStatus.PASS,"Xero application page is displayed");
		}
		else
		{
			Logger.log(LogStatus.FAIL,"Xero application page is displayed could not displayed");
		}
		
		
	}
	public static void waitstatement()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void Initialisepath()
	{
		extent =new ExtentReports(System.getProperty("user.dir")+"/test-output/LoginPage.html",true);
	}
	public static void EnterText(WebElement Obj,String TextValue,String ObjName)
	{
		if(Obj==null)
			return;

			
		if (Obj.isDisplayed()) {
			Obj.sendKeys(TextValue);
			System.out.println("Pass: " + TextValue + " entered in " + ObjName);
			
			if(Obj.getAttribute("value").equals(TextValue))
			{
				Logger.log(LogStatus.PASS,ObjName+" is displayed in" +ObjName+ "field");
			}
			
			else
			{
				Logger.log(LogStatus.FAIL,ObjName+" is not displayed in" +ObjName+ "field");
			}
			
			
		} else 
		{
			System.out.println("Fail: " + ObjName+ " could not be found");
			
			
		}
		
	}
	/*Name                     :findElement
	 * Arguments            :location:location of the object
	 *                             :objName:Name of the object   
	 * Created Date         :30Mar2019
	 * Last Modified        :30Mar2019
	 */
	public static WebElement findElement(By location,String objName)
	{
		WebElement obj= null;
		try {
			obj=driver.findElement(location);
			System.out.println("Pass"+objName+"  Found on the page");
		}
		catch(NoSuchElementException errMessage) 
		{
			System.out.println("Fail"+objName+"Could not be found on the page");
		}
		return obj;
	
	}
	/*Name                     :ClickButton
	 * Arguments            :obj:webelement
	 *                             :objName:Name of the object   
	 * Created Date         :3Mar2019
	 * Last Modified        :3Mar2019
	 */
	public static void ClickButton(WebElement obj,String ObjName, String title)
	{

		if(obj==null)
			return;
		if(obj.isDisplayed())
		{
			 obj.click();
		      System.out.println("Pass:" +ObjName +" is clicked");
		    
		     if(driver.getTitle().equals(title))
		        {
					Logger.log(LogStatus.PASS,ObjName +" is clicked Successfully");
				}
				else
				{
					Logger.log(LogStatus.FAIL,"Login Failed");
				}
		      
		}
		else 
		{
			System.out.println("Fail:Checkbox " +ObjName +"Could not be clicked");
		}
	}
		
	public static void SelectCheckbox(WebElement obj,String ObjName )
	{

		if(obj==null)
			return;
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("Pass:Checkbox " +ObjName +"is selected");
			Logger.log(LogStatus.PASS,ObjName +" is clicked Successfully");
			}
		else 
		{
			System.out.println("Fail:Checkbox " +ObjName +"Could not be found");
			Logger.log(LogStatus.FAIL,"Checkbox not clicked");
		}
	}
	public static Boolean isAlive(WebDriver driver) {
	    try {
	        driver.getCurrentUrl();//or driver.getTitle();
	        return true;
	    } catch (Exception ex) {
	        return false;
	    }
	    }
	public static String[][] readExcelData(String DatatablePath,String SheetName) throws IOException{

		File xlfile=new File(DatatablePath);

		FileInputStream xldoc=new FileInputStream(xlfile);

		HSSFWorkbook wb=new HSSFWorkbook(xldoc);

		/*step4. Access the sheet*/
		HSSFSheet sheet=wb.getSheet(SheetName);
		//String val;
		

		int RowCount=sheet.getLastRowNum()+1;
		int ColCount=sheet.getRow(0).getLastCellNum();
		String [][] xldata=new String[RowCount][ColCount];

		for(int i=0;i<RowCount;i++)
		{
			Row row = sheet.getRow(i);
			
			for(int j=0;j<ColCount;j++)
			{
				/*
				Cell cell = row.getCell(j);
				//System.out.println("I =" +i+"J =" +j);
				switch (cell.getCellTypeEnum()) {
	            case STRING:
	                System.out.print(cell.getStringCellValue() + " STRING");
	                break;

	            case NUMERIC:
	                System.out.print(cell.getNumericCellValue() + " INTEGER ");
	                break;

	            }*/
				
				xldata[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}


		return xldata;
	}
	
	
		public static void EndReport()
		{
			extent.endTest(Logger);
			extent.flush(); 
			//driver.close();
			 System.out.println("End");
			 driver.close();
		}


}
