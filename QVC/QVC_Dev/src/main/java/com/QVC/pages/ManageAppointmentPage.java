package com.QVC.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;



public class ManageAppointmentPage extends Base{
	public ManageAppointmentPage(RemoteWebDriver driver,ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;

	}

	public ModifyPrimaryContactPage clickModifyButton()
	{
		WebElement ele = locateElement("xpath", "//button[text()='Modify']");
		click(ele);
		return new ModifyPrimaryContactPage(driver,node,test);
	}

	public ModifySchedulePage clickRescheduleButton()
	{
		WebElement ele = locateElement("xpath", "//button[text()='Reschedule']");
		click(ele);
		return new ModifySchedulePage(driver,node,test);
	}


	public ManageAppointmentPage clickWaitListButton()
	{
		WebElement ele = locateElement("xpath", "//button[text()='Waitlist']");
		click(ele);
		return this;
	}
	public ReprintPage clickReprintButton()
	{
		WebElement ele = locateElement("xpath", "//button[text()='Reprint']");
		click(ele);
		return new ReprintPage(driver, node, test);
	}


}
