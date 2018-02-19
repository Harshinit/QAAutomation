package PageObjects;

import org.openqa.selenium.By;


public class HomePage {

	/*
	 * Author: Harshini
	 * Date: 
	 * Description: This class contains locators for Home Page objects/elements  
	 *  	
	 */
	
	public static By onedriver_header= By.xpath("//span[text()='OneDrive']");
	public static By upload_button = By.xpath("//input[@class='CommandBarItem-fileInput']");
	public static By fileupload_errormsg = By.xpath("//div[text()=\"Sorry, OneDrive can't upload empty folders or empty files. Please try again.\"]");
	public static By fileclose_button = By.xpath("//div[text()=\"Sorry, OneDrive can't upload empty folders or empty files. Please try again.\"]/../../..//button[@aria-label='Close']");
	public static By timezone_closeicon = By.xpath("//*[contains(@class,'notifications-closeIcon')]");
	public static By chatignore_button = By.xpath("//span[text()='Ignore']");
	public static By filereplace_button = By.xpath("//span[text()='Replace']");
}
