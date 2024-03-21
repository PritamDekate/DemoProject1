package com.cjc.db.webapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.cjc.db.webapp.utility.Common;

public class AddToCartPage_DemoBlaze 
{
		public AddToCartPage_DemoBlaze(WebDriver driver)
		{
			Common.driver=driver;
		}
		
		@FindBy(css = "#tbodyid > div:nth-child(1) > div > div > h4 > a")
		WebElement mobile;
		
		@FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
		WebElement addtc;
		
		@FindBy(xpath = "//*[@id=\"cartur\"]")
		WebElement cart;
		
	
		public void AddToCartCheck() throws InterruptedException
		{	
			Thread.sleep(3000);
			mobile.click();
			addtc.click();
			cart.click();
		}

		
}
