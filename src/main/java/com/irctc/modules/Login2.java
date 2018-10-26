package com.irctc.modules;

import java.awt.Menu;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.irctc.utility.Utility;

public class Login2 extends Utility {
	
	final static Logger logger = Logger.getLogger(Login2.class);
	public Login2(WebDriver driver){
		this.driver=driver;
	}
	WebDriver driver;
	
	@FindBy(xpath="html/body/app-root/app-home/app-header/div[1]/div[3]/a/i")
	WebElement lmenu ;
	
	@FindBy(xpath=".//*[@id='slide-menu']/p-sidebar/div/nav/div/label/span")
	WebElement login;
	
	@FindBy(id="userId")
	WebElement user;

	@FindBy(id="pwd")
	WebElement pwd;

	
	
	
	@Test(priority=1,enabled=true)
	public void log(){
		logger.info("click the menu");
		String mwh=driver.getWindowHandle().toString();
		System.out.println("Window id "+mwh);
		lmenu.click();
		login.click();
		logger.info("clicked the menu now window");
		
		
		

		//Now try to open the popup window by performing some action:

		//driver.findElement(By.xpath("")).click();

		Set<String> s=driver.getWindowHandles(); //this method will gives you the handles of all opened windows

		Iterator<String> ite=s.iterator();
		logger.info("Username has to be Entered");

		//while(ite.hasNext()){
			//String Temp=driver.getWindowHandle();
			//System.out.println("Window id "+Temp);
		//}
		while(ite.hasNext())
		{
			System.out.println("Window id "+mwh); 
			logger.info("Inside while loop ");
		    String popupHandle=ite.next().toString();
		    System.out.println("Window id "+popupHandle); 
		    if(mwh.equals(popupHandle))//if(!popupHandle.contains(mwh))
		    {
		    	logger.info("Inside if ");
		        driver.switchTo().window(popupHandle);
		        //here you can perform operation in pop-up window**
		        //After finished your operation in pop-up just select the main window again
		        
		        WebElement user = driver.findElement(By.id("userId"));
		        user.clear();
				user.sendKeys(prop.getProperty(prop.getProperty("username")));
				logger.info("Username Entered");
		        driver.switchTo().window(mwh);
		    }
		}
		
		
		
		
		/*
		Set<String>s1=driver.getWindowHandles();
		
		// Now we will iterate using Iterator
		Iterator<String> I1= s1.iterator();
		 
		while(I1.hasNext())
		{
		 
		   String child_window=I1.next();
		 
		// Here we will compare if parent window is not equal to child window then we            will close
		 
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		 
		System.out.println(driver.switchTo().window(child_window).getTitle());
		
		user.clear();
		user.sendKeys(prop.getProperty(prop.getProperty("username")));
		logger.info("Username Entered");
		 
		driver.close();
		}
		 
		}
		// once all pop up closed now switch to parent window
		driver.switchTo().window(parent);
		
		
		
		//
		*/
		
		
		
	}
	
}
