package com.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.CustomListeners;
import com.qa.base.TestBase;
import com.qa.pages.Contactspage;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;
import com.qa.pages.TasksPage;
import com.qa.util.TestUtil;

@Listeners(CustomListeners.class)
public class HomePageTests extends TestBase{
	
Loginpage loginpage;
HomePage homepage;
Contactspage contacts;
DealsPage deals;
TasksPage tasks;
TestUtil util;
	
	public HomePageTests()
	{
		super();
	}
	
	@BeforeMethod
	
	public void setup() throws InterruptedException
	{
		initialization();
		contacts=new Contactspage();
		deals=new DealsPage();
		loginpage=new Loginpage();
		tasks=new TasksPage(); 
		util=new TestUtil();
		homepage=loginpage.login(prop.getProperty("Username"),prop.getProperty("Password"));
	}
	
	
	@Test(priority=1)
	
	public void clickoncontactslinkTest()
	{
        util.SwitchFrame();
		contacts=homepage.clickOncontactslink();
	}
	
	@Test(priority=2)
	public void clickondealslinkTest()
	{
		util.SwitchFrame();
		deals=homepage.clickOndealslink();
	}
	
	@Test(priority=3)
	
	public void clickontaskslinkTest()
	{
		util.SwitchFrame();
		tasks=homepage.clickOntaskslink();
	}
	
    @Test(priority=4)
	
	public void verifytitletest()
	{   
		String title=homepage.verifytitle();
		Assert.assertEquals("CRMPRO", title);

	}
    
    @Test(priority=5)
	
   	public void validateusernametest()
   	{
		util.SwitchFrame();
   	    Assert.assertTrue(homepage.validateusername());
   	}
       
	
	@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}
	
}
