package com.QVC.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;

public class PrimaryContactPage extends Base {


	public PrimaryContactPage(RemoteWebDriver driver,ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public PrimaryContactPage clickOK(){

		click(locateElement("xpath","//button[text()='Ok']"));
		return this;


	}

	public PrimaryContactPage enterSponsorMobileNumber(String mobileNumber) throws InterruptedException
	{
		//Thread.sleep(1000);
		WebElement ele = locateElement("id", "phone");
		//WebElement ele = driver.findElementById("phone");
		clearAndType(ele, mobileNumber);
		return this;
	}
	public PrimaryContactPage enterSponsorEmailId(String emailID)
	{
		WebElement ele = locateElement("id", "email");
		//WebElement ele = driver.findElementById("email");
		clearAndType(ele, emailID);
		return this;
	}
	public PrimaryContactPage enterApplicantEmailId(String secondEmailID)
	{
		WebElement ele = locateElement("id", "emailId");
		//WebElement ele = driver.findElementById("emailId");
		clearAndType(ele, secondEmailID);
		return this;
	}
	public PrimaryContactPage enterApplicantPhoneNumber(String mobileNumber)
	{
		WebElement ele = locateElement("id", "contactNumber");
		clearAndType(ele, mobileNumber);
		return this;
	}
	public SchedulePage clickConfirmationButton()
	{
	//	System.out.println("Applicant details page final button is going to click1: 1");
		WebElement ele = locateElement("xpath", "//button[@translate='schedule.confirm_applicant']");
	//	System.out.println("Applicant details page final button is going to click1: 2");
		click(ele);
	//	System.out.println("Applicant details page final button is clicked");
		return new SchedulePage(driver,node,test);
	}
}
