package com.QVC.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;



public class NotificationPage extends Base {
	public NotificationPage(RemoteWebDriver driver,ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public LandingPage closeNotification()
	{
		WebElement ele =locateElement("xpath","//button[text()='OK']");
		click(ele);
		return new LandingPage(driver,node,test);
	}

}
