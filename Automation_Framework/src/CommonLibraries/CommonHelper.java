package CommonLibraries;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import SupportLibraries.SeleniumHelper;

public class CommonHelper extends SeleniumHelper {
	
	/*
	 * Author: Harshini
	 * Date: 
	 * Description: This class contains common methods to navigate to login and logout  
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
}