package Modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.training.in.SeleniumXeroProject.ReusableMethods;

public class Billing extends ReusableMethods{

	
		public static void TC10A() throws IOException
		{
			StartReport("TC10A", false);
		    Initialisedriver();
			LaunchUrl("https://login.xero.com/");
			WebElement Email = findElement(By.id("email"), "EmailAdd");
			String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Login_Data");
			EnterText(Email, RecData[1][1],"EmailAdd");
		     WebElement password = findElement(By.id("password"), "password");
			EnterText(password, RecData[1][2],"password");
			 WebElement Login=findElement(By.id("submitButton"),"login");
			  ClickButton(Login,"login","Xero | Dashboard | Google" );
			  WebElement Business=findElement(By.xpath("//button[contains(text(),'Business')]"),"Business");
			  ClickButton(Business,"Business","Xero | Dashboard | Google" );
			  WebElement BilToPay=driver.findElement(By.xpath("//a[contains(text(),'Bills to pay')]"));
			  BilToPay.click();
			  if(driver.getTitle().equals("Xero | Bills | Google"))
			  {
				  Logger.log(LogStatus.PASS," information for all bills are displayed on page");
			  }
			  else
			  {
				  Logger.log(LogStatus.FAIL,"information for all bills could not displayed on page");
			  }
			  WebElement Repeating=driver.findElement(By.xpath("//a[@href='/AccountsPayable/SearchRepeating.aspx']"));
			  Repeating.click();
			  if(driver.getTitle().equals("Xero | Bills | Google"))
			  {
				  Logger.log(LogStatus.PASS," information for repeating bills are displayed on page");
			  }
			  else
			  {
				  Logger.log(LogStatus.FAIL,"information for repeating bills could not displayed on page");
			  }
			  WebElement Paid=driver.findElement(By.xpath("//a[contains(text(),'Paid')]"));
			  Paid.click();
			  if(driver.getTitle().equals("Xero | Bills | Google"))
			  {
				  Logger.log(LogStatus.PASS," information for paid bills are displayed on page");
			  }
			  else
			  {
				  Logger.log(LogStatus.FAIL,"information for paid bills could not displayed on page");
			  }
			  EndReport();
		}
		

	

}
