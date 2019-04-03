package Modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.training.in.SeleniumXeroProject.ReusableMethods;

public class XDCSignUp extends ReusableMethods {

public static void TC02A() throws IOException, InterruptedException {
		StartReport("TC02A", false);
	    Initialisedriver();
		LaunchUrl("https://www.xero.com/us/");
		 WebElement FreeTrial=findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),"FreeTrial");
		 ClickButton(FreeTrial,"FreeTrial","Signup for Xero - Free Trial | Xero US" );
		 WebElement fstName = findElement(By.xpath("//input[@name='FirstName']"), "fstName");
		 String RecData[][]=readExcelData("C:\\Users\\Administrator\\eclipse-workspace\\SeleniumXeroProject\\src\\test\\java\\com\\testdata\\XeroWebsiteTestData.xls","Sign_Up");
			EnterText(fstName, RecData[1][1],"fstName");
			WebElement lstName = findElement(By.xpath("//input[@name='LastName']"), "lstName");
			EnterText(lstName, RecData[1][2],"lstName");
			WebElement EmlAdd= findElement(By.xpath("//input[@name='EmailAddress']"), "EmlAdd");
			EnterText(EmlAdd, RecData[1][3],"EmlAdd");
			WebElement Phone= findElement(By.xpath("//input[@name='PhoneNumber']"), "Phone");
			EnterText(Phone, RecData[1][4],"Phone");
			WebElement SelectDropdown=driver.findElement(By.name("LocationCode"));
			Select dropdown=new Select(SelectDropdown);
			//dropdown.selectByVisibleText(RecData[1][5]);
			dropdown.selectByVisibleText("United States");
			System.out.println("choosed option selected");
			//Captcha selected code
			/*WebElement capchaIframe = driver.findElement(By.xpath("//iframe[@title='Adobe ID Syncing iFrame']"));
		    driver.switchTo().frame(capchaIframe);
		     System.out.println("switched on frame");
		       /*WebElement Chkbox=findElement(By.xpath("//body[@class='xero is-live-mode']"), "Chkbox");
		       driver.findElement(By.className("recaptcha-checkbox")).click();
		       //SelectCheckbox(Chkbox,"chkbox");
		       
		       //IWebElement frame = driver.FindElements(By.XPath("//iframe[contains(@src, 'recaptcha')]"))[0];
		       //driver.SwitchTo().Frame(frame);

		       IWebElement checkbox = Driver.Browser.FindElement(By.CssSelector("div.recaptcha-checkbox-checkmark"));
		       checkbox.click();*/
			//Thread.sleep(60000);
			WebElement Chkbox=findElement(By.xpath("//input[@value='true']"), "Chkbox");
			SelectCheckbox(Chkbox,"chkbox");
			//
			//WebElement GetStart=findElement(By.xpath("//button[@type='submit']"),"FreeTrial");
			//WebElement GetStart=driver.findElement(By.xpath("//button[@type='submit']"));
			//GetStart.click();
			//String titli=driver.getTitle();
			//System.out.println(titli);
			 //ClickButton(GetStart,"GetStart","Signup for Xero - Free Trial | Xero US" );*/
		     EndReport();

	}
public static void TC02C()
{
	StartReport("TC02C", false);
    Initialisedriver();
	LaunchUrl("https://www.xero.com/us/");
	WebElement FreeTrial=findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),"FreeTrial");
	 ClickButton(FreeTrial,"FreeTrial","Signup for Xero - Free Trial | Xero US" );
	 waitstatement();
	 WebElement terms=findElement(By.xpath("//a[contains(text(),'terms of use')]")," terms");
	 ClickButton( terms," terms","Signup for Xero - Free Trial | Xero US" );
	  Initialisedriver();
	 LaunchUrl("https://www.xero.com/us/");
	 waitstatement();
	WebElement FreeTriali=findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),"FreeTriali");
	 ClickButton(FreeTriali,"FreeTriali","Signup for Xero - Free Trial | Xero US" );
	WebElement policy=findElement(By.xpath("//a[contains(text(),'privacy notice')]"),"policy");
	 ClickButton(policy,"policy","Signup for Xero - Free Trial | Xero US" );
	 EndReport();
	 }
public static void TC02D()
{
	StartReport("TC02D", false);
    Initialisedriver();
	LaunchUrl("https://www.xero.com/us/");
	WebElement FreeTrial=findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),"FreeTrial");
	 ClickButton(FreeTrial,"FreeTrial","Signup for Xero - Free Trial | Xero US" );
	 waitstatement();
	 WebElement offer=findElement(By.xpath("//a[contains(text(),'terms of use')]"),"offer");
	 ClickButton(offer," offer","Signup for Xero - Free Trial | Xero US" );
	 EndReport();
	 }
public static void TC02E()
{
	StartReport("TC02E", false);
    Initialisedriver();
	LaunchUrl("https://www.xero.com/us/");
	WebElement FreeTrial=findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"),"FreeTrial");
	 ClickButton(FreeTrial,"FreeTrial","Signup for Xero - Free Trial | Xero US" );
	 waitstatement();
	 
	 WebElement BKlink=findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"),"BKlink");
	 ClickButton(BKlink," BKlink","Sign up for the Xero Partner Program | Xero US" );
	 EndReport();
	 }

}
