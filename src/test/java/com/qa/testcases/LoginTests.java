package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;
import com.qa.util.MyScreenRecorder;

public class LoginTests extends TestBase {

	Loginpage loginpage;
	HomePage homepage;
	
	public LoginTests()
	{
		super();
	}
	
	@BeforeMethod
	
	public void setup()
	{
		initialization();
		loginpage=new Loginpage();
	}
	
	@Test(retryAnalyzer=Analyzer.RetryAnalyzer.class)
	
	public void loginpagetitletest() throws Exception
	{
		MyScreenRecorder.startRecording("loginpagetitletest");
		String title=loginpage.validateloginpagetitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
		MyScreenRecorder.stopRecording();
	}
	
	@Test
	
	public void crmlogotest() throws Exception
	{
		MyScreenRecorder.startRecording("crmlogotest");
        Assert.assertTrue(loginpage.validatecrmimage());
		MyScreenRecorder.stopRecording();

	}
	
    @Test(priority=3)
	
	public void logintest() throws Exception
	{
    MyScreenRecorder.startRecording("logintest");
    homepage=loginpage.login(prop.getProperty("Username"),prop.getProperty("Password"));
	MyScreenRecorder.stopRecording();	
	}
	
	@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}
		
}
