package com.QVC.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;



public class LandingPage extends Base{


	public LandingPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;

	}


	public LandingPage clickLanguageDropDown() throws InterruptedException
	{
			Thread.sleep(2000);

			WebElement ele = locateElement("xpath", "//input[contains(@class,'btn btn-primary')]");

			click(ele);
			return this;
	}
	public LandingPage clickLanguage(String language)
	{
		WebElement ele = locateElement("xpath", "//*[text()='"+language+"']");

		click(ele);
		return this;
	}
	public LandingPage clickCountryDropDown() throws InterruptedException
	{
		WebElement ele = locateElement("xpath", "(//input[contains(@class,'btn btn-primary')])[2]");
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		click(ele);
		return this;
	}
	public LandingPage clickCountry(String Countryname)
	{
		WebElement ele = locateElement("xpath", "//*[text()='"+Countryname+"']");
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		click(ele);
		return this;

	}


	public HomePage checkLandingNotification() throws InterruptedException
	{
		click(locateElement("xpath","//button[@translate='OK']"));

		return new HomePage(driver,node,test);
	}

}
