package com.training.in.SeleniumXeroProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Modules.AddOrgnization;
import Modules.AllTabs;
import Modules.Billing;
import Modules.LogOutFunction;
import Modules.LoginPage;
import Modules.UploadProPic;
import Modules.XDCSignUp;

//public class DriverEngine extends LoginPage 
public class DriverEngine
{	
	public static  void main(String[] args) throws IOException, InterruptedException 
	{		
		LoginPage.TC01A();
		LoginPage.TC01B();
		LoginPage.TC01C();
		LoginPage.TC01D();
		XDCSignUp.TC02A();
		XDCSignUp.TC02C();
		XDCSignUp.TC02D();
		XDCSignUp.TC02E();
		AllTabs.TC03A();
		LogOutFunction.TC04A();
		UploadProPic.TC06A();
		AddOrgnization.TC08A();
		AddOrgnization.TC08B();
		Billing.TC10A();
	}

}

