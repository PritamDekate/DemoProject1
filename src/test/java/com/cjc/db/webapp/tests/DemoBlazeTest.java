package com.cjc.db.webapp.tests;

import java.io.File;

import java.io.FileInputStream;




import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cjc.db.webapp.pages.AddToCartPage_DemoBlaze;
import com.cjc.db.webapp.pages.LogOutPage_DemoBlaze;
import com.cjc.db.webapp.pages.LoginPage_DemoBlaze;
import com.cjc.db.webapp.pages.PlaceOrderPage_DemoBlaze;
import com.cjc.db.webapp.pages.SignUpPage_DemoBlaze;
import com.cjc.db.webapp.utility.Common;

import io.github.bonigarcia.wdm.WebDriverManager;




public class DemoBlazeTest 
{
		static Logger log=Logger.getLogger(DemoBlazeTest.class.getName());
		
		@BeforeSuite
		public void openBrowser() throws IOException 
		{
			FileInputStream fis=Common.filecall();
			Common.pro.load(fis);
			WebDriverManager.chromedriver().setup();

			//System.setProperty("webdriver.chrome.driver","F:\\SELENIUM AUTOMATION TESTING\\DDF_DataProvider_DemoBlaze\\src\\test\\resources\\BrowserExe\\chromedriver.exe");
			System.setProperty(Common.pro.getProperty("Chrome"),Common.pro.getProperty("Location"));
			//F:\CJC\SELENIUM AUTOMATION TESTING\DDF_DWS_DataProvider\src\test\resources\browserExe\chromedriver1.exe
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\browserExe\\chromedriver1.exe");

			Common.driver=new ChromeDriver();
			log.info("Browser Open SuccessFully");
		}
	
		@BeforeTest
		public void enterUrl() 
		{
			Common.driver.get(Common.pro.getProperty("url"));
			log.info("Enter URL == Before Test");
		}
		
		@BeforeClass
		public void maximizeWindow()
		{
			Common.driver.manage().window().maximize();
			log.info("Maximize Window == Before Class");
		}
		
		@BeforeMethod
		public void getCookies()
		{
			Set<Cookie> cookies = Common.driver.manage().getCookies();
			int count = cookies.size();
			log.info("Total Cookies :: "+count);
			log.info("Get Cookies == Before Method");
		}
		
		@Test(priority = 1,dataProvider = "getData")
		public void SignUpTest(String su, String sp) throws IOException, InterruptedException
		{	
			Thread.sleep(2000);
			Common.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			SignUpPage_DemoBlaze sup=PageFactory.initElements(Common.driver, SignUpPage_DemoBlaze.class);	
			sup.SignUpcheck(su,sp);
			log.info("SignUp Test == Test Executed");
		}
		
		@DataProvider
		public Object [][] getData()
		  {
			return new Object[][] 
					{
				new Object[]{"xyz062@gmail.com","123456"}
					};
	     }
		
		 @Test(priority = 2,dataProvider = "getData1")
		 public void loginTest(String u, String p) throws IOException, InterruptedException
		 {	
			Thread.sleep(2000);
			Common.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			LoginPage_DemoBlaze lp=PageFactory.initElements(Common.driver, LoginPage_DemoBlaze.class);	
			lp.logincheck(u,p);
			log.info("login Test == Test Executed");
		 }
		
		 @DataProvider
		 public Object [][] getData1()
		 {
			return new Object[][] 
					{
				new Object[]{"xyz062@gmail.com","123456"}
					};
		 }
		
		@Test(priority = 3)
		public void AddToCartTest() throws IOException, InterruptedException
		{	
			Thread.sleep(2000);
			Common.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			AddToCartPage_DemoBlaze atcp=PageFactory.initElements(Common.driver, AddToCartPage_DemoBlaze.class);	
			atcp.AddToCartCheck();
			log.info("AddToCart Test == Test Executed");
		}
		
		@Test(priority = 4,dataProvider = "getData2")
		public void PlaceOrderTest(String n, String c,String ci, String cr, String mo, String ye) throws IOException, InterruptedException
		{	
			Thread.sleep(2000);
			Common.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			PlaceOrderPage_DemoBlaze atcp=PageFactory.initElements(Common.driver, PlaceOrderPage_DemoBlaze.class);	
			atcp.PlaceOrderCheck(n,c,ci,cr,mo,ye);
			log.info("PlaceOrder Test == Test Executed");
		}
		
		@DataProvider
		public Object [][] getData2()
		 {
			return new Object[][] 
					{
				new Object[]{"Rohan","India","Delhi","1234 1223 6789 7685","February","2030"}
					};
		 }	
		
		@Test(priority = 5)
		public void LogOutTest() throws IOException, InterruptedException
		{	
			Thread.sleep(2000);
			Common.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			LogOutPage_DemoBlaze logout=PageFactory.initElements(Common.driver, LogOutPage_DemoBlaze.class);	
			logout.LogOutcheck();
			log.info("LogOut Test == Test Executed");
		}
		
		@AfterMethod
		public void captureSc() throws IOException 
		{	
			File src =((TakesScreenshot)Common.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFileToDirectory(src, new File("F:\\SELENIUM AUTOMATION TESTING\\DDF_DataProvider_DemoBlaze\\src\\test\\resources\\ScreenShot"));
			log.info("screenShot == After Method");
		}
		
		@AfterClass
		public void deleteCookies() 
		{	
			Common.driver.manage().deleteCookieNamed("user");
			log.info("Delete Cookies == After Class");
		}
		
		@AfterTest
		public void dbClose() 
		{	
			log.info("DB Connection Close  == After Test");
		}
		
		@AfterSuite
		public void closeBrowser() throws InterruptedException 
		{	
			Thread.sleep(3000);
			Common.driver.close();
			log.info("Close Browser == After Suite");
		}
}			
		
		

