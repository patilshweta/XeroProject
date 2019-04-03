package Modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.training.in.SeleniumXeroProject.ReusableMethods;

public class UploadProPic extends ReusableMethods{
	public static void TC06A() throws IOException 
	{
		StartReport("TC06A", false);
	    Initialisedriver();
		LaunchUrl("https://login.xero.com/");
		WebElement Email = findElement(By.id("email"), "EmailAdd");
		String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Login_Data");
		EnterText(Email, RecData[1][1],"EmailAdd");
	     WebElement password = findElement(By.id("password"), "password");
		EnterText(password, RecData[1][2],"password");
		 WebElement Login=findElement(By.id("submitButton"),"login");
		  ClickButton(Login,"login","Xero | Dashboard | Google" );
		  //profilepic upload
		  waitstatement();
		  WebElement UN=driver.findElement(By.xpath("//button[@title='test automation']"));
		  UN.click();
		  WebElement editprofile=findElement(By.xpath("//li[@class='xrh-addon xrh-addon-lastvisible']//li[1]//a[1]"),"editprofile");
		  ClickButton(editprofile,"editprofile","My Xero | Profile Settings" );
		  //upload image
		  WebElement upload=driver.findElement(By.xpath("//div[@id='button-1043']"));
		  upload.click();
		  WebElement browse=driver.findElement(By.xpath("//input[@name='file']"));
		  browse.sendKeys("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\picture.jpg");
		  waitstatement();
		  WebElement Upload1=driver.findElement(By.xpath("//div[@class='x-btn blue x-exclude x-unselectable x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']"));
		  Upload1.click();
		  
		  
		 if(Upload1.isDisplayed())
		 {
			 Logger.log(LogStatus.PASS,"Profile Picture Updated Successfully");
		 }
		 else
		 {
			 Logger.log(LogStatus.FAIL,"Profile Picture not Updated Successfully");
		 }
		  EndReport();
		  
		  
		  
	}

}
