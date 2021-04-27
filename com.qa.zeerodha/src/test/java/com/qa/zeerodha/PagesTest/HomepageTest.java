package com.qa.zeerodha.PagesTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.zeerodha.Basepage.Basepage;
import com.qa.zeerodha.Pages.Homepage;
import com.qa.zeerodha.Pages.Loginpage;


public class HomepageTest
{
	WebDriver driver;
	Basepage basepage;
	Loginpage loginpage;
	Properties prop;
	Homepage homepage;
	
	@BeforeTest
	public void setup()
	{
		basepage = new Basepage();
		prop = basepage.inti_properties();
		String Browsername = prop.getProperty("browser");
		driver = basepage.inti_browser(Browsername);
		driver.get(prop.getProperty("url"));
		loginpage = new Loginpage(driver);
		homepage = loginpage.dologin(prop.getProperty("email"), prop.getProperty("pass"), prop.getProperty("pin"));
	}
	
	@Test
	public void gettitle()
	{
		String title = homepage.gettitle();
		System.out.println(title);
		Assert.assertEquals(title, "Dashboard / Kite");
	}
	
	@Test
	public void orderlinkTest()
	{
		Assert.assertTrue(homepage.orderlink());
	}
	
	@Test
	public void sellqntyTest()
	{
		homepage.sellqnty(prop.getProperty("qty"));
	}
	
	@Test
	public void applinkTest()
	{
		Assert.assertTrue(homepage.applink());
	}
	
	@Test(enabled=false)
	public void userbtTest()
	{
	   Assert.assertTrue(homepage.userbtn());
	}
	
	@Test
	public void userProfile()
	{
		homepage.userProfile();
	}
	
	
	@AfterTest
	public void teardown()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("wrong");
		}
		driver.quit();
	}
	
}
