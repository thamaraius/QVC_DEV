package com.QVC.pages;

import org.openqa.selenium.NoSuchElementException;
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
		try {
			WebElement ele = locateElement("xpath", "//span[text()='Download']");


			if (ele.isDisplayed()) {
				ele.click();
				Thread.sleep(2000);
				reportStep("Appointment letter downloaded successfully", "pass");
				driver.navigate().refresh();
			} else {

				WebElement circleup = locateElement("xpath", "//i[@class='fa fa-chevron-circle-up head-fix-icn pg']");
				circleup.click();
				ele.click();
				Thread.sleep(2000);
				reportStep("Appointment letter downloaded successfully", "pass");
				driver.navigate().refresh();
			}
		}


			catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			reportStep("Appointment letter is not downloaded", "fail");
			WebElement ele = locateElement("xpath", "(//i[@aria-hidden='true'])[1]");
			ele.click();
			driver.navigate().refresh();
		}
		return this;

	}


}
