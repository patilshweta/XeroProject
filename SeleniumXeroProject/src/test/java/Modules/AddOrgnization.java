package Modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.training.in.SeleniumXeroProject.ReusableMethods;

public class AddOrgnization extends ReusableMethods {
	public static void TC08A() throws IOException, InterruptedException 
	{
		StartReport("TC08A", false);
	    Initialisedriver();
		LaunchUrl("https://login.xero.com/");
		WebElement Email = findElement(By.id("email"), "EmailAdd");
		String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Login_Data");
		EnterText(Email, RecData[1][1],"EmailAdd");
	     WebElement password = findElement(By.id("password"), "password");
		EnterText(password, RecData[1][2],"password");
		 WebElement Login=findElement(By.id("submitButton"),"login");
		  ClickButton(Login,"login","Xero | Dashboard | Google" );
		  WebElement UN=driver.findElement(By.xpath("//div[@class='xrh-appbutton--body']"));
		  UN.click();
		  //Add Orgnisation
		  WebElement AddOrg=findElement(By.xpath("//a[@class='xrh-verticalmenuitem--body xrh-verticalmenuitem--body-blue']"),"AddOrg");
		  ClickButton(AddOrg,"AddOrg","My Xero | Add your organization" );
		   
		  /* WebElement Name=driver.findElement(By.id("text-1022-inputEl"));
		   Name.sendKeys("Amazon");
		    WebElement SelectDropdown=driver.findElement(By.xpath("//div[@id='ext-gen1096']"));
			Select dropdown=new Select(SelectDropdown);
			dropdown.selectByVisibleText("United States");
		   WebElement Arrow=driver.findElement(By.id("ext-gen1096"));
		   Arrow.click();
		   WebElement list=driver.findElement(By.xpath("//li[@class='x-boundlist-item x-boundlist-selected']"));
		   list.click();
		   System.out.println("text selected");
		   WebElement work=driver.findElement(By.id("industrysearchcombofield-1025-inputEl"));
		   work.sendKeys("Engineering Consulting Services");
		   System.out.println("text entered");
		   WebElement StartTrial=driver.findElement(By.id("simplebutton-1035"));
		   StartTrial.click();*/
			  EndReport();
	}
	public static void TC08B() throws IOException
	{
		StartReport("TC08B", false);
	    Initialisedriver();
		LaunchUrl("https://login.xero.com/");
		WebElement Email = findElement(By.id("email"), "EmailAdd");
		String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Login_Data");
		EnterText(Email, RecData[1][1],"EmailAdd");
	     WebElement password = findElement(By.id("password"), "password");
		EnterText(password, RecData[1][2],"password");
		 WebElement Login=findElement(By.id("submitButton"),"login");
		  ClickButton(Login,"login","Xero | Dashboard | Google" );
		  WebElement UN=driver.findElement(By.xpath("//div[@class='xrh-appbutton--body']"));
		  UN.click();
		  //Add Orgnisation
		  WebElement AddOrg=findElement(By.xpath("//a[@class='xrh-verticalmenuitem--body xrh-verticalmenuitem--body-blue']"),"AddOrg");
		  ClickButton(AddOrg,"AddOrg","My Xero | Add your organization" );
		 
		  EndReport();
	}

}
