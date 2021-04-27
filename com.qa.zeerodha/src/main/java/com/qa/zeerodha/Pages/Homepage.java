package com.qa.zeerodha.Pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.zeerodha.Basepage.Basepage;

public class Homepage extends Basepage
{
	WebDriver driver;
	Basepage basepage;
	Loginpage loginpage;
	Properties prop;
	
	
	By order = By.linkText("Orders");
	By move = By.xpath("//span[@class=\"nice-name\"]");
	By sellbtn = By.xpath("//button[@class=\"button-orange sell\"]");
	By enterqty = By.xpath("//input[@label=\"Qty.\"]");
	By sellbtn2 = By.xpath("//button[@type=\"submit\"]//span[text()='Sell']");
	By app = By.xpath("//a//span[contains(text(), 'Apps')]");
	By userbtn = By.xpath("//span[@class=\"user-id\"]");
	
	By userProfile = By.xpath("//span[text()='DV1510']");
	
	public Homepage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String gettitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean orderlink()
	{
		return driver.findElement(order).isDisplayed();
	}
	
	public void sellqnty(String value)
	{
		
		
		WebElement moves = driver.findElement(move);
        Actions action = new Actions(driver);
		action.moveToElement(moves).build().perform();
		
		driver.findElement(sellbtn).click();
		driver.findElement(enterqty).sendKeys(value);
		driver.findElement(sellbtn2).click();
		
	}
	
	public boolean applink()
	{
		return driver.findElement(app).isEnabled();
	}
	
	public boolean userbtn()
	{
	  return driver.findElement(userbtn).isEnabled();
	}
	
	public void userProfile()
	{
	    driver.findElement(userProfile).click();
		
	}
	

}
