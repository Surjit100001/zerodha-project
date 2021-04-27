package com.qa.zeerodha.Basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage 
{
	WebDriver driver;
	Properties prop;
	
	public WebDriver inti_browser(String Browsername)
	{
		System.out.println("current browser: " +Browsername);
		
		if(Browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("pass the correct browser :");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public Properties inti_properties()
	{
		prop = new Properties();
		String path = "./src/main/java/com/qa/zeerodha/PropFile/configur";
		
		try {
			FileInputStream IP = new FileInputStream(path);
			prop.load(IP);
		} catch (FileNotFoundException e) {
			System.out.println("not found in file");
		} catch (IOException e) {
			System.out.println("load exception");
		}
		return prop;
	}
   
}
