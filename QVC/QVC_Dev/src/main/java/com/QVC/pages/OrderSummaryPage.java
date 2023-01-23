package com.QVC.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.QVC.base.Base;
import com.aventstack.extentreports.ExtentTest;



public class OrderSummaryPage extends Base{

	public OrderSummaryPage(RemoteWebDriver driver,ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}


	public OrderSummaryPage clickCaptcha() throws InterruptedException
	{

		JavascriptExecutor js = driver;
		js.executeScript("window.scrollBy(0,250)", "");

		WebElement ele=locateElement("xpath","//input[contains(@class,'form-control txt-style')]");
	    js.executeScript("arguments[0].click();", ele);

        Thread.sleep(10000);
		return this;

	}
	public OrderSummaryPage clickConfirm() throws InterruptedException
	{

		Thread.sleep(7000);
		click(locateElement("xpath","//button[contains(text(),'Confirm')]"));


		return this;

	}


	public AppointmentDetailsPage DownloadApptletter() throws InterruptedException {
		 {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			  WebElement ele1 =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Download']")));
		//	WebElement ele = locateElement("xpath", "//span[text()='Download']");
		   ele1.click();
		return new AppointmentDetailsPage(driver,node,test);

	}
}



}
