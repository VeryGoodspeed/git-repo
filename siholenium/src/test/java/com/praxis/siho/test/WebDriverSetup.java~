package com.praxis.siho.test;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.praxis.siho.test.common.Browser;
import com.praxis.siho.test.common.SetTestVariables;

public class WebDriverSetup {
	  
    private static final Browser BROWSER;
    private static final String MODE;
    private static final String SELENIUM_SERVER;
    private static final String CHROME_DRIVER;    
    private static final String LOCAL  = "local";
    private static final String REMOTE = "remote";
    
    protected WebDriver driver;
    
    static {
        BROWSER 	    = Browser.valueOf(SetTestVariables.configProp.getProperty("browser"));
        MODE 			= SetTestVariables.configProp.getProperty("mode");
        SELENIUM_SERVER = SetTestVariables.configProp.getProperty("selenium_sever_url");
        CHROME_DRIVER   = SetTestVariables.configProp.getProperty("chrome_driver");
    }
    
    @BeforeClass
    public void beforeClass() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(Boolean.TRUE);        
        try {
        	
	        if (LOCAL.equals(MODE)) {
	            
	            switch(BROWSER) {
	                case CHROME:
	                	System.out.println("chrome flow");
	                    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
	                    driver = new ChromeDriver();
	                    break;
	                case FIREFOX:
	                	System.out.println("firefox flow");
	                    FirefoxProfile newProfile = new FirefoxProfile();
	                    newProfile.setPreference("browser.cache.disk.enable", false);
	                    driver = new FirefoxDriver(newProfile);
	                    break;
	                case INTERNET_EXPLORER:
	                	System.out.println("shit flow");
	                    driver = new InternetExplorerDriver();
	                    break;
	                default:
	                	System.out.println("errroooorrr");
	                    throw new Exception("Browser not supported.");
	            }
	        } else if (REMOTE.equals(MODE)) {
	        	System.out.println("remoteeeeeeee!");
	            switch (BROWSER) {
	                case CHROME:
	                    driver = new RemoteWebDriver(new URL(SELENIUM_SERVER), DesiredCapabilities.chrome());
	                    break;
	                case FIREFOX:
	                    driver = new RemoteWebDriver(new URL(SELENIUM_SERVER), DesiredCapabilities.firefox());
	                    break;
	                case INTERNET_EXPLORER:
	                    driver = new RemoteWebDriver(new URL(SELENIUM_SERVER), DesiredCapabilities.internetExplorer());
	                    break;
	                default:
	                    throw new Exception("Browser not supported.");
	            }
	        } else {
	        	System.out.println("exception to be thrown");
	            throw new Exception("Mode: " + MODE + " is not supported.");
	        }
        } catch(Exception exception) {
        	exception.printStackTrace();
        }
    }
	public static void testCase(Object name){
		System.out.println("____________________________________________________");
		System.out.println("[test case: " + name + "]");
	}
    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
