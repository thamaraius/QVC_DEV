package com.QVC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;



public class ModifySchedulePage extends Base {

	public ModifySchedulePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public ModifySchedulePage enterPassPortNumber(String passPortNumber) {
		WebElement ele = locateElement("name", "passportNumber");
		clearAndType(ele, passPortNumber);
		return this;
	}

	public ModifySchedulePage enterVisaNumber(String visaNumber) {
		WebElement ele = locateElement("name", "visaNumber");
		clearAndType(ele, visaNumber);
		return this;
	}

	public ModifySchedulePage enterCaptcha() throws InterruptedException {
		WebElement ele = locateElement("name", "captcha");
		click(ele);
		Thread.sleep(5000);
		return this;
	}

	public ModifySchedulePage clickSubmitButton() throws InterruptedException {
		WebElement ele = locateElement("xpath", "//button[text()[normalize-space()='Submit']]");
		click(ele);
		return this;
	}



	  public ModifySchedulePage VRN_Validation_Notification()throws InterruptedException {
		  Thread.sleep(3000);
		  WebElement elem = locateElement("xpath", "//*[text()='OK']");
		  click(elem);
		  System.out.println("Notification Displayed");
		  return this;
}


	public ModifySchedulePage selectQVCCenter(String center) throws InterruptedException {
		/*
		 * WebElement ele = locateElement("xpath",
		 * "//span[@class='fa fa-chevron-down']"); click(ele);
		 */
		WebElement ele1 = locateElement("xpath", "//*[text()=' Chennai ']");
		click(ele1);
		return this;
	}

	public ModifySchedulePage selectCategory(String category) {
		if (category.equalsIgnoreCase("normal")) {
			WebElement ele = locateElement("xpath", "//label[@class='conti c-text-f mr-20']");
			click(ele);
		} else if (category.equalsIgnoreCase("lounge")) {
			WebElement ele = locateElement("xpath", "//label[@class='conti c-text-f mr-20 pull-right']");
			click(ele);
		}
		return this;
	}

	public ModifySchedulePage Date(String Reschedule_date) throws InterruptedException {
		// scrollToElement(); //
		/* Date(date); */

			Thread.sleep(4000);
			//WebElement elem = locateElement("xpath", "//table[@class='datepicker__calendar']/tbody[1]/tr[4]/td[4]/button[1]");//
			WebElement elem=driver.findElement(By.xpath("//button[text()='"+Reschedule_date+"']"));
			elem.click();
			Thread.sleep(4000);
			return this;
			}

	public ModifySchedulePage pickTime(String Reschedule_Time) throws InterruptedException {

		WebElement ele = locateElement("xpath", "//button[text()='"+Reschedule_Time+"']");

		click(ele);
		return this;
	}

	public OrderSummaryPage clickNextButton() {
		WebElement ele = locateElement("xpath", "//button[text()='Next']");
		click(ele);
		return new OrderSummaryPage(driver, node, test);
	}

}
