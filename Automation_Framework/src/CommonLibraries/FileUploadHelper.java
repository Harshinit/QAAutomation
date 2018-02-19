package CommonLibraries;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import SupportLibraries.SeleniumHelper;

public class FileUploadHelper extends SeleniumHelper {
	
	/*
	 * Author: Harshini
	 * Date: 
	 * Description: This class contains common methods to upload files  
	 *  	
	 */
	
	public static void loginIntoOneDrive() throws Exception{
		String sUserName = GetProperty("UserID");
		String sPassword = GetProperty("Password");
		String sUser = GetProperty("User");
		driver.findElement(LoginPage.signin_button).click();
		ValidateBrowserReady();
		driver.findElement(LoginPage.email_txt).sendKeys(sUserName);
		driver.findElement(LoginPage.next_button).click();
		ValidateBrowserReady();
		driver.findElement(LoginPage.password_txt).sendKeys(sPassword);
		driver.findElement(LoginPage.signin_button_1).click();
		ValidateBrowserReady();
		boolean bflag = true; 
		try{
			bflag = driver.findElement(By.xpath("//span[text()='"+sUser+"']")).isDisplayed();			
		}catch(Exception e){
			bflag = false;
		}
		String sScreenshot = CapturePageScreenshot();	
	    if(bflag){
			logger.log(LogStatus.PASS, "User "+sUserName+" Logged into One Driver", sScreenshot);
	    }else{
			logger.log(LogStatus.FAIL, "Login Failed for User "+sUserName, sScreenshot);
	    }	
	}	
	
	public static void closePopups() throws Exception{
		int iTimeZoneClose = driver.findElements(HomePage.timezone_closeicon).size();
		if(iTimeZoneClose!=0)driver.findElements(HomePage.timezone_closeicon).get(0).click();
		Thread.sleep(1000);
		int iChatIgnore = driver.findElements(HomePage.chatignore_button).size();
		if(iChatIgnore!=0)driver.findElements(HomePage.chatignore_button).get(0).click();
		Thread.sleep(1000);
	}
	
	public static void uploadfile_ZeroMB() throws Exception{
		Thread.sleep(5000);
		closePopups();
		String path = new File(".").getCanonicalPath();		
		String sZeroFile = path+"\\src\\UploadFiles\\0MB.txt";
		JavascriptExecutor objJS = ((JavascriptExecutor) driver);
		objJS.executeScript("document.getElementsByClassName('CommandBarItem-commandText').item(4).click();");
		Thread.sleep(500);		
		Robot robot = new Robot();
		robot.setAutoDelay(100);
		Thread.sleep(1000);		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_ENTER);
		StringSelection sel = new StringSelection(sZeroFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);		
  	    robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		//Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);		
		boolean bflag = true; 
		try{
			bflag = driver.findElement(HomePage.fileupload_errormsg).isDisplayed();			
		}catch(Exception e){
			bflag = false;
		}
		String sScreenshot = CapturePageScreenshot();	
	    if(bflag){
			logger.log(LogStatus.PASS, "Sorry, OneDrive can't upload empty folders or empty files. Please try again. Error Message is displayed for file size 0", sScreenshot);
	    }else{
	    	logger.log(LogStatus.FAIL, "Sorry, OneDrive can't upload empty folders or empty files. Please try again. Error Message is not displayed for file size 0", sScreenshot);
	    }	
	}
	
	public static void uploadfile() throws Exception{
		Thread.sleep(5000);
		String path = new File(".").getCanonicalPath();		
		String sFile = path+"\\src\\UploadFiles\\DataFile.txt";
		JavascriptExecutor objJS = ((JavascriptExecutor) driver);
		objJS.executeScript("document.getElementsByClassName('CommandBarItem-commandText').item(4).click();");
		Thread.sleep(500);	
		Robot robot = new Robot();
		robot.setAutoDelay(100);
		Thread.sleep(1000);		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_ENTER);
		StringSelection sel = new StringSelection(sFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);		
  	    robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		//Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);	
		Thread.sleep(3000);
		int iExistingFiles = driver.findElements(HomePage.filereplace_button).size();
		if(iExistingFiles!=0)driver.findElements(HomePage.filereplace_button).get(0).click();
		Thread.sleep(1000);
		boolean bflag = true; 
		try{
			bflag = driver.findElement(HomePage.fileupload_errormsg).isDisplayed();			
		}catch(Exception e){
			bflag = false;
		}
		String sScreenshot = CapturePageScreenshot();	
	    if(!bflag){
			logger.log(LogStatus.PASS, "File Upload Successful", sScreenshot);
	    }else{
	    	logger.log(LogStatus.FAIL, "File Upload failed", sScreenshot);
	    }	
	    
	}
}