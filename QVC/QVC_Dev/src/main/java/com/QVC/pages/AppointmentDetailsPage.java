package com.QVC.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;


public class AppointmentDetailsPage extends Base {


	public AppointmentDetailsPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;

	}


	public AppointmentDetailsPage DownloadApptletter() throws InterruptedException {
		 {
			 JavascriptExecutor js = driver;
				WebElement ele = locateElement("xpath", "//span[text()='Download']");
				  js.executeScript("arguments[0].click();", ele);
			 //  ele.click();

		return this;

	}
}
}