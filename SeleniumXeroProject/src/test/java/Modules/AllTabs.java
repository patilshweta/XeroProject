package Modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.training.in.SeleniumXeroProject.ReusableMethods;

public class AllTabs  extends ReusableMethods {

	
		public static void TC03A() throws IOException
		{
			StartReport("TC03A", false);
		    Initialisedriver();
			LaunchUrl("https://login.xero.com/");
			WebElement Email = findElement(By.id("email"), "EmailAdd");
			String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Login_Data");
			EnterText(Email, RecData[1][1],"EmailAdd");
		     WebElement password = findElement(By.id("password"), "password");
			EnterText(password, RecData[1][2],"password");
			 WebElement Login=findElement(By.id("submitButton"),"login");
			  ClickButton(Login,"login","Xero | Dashboard | Google" );
			  WebElement dashboard=findElement(By.xpath("//a[@class='xrh-focusable xrh-tab--body xrh-tab--body-is-selected']"),"dashboard");
			  ClickButton(dashboard,"dashboard","Xero | Dashboard | Google" );
			
			  //accounting
			  WebElement accounting=findElement(By.xpath("//button[contains(text(),'Accounting')]"),"accounting");
			  ClickButton(accounting,"accounting","Xero | Dashboard | Google" );
			  WebElement Dropdown=driver.findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-nav--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionleft']"));
			  if(Dropdown.isDisplayed())
			  {
				  Logger.log(LogStatus.PASS,"account  drop down page displayed");
			  }
			  else
			  {
				  Logger.log(LogStatus.FAIL,"account  drop down page could not displayed");
			  }
			  //Reports
			  
			  WebElement report=findElement(By.xpath("//a[contains(text(),'Reports')]"),"report");
			  ClickButton(report,"report","Xero | Reports | Google" );
			  waitstatement();
			  //Contacts
			  WebElement Contacts=findElement(By.xpath("//button[contains(text(),'Contacts')]"),"Contacts");
			  ClickButton(Contacts,"Contacts","Xero | Reports | Google" );
			  WebElement Dropdown1=driver.findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-nav--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionleft']//ol[@class='xrh-verticalmenu']"));
			  if(Dropdown1.isDisplayed())
			  {
				  Logger.log(LogStatus.PASS,"contact drop down page displayed");
			  }
			  else
			  {
				  Logger.log(LogStatus.FAIL,"contact drop down page could not displayed");
			  }
			  //Setting
			  WebElement UserName=driver.findElement(By.xpath("//div[@class='xrh-appbutton--body']"));
			  UserName.click();
			  WebElement setting=findElement(By.xpath("//a[contains(text(),'Settings')]"),"setting");
			  ClickButton(setting,"setting","Xero | | Google" );
			  //Create New
			  WebElement CreateNew=driver.findElement(By.xpath("//button[@title='Create new']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
			  CreateNew.click();
			  WebElement Dropdown2=driver.findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']"));
			  if(Dropdown2.isDisplayed())
			  {
				  Logger.log(LogStatus.PASS,"CreateNew down page displayed");
			  }
			  else
			  {
				  Logger.log(LogStatus.FAIL,"CreateNew drop down page could not displayed");
			  }
			  //Filess
			  WebElement Google=driver.findElement(By.xpath("//div[@class='xrh-appbutton--body']"));
			  Google.click();
			  WebElement Files=findElement(By.xpath("//a[contains(text(),'Files')]"),"Files");
			  ClickButton(Files,"Files","Xero | Files | Google" );
			  //Notification
			  WebElement Notification=driver.findElement(By.xpath("//button[@title='Notifications']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
			  Notification.click();
			  
			  if(Notification.isDisplayed())
			  {
				  Logger.log(LogStatus.PASS,"Notification page displayed");
			  }
			  else
			  {
				  Logger.log(LogStatus.FAIL,"Notification page could not displayed");
			  }
			  //Search
			  WebElement Search=driver.findElement(By.xpath("//button[@title='Search']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
			  Search.click();
			  waitstatement();
			   //WebElement SeachBox=driver.findElement(By.xpath("//input[@id='queryInput']"));
			  if(Search.isDisplayed())
			  {
				  Logger.log(LogStatus.PASS,"SeachBox displayed");
			  }
			  else
			  {
				  Logger.log(LogStatus.FAIL,"SeachBox could not displayed");
			  }
			  //help
			  WebElement help=driver.findElement(By.xpath("//button[@title='Help']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
			  help.click();
			  WebElement helpmenu=driver.findElement(By.xpath("//input[@id='menu_help']"));
			  if(helpmenu.isDisplayed())
			  {
				  Logger.log(LogStatus.PASS,"helpmenu page displayed");
			  }
			  else
			  {
				  Logger.log(LogStatus.FAIL,"helpmenu page could not displayed");
			  }
			  
			  
			  
			   EndReport();
			 


	}

}
