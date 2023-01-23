package com.QVC.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;



public class HomePage extends Base{
	public HomePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public ApplicantDetailsPage clickBookAppointment() throws InterruptedException
	{

	click(locateElement("xpath","(//a[@class='link-menu'])[2]"));

		return new ApplicantDetailsPage(driver,node,test);

	}


	public ManageAppointmentPage clickManageAppointmentLink() throws InterruptedException {
	Thread.sleep(3000);

	  JavascriptExecutor js = driver;
	  js.executeScript("window.scrollBy(0,200)");

	WebElement ele = locateElement("xpath", "((//a[@href='/manage'])[2])");
	/* WebElement ele = locateElement("class",("//a[@class='link-menu'])[3]")); */
	ele.click();
	  Thread.sleep(3000);
	  return new ManageAppointmentPage(driver,node,test); }

	public LandingPage clickLanguageDropDown() throws InterruptedException
	{
			Thread.sleep(2000);

			WebElement ele = locateElement("xpath", "//input[contains(@class,'btn btn-primary')]");

			click(ele);
			return new LandingPage(driver,node,test);
	}

	}


