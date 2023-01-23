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

//		boolean isNotificationPresent = checkNotification("xpath", "//div[@class='pull-left appt']//button");
//		if(isNotificationPresent == true)
//		{
//			WebElement eleNotificationText = locateElement("xpath", "(//div[@class='col-md-12']//modal-content)[1]");
//			String notificationText = fetchText(eleNotificationText);
//			System.out.println("Message "+notificationText+" is displayed. /n Cannot proceed further with appointment with this data");
//			reportStep(notificationText, "fail");
//			WebElement ele1 = locateElement("xpath", "//div[@class='pull-left appt']//button");
//			click(ele1);
//			throw new RuntimeException();
//		}
//		else
			reportStep("Submit button clicked successfully", "pass");
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
//	public ModifyPrimaryContactPage verifyAlertMessage()
//	{
//		WebElement ele = locateElement("xpath", "//div[@class='col-md-12']//modal-content");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-md-12']//modal-content")));
//		WebElement ele1 = locateElement("xpath", "//button[text()='OK']");
//		boolean trueFalse = verifyUIValue("Updated Successfully...", ele);
//		if(trueFalse == true)
//		{
//			System.out.println("Modifications updated successfully");
//		}
//		else
//		{
//			System.out.println("Could not update the modifications");
//		}
//		click(ele1);
//		return this;
//
//	}

//	public ManageAppointmentPage ApptStatus(String workbookName,String worksheetName, String visaNumber, String Bookingstatus) throws IOException
//	{
//
//		ReadExcel1.ApptStatus(workbookName, worksheetName, visaNumber, Bookingstatus);
//
//		return new ManageAppointmentPage(driver,node,test);
//	}


}
