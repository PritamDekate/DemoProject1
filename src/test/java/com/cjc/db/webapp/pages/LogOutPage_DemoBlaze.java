package com.cjc.db.webapp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.cjc.db.webapp.utility.Common;

public class LogOutPage_DemoBlaze 
{
		public LogOutPage_DemoBlaze(WebDriver driver)
		{
			Common.driver=driver;
		}
		
		
		@FindBy(xpath = "//*[@id=\"logout2\"]")
		@CacheLookup
		WebElement logout;
		
	
		public void LogOutcheck() throws InterruptedException
		{	
			Common.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			Common.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(2000);
			logout.click();
			
		}
}
