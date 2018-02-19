package PageObjects;

import org.openqa.selenium.By;


public class LoginPage {

	/*
	 * Author: Harshini
	 * Date: 
	 * Description: This class contains locators for login page objects/elements  
	 *  	
	 */
	
	public static By signin_button = By.xpath("//a[text()='Sign in']");
	public static By email_txt = By.name("email");
	public static By next_button = By.xpath("//a[@title='Next']");
	public static By password_txt = By.name("passwd");
	public static By signin_button_1 = By.xpath("//input[@value='Sign in']");
	
	
}
