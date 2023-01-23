package com.QVC.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;



public class ModifyPrimaryContactPage extends Base{
	public ModifyPrimaryContactPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public ModifyPrimaryContactPage enterPassPortNumber(String passPortNumber)
	{
		WebElement ele = locateElement("name", "passportNumber");
		clearAndType(ele, passPortNumber);
		return this;
	}
	public ModifyPrimaryContactPage enterVisaNumber(String visaNumber)
	{
		WebElement ele = locateElement("name", "visaNumber");
		clearAndType(ele, visaNumber);
		return this;
	}
	public ModifyPrimaryContactPage enterCaptcha() throws InterruptedException
	{
		WebElement ele = locateElement("name", "captcha");
		click(ele);
		Thread.sleep(6000);
		return this;
	}
	public ModifyPrimaryContactPage clickSubmitButton() throws InterruptedException
	{
		WebElement ele = locateElement("xpath", "//button[text()[normalize-space()='Submit']]");
		click(ele);

		return this;
	}



	public ModifyPrimaryContactPage enterSponsorMobileNumber(String mobileNumber) throws InterruptedException
	{
		//Thread.sleep(1000);
		WebElement ele = locateElement("id", "phone");
		//WebElement ele = driver.findElementById("phone");
		clearAndType(ele, mobileNumber);
		return this;
	}
	public ModifyPrimaryContactPage enterSponsorEmailId(String emailID)
	{
		WebElement ele = locateElement("id", "email");
		//WebElement ele = driver.findElementById("email");
		clearAndType(ele, emailID);
		return this;
	}
	public ModifyPrimaryContactPage enterApplicantEmailId(String secondEmailID)
	{
		WebElement ele = locateElement("id", "emailId");
		//WebElement ele = driver.findElementById("emailId");
		clearAndType(ele, secondEmailID);
		return this;
	}
	public ModifyPrimaryContactPage enterApplicantPhoneNumber(String mobileNumber)
	{
		WebElement ele = locateElement("id", "contactNumber");
		clearAndType(ele, mobileNumber);
		return this;
	}
	public ModifyPrimaryContactPage clickConfirm()
	{
		WebElement ele = locateElement("xpath", "//button[text()='Confirm']");
		click(ele);
		return this;
	}
	public ModifyPrimaryContactPage clickModifyOk()
	{
		WebElement ele = locateElement("xpath", "//button[text()='OK']");
		click(ele);
		return this;
}
}