package com.irctc.utility;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
 

public class Utility {

	public static WebDriver driver=null; 
	final public static Properties prop = loadpropertiesFile("src/main/resources/conf/config.properties");
	final static Logger logger = Logger.getLogger(Utility.class);
	public static FileInputStream fis = null;

	private static Properties loadpropertiesFile(String FilePAth) 
	{		
		Properties propobj = new Properties();
		try
		{	
			fis = new FileInputStream (FilePAth);
			propobj.load(fis);	
			
		}
		catch(Exception e)
		{			
			logger.info("Exception in file  not Loadinge -- "+e.getMessage());
			return null;
		}
		return propobj;


	}

	// method to get the browser and url 
	public static WebDriver AppLaunch(String BrowserName , String url){
		WebDriver driver = browser(BrowserName); // call the method 
		urlFind(driver, url);

		return driver;
	}

	// Method to get url 	
	public static WebDriver urlFind(WebDriver driver, String url){
		//driver.manage().window().maximize(); // not working for chrome  so can not maximize 

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(url);

		return driver;
	}  

	// Method to instantiate selected browser 	

	public static WebDriver browser(String browsername){
		if(browsername.equalsIgnoreCase("FireFox")){
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("ch")){ 
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome_driver_new.exe");
			driver=new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/MicrosoftDriver.exe");
			driver=new InternetExplorerDriver();	
		}
		return driver;

	}

	// Method to get the defined log properties 
	public static void loadLogger(){
		PropertyConfigurator.configure("src/main/resources/conf/Log4j.properties");
	}
}
