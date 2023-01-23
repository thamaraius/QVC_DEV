package com.QVC.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;

public class Reprint_version2 extends Base{

	public Reprint_version2(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}
	public ManageAppointmentPage clickManageAppointmentLink() throws InterruptedException {
	WebElement ele = locateElement("xpath", "(//*[text()='Manage ']");
	click(ele);
	return new ManageAppointmentPage(driver,node,test);
}
}









