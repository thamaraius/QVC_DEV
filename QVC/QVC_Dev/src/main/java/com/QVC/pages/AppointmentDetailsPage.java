package com.QVC.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			  WebElement ele1 =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Download']")));
		//	WebElement ele = locateElement("xpath", "//span[text()='Download']");
		      ele1.click();
		return this;

	}
}
}