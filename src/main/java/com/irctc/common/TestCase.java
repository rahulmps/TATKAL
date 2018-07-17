package com.irctc.common;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.irctc.modules.Login;
import com.irctc.modules.Login2;
//import com.irctc.modules.Login;
import com.irctc.utility.Utility;

public class TestCase extends Utility {
	WebDriver driver=AppLaunch(prop.getProperty("browser"), prop.getProperty("url"));
	final static Logger logger = Logger.getLogger(TestCase.class);
	
	Login oobject = PageFactory.initElements(driver, Login.class);
	Login2 ooobject = PageFactory.initElements(driver , Login2.class);
	//Login lobject = PageFactory.initElements(driver, Login.class);
	//DGLogin object = PageFactory.initElements(driver, DGLogin.class);
	@BeforeSuite
	public void systemStartUpConfiguration() throws IOException {
		loadLogger();
		logger.info("----------------------System StartUp Configuration -----------------------------");
	}
	
@Test(priority=1 , enabled=false)
public void login(){
	logger.info(" inside login TC ");
	oobject.log();
}

@Test(priority=2 , enabled=true)
public void login2(){
logger.info(" inside login TC ");
ooobject.log();
}	
	
}
