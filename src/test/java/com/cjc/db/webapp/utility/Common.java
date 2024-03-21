package com.cjc.db.webapp.utility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common 
{
		public static WebDriver driver;
		public static Properties pro= new Properties();
		public static FileInputStream fis;
		
		public static FileInputStream filecall() throws FileNotFoundException
		{
			fis=new FileInputStream("F:\\SELENIUM AUTOMATION TESTING\\DDF_DataProvider_DemoBlaze\\src\\test\\resources\\Common.properties");
			return fis;
		}
			
		
			
}

