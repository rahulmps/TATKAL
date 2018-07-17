package com.irctc.modules;

import java.awt.Menu;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.irctc.utility.Utility;

public class Login extends Utility {
	
	final static Logger logger = Logger.getLogger(Login.class);
	public Login(WebDriver driver){
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
		String parent=driver.getWindowHandle();
		lmenu.click();
		login.click();
		logger.info("clicked the menu now window");
		
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
		
		
		
		
	}
	
}
