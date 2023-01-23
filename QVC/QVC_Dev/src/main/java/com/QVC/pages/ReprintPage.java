package com.QVC.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;


public class ReprintPage extends Base {

	public ReprintPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}
	public ReprintPage enterPassPortNumber(String passPortNumber)
	{
		WebElement ele = locateElement("name", "passportNumber");
		clearAndType(ele, passPortNumber);
		return this;
	}
	public ReprintPage enterVisaNumber(String visaNumber)
	{
		WebElement ele = locateElement("name", "visaNumber");
		clearAndType(ele, visaNumber);
		return this;
	}
	public ReprintPage enterCaptcha() throws InterruptedException
	{
		WebElement ele = locateElement("name", "captcha");
		click(ele);
		Thread.sleep(5000);
		return this;
	}
	public AppointmentDetailsPage clickSubmitButton()
	{
		WebElement ele = locateElement("xpath", "//button[text()[normalize-space()='Submit']]");
		click(ele);
		return new AppointmentDetailsPage(driver,node,test);
	}
}
