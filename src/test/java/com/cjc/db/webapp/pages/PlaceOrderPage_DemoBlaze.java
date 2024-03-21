package com.cjc.db.webapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cjc.db.webapp.utility.Common;

public class PlaceOrderPage_DemoBlaze 
{
		public PlaceOrderPage_DemoBlaze(WebDriver driver)
		{
			Common.driver=driver;
		}
		
		@FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
		WebElement placeorder;
		
	    @FindBy(id = "name")
	    WebElement name;
	
	    @FindBy(id = "country")
	    WebElement country;
	
	    @FindBy(id = "city")
	    WebElement city;
	
	    @FindBy(id = "card")
	    WebElement card;
	
	    @FindBy(id = "month")
	    WebElement month;
	
	    @FindBy(id = "year")
	    WebElement year;
	
	    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
	    WebElement buttonPurchase;
	    
	    @FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
	    WebElement OkButton;
		
	
		public void PlaceOrderCheck(String nam, String cou, String ct, String crd, String mon, String yea) throws InterruptedException
		{	
			Thread.sleep(2000);
			placeorder.click();
			Thread.sleep(1000);
			name.sendKeys(nam);
			Thread.sleep(1000);
			country.sendKeys(cou);
			Thread.sleep(1000);
			city.sendKeys(ct);
			Thread.sleep(1000);
			card.sendKeys(crd);
			Thread.sleep(1000);
			month.sendKeys(mon);
			Thread.sleep(1000);
			year.sendKeys(yea);
			Thread.sleep(1000);
			buttonPurchase.click();
			Thread.sleep(2000);
			OkButton.click();
		}
}
