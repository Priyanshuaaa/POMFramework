package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Contactspage;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;
import com.qa.util.TestUtil;

public class Contactspagetest extends TestBase{
	Loginpage loginpage;
	HomePage homepage;
	Contactspage contacts;
	TestUtil util;
	String sheetname="ContactData";
	
	public Contactspagetest()
	{
		super();
	}
	
@BeforeMethod
	
	public void setup() throws InterruptedException
	{
		initialization();
		loginpage=new Loginpage();
		contacts=new Contactspage();
		util=new TestUtil();
		homepage=loginpage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		util.SwitchFrame();
	}

@DataProvider

public Object[][] getcontactsdata()
{
	Object[][] data=TestUtil.getTestData(sheetname);
	return data;
}



 @Test(dataProvider="getcontactsdata")
 
 public void addnewcontactest(String titles,String firstname,String lastname)
 {
	 homepage.clickonnewcontactlink();
	 contacts.addnewcontact(titles,firstname,lastname);
 }
 
	@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}
	

}
