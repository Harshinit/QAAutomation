package TestScripts;

import org.testng.annotations.Test;

import CommonLibraries.CommonHelper;
import CommonLibraries.FileUploadHelper;
import SupportLibraries.ComplexReportFactory;
import SupportLibraries.SeleniumHelper;

public class ValidateFileUploadProcess extends SeleniumHelper{
	
	/*
	 * Author: Harshini 
	 * TC Description: Validate file upload functionality into one driver
	 * Comments:
	 * Revision History: 
	 */	
	
  @Test
  public void ValidateFileUploadProcess_FileSizes() throws Exception{
	  logger = ComplexReportFactory.getTest();	  
	  CommonHelper.loginIntoOneDrive();
	  FileUploadHelper.uploadfile_ZeroMB();
	  FileUploadHelper.uploadfile();
	  
  }
}
