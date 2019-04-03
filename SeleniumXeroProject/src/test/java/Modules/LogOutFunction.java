package Modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.training.in.SeleniumXeroProject.ReusableMethods;

public class LogOutFunction extends ReusableMethods {
	public static void TC04A() throws IOException
	{
		StartReport("TC04A", false);
	    Initialisedriver();
		LaunchUrl("https://login.xero.com/");
		WebElement Email = findElement(By.id("email"), "EmailAdd");
		String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Login_Data");
		EnterText(Email, RecData[1][1],"EmailAdd");
	     WebElement password = findElement(By.id("password"), "password");
		EnterText(password, RecData[1][2],"password");
		 WebElement Login=findElement(By.id("submitButton"),"login");
		  ClickButton(Login,"login","Xero | Dashboard | Google" );
		  //Logout
		  WebElement UN=driver.findElement(By.xpath("//img[@class='xrh-avatar']"));
		  UN.click();
		  WebElement Logout=findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-addon--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionright']//a[@class='xrh-verticalmenuitem--body'][contains(text(),'Log out')]")," Logout");
		  ClickButton( Logout," Logout","Login | Xero Accounting Software" );
		  WebElement email=driver.findElement(By.id("email"));
		  String value=email.getAttribute("value");
		  System.out.println(value);
		  if(value.equals("2testautomation@gmail.com"))
		  {
			  Logger.log(LogStatus.PASS,"Email address displayed");
		  }
		  else
		  {
			  Logger.log(LogStatus.FAIL,"Email address NOT displayed");
		  }
		 
		 EndReport();
	}
	
}
