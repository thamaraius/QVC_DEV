package com.QVC.pages;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;

public class ApplicantDetailsPage extends Base {

	JavascriptExecutor js = driver;

	public ApplicantDetailsPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public ApplicantDetailsPage clickHide()
	{
		//WebElement ele = locateElement("xpath", "//i[@class='fa fa-chevron-circle-up head-fix-icn pg fa-chevron-circle-down ag']");//
		//WebElement ele = driver.findElementByXPath("//i[@class='fa fa-chevron-circle-up head-fix-icn pg fa-chevron-circle-down ag']");
		WebElement ele= driver.findElement((By.id("+sponsorPhNo+")));
		click(ele);
		return this;
	}

	public ApplicantDetailsPage clickIndividualAppointment() throws InterruptedException
	{
		//Thread.sleep(2000);
		WebElement ele = locateElement("xpath", "//button[text()='Individual']");
		//WebElement ele = driver.findElementByXPath("//button[text()='Individual']");
		click(ele);
		System.out.println("Individual clicked");
		return this;
	}
	public ApplicantDetailsPage enterPassportNumber() throws InterruptedException, IOException
	{
		// To Generate random number this is used
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		WebElement ele = locateElement("xpath", "(//label[@for='usr']/following-sibling::input)[1]");
		ele.sendKeys(randomInt+ "NWCIND");
		String PassportNumber=(randomInt+"NWCIND");
		 writeExcel("./data/TestData.xlsx", 0, PassportNumber,2);

		return this;
	}
	public ApplicantDetailsPage enterVisaNumber() throws InterruptedException, IOException
	{
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100000);
		WebElement ele = locateElement("Xpath", "(//label[@for='usr']/following-sibling::input)[2]");
		String strI = Integer.toString(randomInt);
		ele.sendKeys(strI);
		writeExcel("./data/TestData.xlsx", 0, strI,3);
		return this;
	}
	public ApplicantDetailsPage enterCAPTCHA() throws InterruptedException
	{
		WebElement ele = locateElement("Xpath", "//div[@class='ad-input']//input");
		//WebElement ele = driver.findElementByXPath("//div[@class='ad-input']//input");
		click(ele);
		Thread.sleep(8000);
		return this;
	}
	public PrimaryContactPage clickSubmit() throws InterruptedException
	{
		WebElement ele = locateElement("xpath", "//button[text()='Submit']");


		click(ele);
//
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
//			reportStep("Submit button clicked successfully", "pass");
		return new PrimaryContactPage(driver, node, test);
	}
}
