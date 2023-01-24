package com.QVC.pages;

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
			  click(locateElement("xpath","//header/div[1]/a[1]/i[1]"));
			  Thread.sleep(3000);
			 // JavascriptExecutor js = driver;
			  WebElement ele = locateElement("xpath", "//body/qvc-root[1]/div[1]/qvc-schedule[1]/div[1]/div[1]/div[2]/qvc-letter[1]/div[1]/div[1]/div[1]/span[1]");
			 // js.executeScript("arguments[0].click();", ele);
		      ele.click();
		      Thread.sleep(5000);
		   return this;

	}
}
}