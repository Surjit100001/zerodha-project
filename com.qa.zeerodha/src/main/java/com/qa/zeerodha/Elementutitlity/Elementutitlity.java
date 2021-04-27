package com.qa.zeerodha.Elementutitlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elementutitlity 
{
	WebDriver driver;
	
	public Elementutitlity(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void sendKeysutil(By locator)
	{
		 driver.findElement(locator);
	}
	
	public void clickbtn(By loactor)
	{
		 driver.findElement(loactor).click();
	}

}
