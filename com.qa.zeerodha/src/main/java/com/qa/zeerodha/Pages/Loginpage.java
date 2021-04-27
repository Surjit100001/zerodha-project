
package com.qa.zeerodha.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.zeerodha.Basepage.Basepage;
import com.qa.zeerodha.Elementutitlity.Elementutitlity;

public class Loginpage extends Basepage
{
	WebDriver driver;
	Properties prop;
	Elementutitlity ele;
	
    By username = By.xpath("//input[@type='text']");
	By password = By.xpath("//input[@type='password']");
	By submitbtn = By.xpath("//button[@type='submit']");  
	By pins = By.xpath("//input[@id='pin']");
	By submitbtn2 = By.xpath("//button[@type='submit']");
	
	
	
	public Loginpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String gettitle()
	{
		return driver.getTitle();
	}
	
	public Homepage dologin(String user, String pass , String pin)
	{
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(submitbtn).click();
		driver.findElement(pins).sendKeys(pin);
		driver.findElement(submitbtn2).click();
		
		return new Homepage(driver);
		
	}

	
	
	

}
