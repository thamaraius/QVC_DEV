package com.QVC.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

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

		WebElement ele=locateElement("xpath","//body/qvc-root[1]/div[1]/qvc-schedule[1]/div[1]/div[1]/div[2]/qvc-reviewsummary[1]/div[1]/div[1]/div[6]/div[2]/div[2]/input[1]");
	    js.executeScript("arguments[0].click();", ele);


		return this;

	}
	public OrderSummaryPage clickConfirm() throws InterruptedException
	{

		 Thread.sleep(10000);
		click(locateElement("xpath","//button[contains(text(),'Confirm')]"));

		Thread.sleep(10000);
		return this;

	}


	public AppointmentDetailsPage DownloadApptletter() throws InterruptedException {
		 {

			  click(locateElement("xpath","//header/div[1]/a[1]/i[1]"));
			  Thread.sleep(3000);
			 // JavascriptExecutor js = driver;
			  WebElement ele = locateElement("xpath", "//body/qvc-root[1]/div[1]/qvc-schedule[1]/div[1]/div[1]/div[2]/qvc-letter[1]/div[1]/div[1]/div[1]/span[1]");
			 // js.executeScript("arguments[0].click();", ele);
		      ele.click();
		      Thread.sleep(5000);

		   return new AppointmentDetailsPage(driver,node,test);

	}
}



}
