package com.QVC.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.QVC.design.Browser;
import com.QVC.design.Element;

import utils.Reporter;

public class Base extends Reporter implements Browser, Element{

	public RemoteWebDriver driver;
	public WebDriverWait wait;

	//int i=1;
	@Override
	public void click(WebElement ele) {
		String text="";
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The Element "+text+" clicked", "pass");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element "+text+" could not be clicked", "fail");
			throw new RuntimeException();

		}
	}
	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			text = ele.getText();
			wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			reportStep("The Element with text: "+text+" clicked", "pass");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element "+ele+" could not be clicked", "fail");
			throw new RuntimeException();
		}catch(Exception e) {
			System.err.println(e);
		}

	}

	@Override
	public void append(WebElement ele, String data) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.sendKeys(data);
	}

	@Override
	public void clear(WebElement ele) {
		try {
			ele.clear();
			reportStep("The field is cleared Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The field is not Interactable", "fail");
			throw new RuntimeException();
		}
	}

	@Override
	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The Data :"+data+" entered Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The Element "+ele+" is not Interactable", "fail");
			throw new RuntimeException();
		}

	}

	@Override
	public String getElementText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	@Override
	public String getBackgroundColor(WebElement ele) {
		String cssValue = ele.getCssValue("color");
		return cssValue;
	}

	@Override
	public String getTypedText(WebElement ele) {
		String attributeValue = ele.getAttribute("value");
		return attributeValue;
	}


	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {

		try {
			wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			new Select(ele)
			.selectByVisibleText(value);
			reportStep("The " +value+ " selected successfully","Pass");
		} catch (Exception e) {
			reportStep("The " +value+ " not selected due to" +e,"fail");

		}
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		new Select(ele)
		.selectByIndex(index);
	}
	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		new Select(ele)
		.selectByValue(value);
	}

	@Override
	public boolean verifyExactText(WebElement ele, String expectedText) {
		try {
			wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf((ele)));
			if(ele.getText().equals(expectedText)) {

				reportStep("The expected text contains the actual "+expectedText,"pass");
				return true;
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		}

		return false;

	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(ele.getText().contains(expectedText)) {
				reportStep("The expected text contains the actual "+expectedText,"pass");
				return true;
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		}

		return false;
	}

	@Override
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(ele.getAttribute(attribute).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"pass");
				return true;
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Attribute Text");
		}
		return false;
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(ele.getAttribute(attribute).contains(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"pass");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Attribute Text");
		}

	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				wait=new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOf(ele));
				reportStep("The element "+ele+" is visible","pass");
				return true;
			} else {
				reportStep("The element "+ele+" is not visible","fail");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
		return false;

	}

	@Override
	public boolean verifyDisappeared(WebElement ele) {
		return false;

	}

	@Override
	public boolean verifyEnabled(WebElement ele) {
		try {
			if(ele.isEnabled()) {
				reportStep("The element "+ele+" is Enabled","pass");
				return true;
			} else {
				reportStep("The element "+ele+" is not Enabled","fail");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
		return false;
	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+ele+" is selected","pass");
				//				return true;
			} else {
				reportStep("The element "+ele+" is not selected","fail");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
		//		return false;

	}



	@Override
	public WebElement locateElement(String locatorType, String value) {
		try {
			switch(locatorType.toLowerCase()) {
			case "id": return driver.findElement(By.id(value));
			case "name": return driver.findElement(By.name(value));
			case "class": return driver.findElement(By.className(value));
			case "link": return driver.findElement(By.linkText(value));
			case "xpath": return driver.findElement(By.xpath(value));
			}
		} catch (NoSuchElementException e) {
			reportStep("The Element with locator:"+locatorType+" Not Found with value: "+value, "fail");
			throw new RuntimeException();
		}catch (Exception e) {
			reportStep("The Element with locator:"+locatorType+" Not Found with value: "+value, "fail");
		}
		return null;
	}

	@Override
	public WebElement locateElement(String value) {
		WebElement findElementById;
		try {
			findElementById = driver.findElement(By.id(value));
		} catch (NoSuchElementException e) {
			reportStep("The Element Not Found with value: "+value, "fail");
			throw new RuntimeException();
		}
		return findElementById;
	}

	@Override
	public List<WebElement> locateElements(String type, String value) {
		try {
			switch(type.toLowerCase()) {
			case "id": return driver.findElements(By.id(value));
			case "name": return driver.findElements(By.name(value));
			case "class": return driver.findElements(By.className(value));
			case "link": return driver.findElements(By.linkText(value));
			case "xpath": return driver.findElements(By.xpath(value));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element with locator:"+type+" Not Found with value: "+value);
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public void switchToAlert() {
		driver.switchTo().alert();
	}

	@Override
	public void acceptAlert() {
		String text = "";
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.", "pass");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.", "fail");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}

	}

	@Override
	public void dismissAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			System.out.println("The alert "+text+" is accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}


	}

	@Override
	public String getAlertText() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
		return text;
	}

	@Override
	public void typeAlert(String data) {
		driver.switchTo().alert().sendKeys(data);

	}

@Override
	public void switchToWindow(int index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<String>(allWindows);
			String exWindow = allhandles.get(index);
			driver.switchTo().window(exWindow);
			System.out.println("The Window With index: "+index+
					" switched successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With index: "+index+
					" not found");
		}
	}

	@Override
	public void switchToWindow(String title) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String eachWindow : allWindows) {
				driver.switchTo().window(eachWindow);
				if (driver.getTitle().equals(title)) {
					break;
				}
			}
			System.out.println("The Window With Title: "+title+
					"is switched ");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With Title: "+title+
					" not found");
		} finally {
			takeSnap();
		}
	}

	@Override
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);

	}

	@Override
	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);

	}

	@Override
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);

	}

	@Override
	public void defaultContent() {
		driver.switchTo().defaultContent();

	}

	@Override
	public boolean verifyUrl(String url) {
		try {
			if (driver.getCurrentUrl().equals(url)) {

				reportStep(url+" matched Successfully", "pass");
			}

		} catch (Exception e) {
			reportStep(url+" notmatched ", "fail");

		}
		return false;

	}

 @Override
	public boolean verifyTitle(String title) {
		/*
		 * if (driver.getTitle().equals(title)) {
		 * System.out.println("Page title: "+title+" matched successfully"); return
		 * true; } else { System.out.println("Page url: "+title+" not matched"); }
		 */
		return false;
	}


	@Override
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	@Override
	public void close() {
		driver.close();

	}

	@Override
	public void quit() {
		driver.quit();

	}
	public int generateRandomNumber() {
		Random random = new Random();
		int randomNumber = random. nextInt(900) + 100;

		return randomNumber;
	}


public void writeExcel(String WorkBookName,int SheetNumber,String data,int cellnum) throws IOException {

	String path2 = WorkBookName;
    FileInputStream fis2 = new FileInputStream(path2);
    XSSFWorkbook workbook2 = new XSSFWorkbook(fis2);
    XSSFSheet sheet2 = workbook2.getSheetAt(SheetNumber);
    int lastRow2 = sheet2.getLastRowNum();
    System.out.println(lastRow2);

    for(int i=1; i<=lastRow2; i++)


    {
    System.out.println(i);
    XSSFRow row = sheet2.getRow(i);

    Row row1 = sheet2.getRow(i);

    Cell cell = row1.createCell(cellnum);

    cell.setCellValue(data);


    }

    FileOutputStream fos2 = new FileOutputStream(path2);
    workbook2.write(fos2);
    fos2.close();

    workbook2.close();
    fis2.close();

    }



public void writeExcel1(String WorkBookName,int SheetNumber,String data,int cellnum,int rownum) throws IOException {


	String path2 = WorkBookName;
    FileInputStream fis2 = new FileInputStream(path2);
    XSSFWorkbook workbook2 = new XSSFWorkbook(fis2);
    XSSFSheet sheet2 = workbook2.getSheetAt(SheetNumber);
    int lastRow2 = sheet2.getLastRowNum();
    System.out.println(lastRow2);


    //XSSFRow row = sheet2.getRow(rownum);

    Row row1 = sheet2.getRow(rownum);

    Cell cell = row1.createCell(cellnum);

    cell.setCellValue(data);

    FileOutputStream fos2 = new FileOutputStream(path2);
    workbook2.write(fos2);
    fos2.close();

    workbook2.close();
    fis2.close();

    }

}




