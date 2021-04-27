package com.qa.zeerodha.PagesTest;

import java.util.Properties;

import org.apache.poi.openxml4j.opc.PackageProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.zeerodha.Basepage.Basepage;
import com.qa.zeerodha.Pages.Loginpage;

public class LoginpageTest 
{
	WebDriver driver;
	Properties prop;
	Basepage basepage;
	Loginpage loginpage;
	
	@BeforeTest
	public void setup()
	{
		basepage = new Basepage();
		prop = basepage.inti_properties();
		String Browsername = prop.getProperty("browser");
		driver = basepage.inti_browser(Browsername);
		driver.get(prop.getProperty("url"));
		
		loginpage = new Loginpage(driver);
	}
	
	@Test
	public void gettitleTest()
	{
		String title = loginpage.gettitle();
		System.out.println(title);
		Assert.assertEquals(title, "Dashboard / Kite", "not match");
	}
	
	@Test
	public void dologinTest()
	{
		 loginpage.dologin(prop.getProperty("email"), prop.getProperty("pass"), prop.getProperty("pin"));
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	

}
