package com.QVC.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.QVC.common.ProjectSpecificMethod;
import com.QVC.pages.HomePage;



public class TC_003_ModifyDetails extends ProjectSpecificMethod {

	@BeforeTest
	public void setExcelValues()
	{
		testCaseName = "TC_003_ModifyDetails";
		testDescription = "Modify";
		nodes = "Leads";
		authors = "Thamarai";
		category = "Smoke";
		dataSheetName = "TestData";
		sheetName="SmokeTestData";
	}


	@Test(dataProvider="fetchData")
public void normalAppointmentFlow(String language,String Countryname,String passportNumber,String visaNumber,String sponsorPhNo,String sponsorEmail,String emailID,String center,String category,String date,String timeSlot,String Reschedule_date,String Reschedule_Time ) throws InterruptedException, IOException
	{

			new HomePage(driver,node,test)
			.clickLanguageDropDown()
			.clickLanguage( language)
			.clickCountryDropDown()
			.clickCountry( Countryname)
			.checkLandingNotification()
			.clickManageAppointmentLink()
			.clickModifyButton()
			.enterPassPortNumber(passportNumber)
			.enterVisaNumber(visaNumber)
			.enterCaptcha()
			.clickSubmitButton()
			.enterSponsorMobileNumber(sponsorPhNo)
			.enterSponsorEmailId(sponsorEmail)
			.enterApplicantEmailId(emailID)
			.enterApplicantPhoneNumber(sponsorPhNo)
			.clickConfirm()
			.clickModifyOk();

			}

}

