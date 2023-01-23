package com.QVC.testcases;


import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.QVC.common.ProjectSpecificMethod;
import com.QVC.pages.HomePage;



public class TC_002_Reprint extends ProjectSpecificMethod{

	@BeforeTest
	public void setExcelValues()
	{
		testCaseName = "TC001_Schedule";
		testDescription = "Schedule";
		nodes = "Leads";
		authors = "Thamarai";
		category = "Smoke";
		dataSheetName = "TestData";
		sheetName="SmokeTestData";
	}

	@Test(dataProvider="fetchData")
public void normalAppointmentFlow(String language,String Countryname,String passportNumber,String visaNumber,String sponsorPhNo,String sponsorEmail,String emailID,String center,String category,String date,String timeSlot ) throws InterruptedException, IOException
	{

			new HomePage(driver,node,test)
			.clickManageAppointmentLink()
			.clickReprintButton()
			.enterPassPortNumber(passportNumber)
			.enterVisaNumber(visaNumber)
			.enterCaptcha()
			.clickSubmitButton()
			//.verifyHeader()
	    	.DownloadApptletter();

		}
		}


