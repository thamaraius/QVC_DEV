package com.QVC.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;


public class AppointmentDetailsPage extends Base {

	public String workbookName;
	public String worksheetName;
	public String worksheetName1;
	public String Path = "";
	public String SheetName = "";

	public AppointmentDetailsPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;

	}


	public AppointmentDetailsPage DownloadApptletter() throws InterruptedException {
		 {
			WebElement ele = locateElement("xpath", "//span[text()='Download']");
			ele.click();
		return new AppointmentDetailsPage(driver,node,test);

	}
}
}