package Modules;

import java.io.IOException;
import java.io.Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.training.in.SeleniumXeroProject.ReusableMethods;

public class LoginPage extends ReusableMethods{

	public static void TC01A() throws IOException {
		StartReport("TC01A", true);
		Initialisedriver();
		LaunchUrl("https://login.xero.com/");
		WebElement Email = findElement(By.id("email"), "EmailAdd");
		//waitstatement();
		String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Login_Data");
		//String RecData[][]=readExcelData("C:\\Users\\Administrator\\Desktop\\XeroWebsiteTestData.xls","Login_Data");
		EnterText(Email, RecData[1][1],"EmailAdd");
	     WebElement password = findElement(By.id("password"), "password");
		EnterText(password, RecData[1][2],"password");
		 WebElement Login=findElement(By.id("submitButton"),"login");
		  ClickButton(Login,"login","Xero | Dashboard | Google" );
	     EndReport();

	}
public static void TC01B() throws IOException {
		
		StartReport("TC01B", false);
		Initialisedriver();
		LaunchUrl("https://login.xero.com/");
		WebElement Email = findElement(By.id("email"), "EmailAdd");
		String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Login_Data");
		EnterText(Email, RecData[2][1],"EmailAdd");
	     WebElement password = findElement(By.id("password"), "password");
		EnterText(password, RecData[2][2],"password");
		 WebElement Login=findElement(By.id("submitButton"),"login");
		 System.out.println(driver.getTitle());
		  ClickButton(Login,"login","Login | Xero Accounting Software" );
		  String actual_msg=driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]")).getText();
	       if(actual_msg.equals("Your email or password is incorrect"))
	        {
				Logger.log(LogStatus.PASS,"Error message -Your Email or Password is incorrect- is displayed");
			}
			else
			{
				Logger.log(LogStatus.FAIL,"Error Message not Displayed");
			}
	     EndReport();

	}
public static void TC01C() throws IOException {
	
	
	StartReport("TC01C", false);
	Initialisedriver();
	LaunchUrl("https://login.xero.com/");
	WebElement Email = findElement(By.id("email"), "EmailAdd");
	String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Login_Data");
	EnterText(Email, RecData[3][1],"EmailAdd");
     WebElement password = findElement(By.id("password"), "password");
	EnterText(password, RecData[3][2],"password");
	 WebElement Login=findElement(By.id("submitButton"),"login");
	 System.out.println(driver.getTitle());
	  ClickButton(Login,"login","Login | Xero Accounting Software" );
	  String actual_msg=driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]")).getText();
       if(actual_msg.equals("Your email or password is incorrect"))
        {
			Logger.log(LogStatus.PASS,"Error message -Your Email or Password is incorrect- is displayed");
		}
		else
		{
			Logger.log(LogStatus.FAIL,"Error Message not Displayed");
		}
     EndReport();

}

public static void TC01D() throws IOException {
	
	StartReport("TC01D", false);
	Initialisedriver();
	LaunchUrl("https://login.xero.com/");
	if(driver.getTitle().equals("Login | Xero Accounting Software"))
	{
		Logger.log(LogStatus.PASS,"Xero application page is displayed");
	}
	else
	{
		Logger.log(LogStatus.FAIL,"Xero application page is displayed could not displayed");
	}
	WebElement FP= findElement(By.xpath("//a[@class='forgot-password-advert']"), "FP");
	ClickButton(FP,"forgotpassword","Forgotten Password" );
	WebElement UserName = findElement(By.id("UserName"), "UserName");
	String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Login_Data");
	EnterText(UserName, RecData[4][1],"UserName");
     
	 WebElement Continue=findElement(By.xpath("//span[@class='text']"),"Continue");
	String titleee= driver.getTitle();
	System.out.println(titleee);
	ClickButton(Continue,"Continue","Forgotten Password" );
	
	 // WebElement text=findElement(By.xpath("//p[contains(text(),'A link to reset your password has been sent to:')]"),"text");
	  String texts=driver.getCurrentUrl();
	  System.out.println(texts);
	 
	  
      if(driver.getCurrentUrl().equals("https://login.xero.com/ForgottenPassword/SendLink"))
        {
			Logger.log(LogStatus.PASS,"Password reset message page is displayed.A link to reset your password has been sent to An email associated with the <username> account is sent.");
		}
		else
		{
			Logger.log(LogStatus.FAIL,"Password reset message page is could not displayed ");
		}
     EndReport();

}


}
