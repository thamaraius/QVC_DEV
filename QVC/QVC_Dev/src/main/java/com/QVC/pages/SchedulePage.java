package com.QVC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;



public class SchedulePage extends Base {


	public SchedulePage(RemoteWebDriver driver,ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}
	public SchedulePage VRN_Validation_Notification()
	{
		WebElement ele = locateElement("xpath","//button[text()='OK']");
		click(ele);
		return this;
	}


	public void scrollToElement()
	{
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			reportStep("page scrolled successfully", "pass");
		} catch (Exception e) {
			System.out.println("Unknown Exception");
			reportStep("page could not be scrolled", "fail");
		}
	}

	public SchedulePage selectQVCCenter(String city) throws InterruptedException
	{
		//Thread.sleep(1000);
		WebElement ele = locateElement("xpath", "//p[text()=' --Select Center--']");
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		click(ele);
		//Thread.sleep(2000);
		//WebElement ele1 = locateElement("xpath", "//ul[@x-placement='+city+']//a");//
		WebElement ele1  =driver.findElement(By.linkText("Chennai"));
		wait.until(ExpectedConditions.elementToBeClickable(ele1));
		click(ele1);
		return this;
	}

	public SchedulePage selectCategory(String category) throws InterruptedException
	{
		if (category.equalsIgnoreCase("normal")) {
			WebElement ele = locateElement("xpath", "//label[@class='conti c-text-f mr-20']");
			//WebElement ele = driver.findElementByXPath("//label[@class='conti c-text-f mr-20']");
			click(ele);
		}
		else if(category.equalsIgnoreCase("lounge"))
		{
			WebElement ele = locateElement("xpath", "//label[@class='conti c-text-f mr-20 pull-right']");
			//WebElement ele = driver.findElementByXPath("//label[@class='conti c-text-f mr-20 pull-right']");
			click(ele);
			Thread.sleep(1000);
		}
		return this;
	}


	  public SchedulePage scrollToSelectData() throws InterruptedException {

	 //--------Click SignUpNow button -------
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,200)");
		 */
		/*
		 * WebDriverWait wait=new WebDriverWait(driver, 20); WebElement
		 * element=wait.until(ExpectedConditions.elementToBeClickable(By.
		 * cssSelector("button[class*='btn btn-primary']"))); element.click();
		 */
	  return this;
	  }


	/*
	 * public SchedulePage selectDate(String date)throws InterruptedException {
	 *
	 * // // ------Select date --------- WebElement ele = locateElement("xpath",
	 * "//*[text()= '"+date+"']"); ele.click(); return this; }
	 */


	public SchedulePage Date (String date) throws InterruptedException {
		Thread.sleep(2000);

		click(locateElement("xpath","//button[contains(text(),'"+date+"')]"));



		return this;
		}

	 public SchedulePage scrollToSelectTime() throws InterruptedException {

		 //--------Click SignUpNow button -------
		  JavascriptExecutor js = driver; js.executeScript("window.scrollBy(0,400)");
			/*
			 * WebDriverWait wait=new WebDriverWait(driver, 20); WebElement
			 * element=wait.until(ExpectedConditions.elementToBeClickable(By.
			 * cssSelector("button[class*='btn btn-primary']"))); element.click();
			 */
		  return this;
		  }

		public SchedulePage pickTime(String timeSlot ) throws InterruptedException {

	   // JavascriptExecutor js = driver;
	  //js.executeScript("window.scrollBy(0,400)");
		WebElement elem = locateElement("xpath", "//button[text()='"+timeSlot+"']");
		elem.click();
		//js.executeScript("arguments[0].click();", elem);

		return this;

		}


	public OrderSummaryPage clickNext()
	{
		WebElement ele = locateElement("xpath", "//button[text()='Next']");
	//	WebElement ele = driver.findElementByXPath("//button[text()='Next']");
		click(ele);
		return new OrderSummaryPage(driver,node,test);
	}
}
