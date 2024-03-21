package com.cjc.db.webapp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.cjc.db.webapp.utility.Common;

public class SignUpPage_DemoBlaze 
{
		public SignUpPage_DemoBlaze(WebDriver driver)
		{
			Common.driver=driver;
		}
		
		
		@FindBy(id = "signin2")
		@CacheLookup
		WebElement signin2;
		
		@FindBy(id = "sign-username")
		WebElement susername;
		
		@FindBy(id = "sign-password")
		WebElement spassword;
		
		@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
		WebElement signIn;
		
		@FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[1]/button/span")
		@CacheLookup
		WebElement sim;
	
		public void SignUpcheck(String suser,String spass) throws InterruptedException
		{	
			Common.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			Common.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			signin2.click();
			Thread.sleep(2000);
			susername.sendKeys(suser);
			Thread.sleep(2000);
			spassword.sendKeys(spass);
			signIn.click();
			
			sim.click();
			Thread.sleep(2000);
			Common.driver.switchTo().alert().accept();
		}
		
}
