package com.cjc.db.webapp.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.cjc.db.webapp.utility.Common;



public class LoginPage_DemoBlaze 
{
		public LoginPage_DemoBlaze(WebDriver driver)
		{
			Common.driver=driver;
		}
		
		@CacheLookup
		@FindBy(id = "login2")
		WebElement login2;
		
		@FindBy(id = "loginusername")
		WebElement username;
		
		@FindBy(id = "loginpassword")
		WebElement password;
		
		@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
		WebElement logIn;
		
		public void logincheck(String user,String pass) throws InterruptedException
		{
			login2.click();
			Thread.sleep(2000);
			username.sendKeys(user);
			Thread.sleep(2000);
			password.sendKeys(pass);
			Thread.sleep(2000);
			logIn.click();
		}
}
