package com.QVC.common;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.QVC.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DataLibrary;



public class ProjectSpecificMethod extends Base {
		public String dataSheetName;
		public String sheetName;


		@DataProvider(name = "fetchData")
		public Object[][] fetchData() throws IOException {
			return DataLibrary.readExcelData(dataSheetName,sheetName);
		}
		@Parameters({"url","browserName"})
		@BeforeMethod
		public void beforeMethods(String url,String browserName) {
			try {
			if(browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				String downloadPath="C:\\Users\\thamarais\\eclipse-workspace\\Gerrys_Website\\downloads";
				//String downloadPath="C:\\Users\\thamarais\\Documents\\AppointmentLetter";
				HashMap<String, Object> Prefs = new HashMap<String, Object>();
				Prefs.put("profile.default_content_settings.popups", 0);
				Prefs.put("download.default_directory", downloadPath);
				Prefs.put("plugin.always_open_pdf_externally", true);
				options.setExperimentalOption("prefs", Prefs);
			driver = new ChromeDriver(options);

			}else if(browserName.equals("edge")){

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			}else if(browserName.equals("firefox")){

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			}


			driver.manage().window().maximize();
			driver.get(url);
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			node = test.createNode(testCaseName);

			}catch (Exception e) {
				reportStep("The Browser Could not be Launched. Hence Failed", "fail");
				throw new RuntimeException();
			}


		}

		/*
		 * @AfterMethod public void afterMethod()
		 *
		 * { for(String winHandle : driver.getWindowHandles()) { if (winHandle ==
		 * driver.getWindowHandles().toArray()[driver.getWindowHandles().size()-1]) {
		 * continue; } driver.switchTo().window(winHandle); driver.close(); } }
		 */
}
