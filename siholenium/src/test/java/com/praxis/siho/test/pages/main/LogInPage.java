package com.praxis.siho.test.pages.main;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_LOGIN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.praxis.siho.test.pages.Page;


public class LogInPage extends Page<LogInPage>{

	@FindBy(how = How.ID, using = "j_username")
	private WebElement userName;

	@FindBy(how = How.ID, using = "j_password")
	private WebElement password;

	@FindBy(how = How.ID, using = "btnLogin")
	private WebElement btnLogin;

	public LogInPage(WebDriver driver) {
		super(driver, PAGE_LOGIN);
	}

	public MainPage signon(String userName, String password) {
    	fillUserName(userName);  
    	System.out.println("after fill user name...");
    	fillContrasegna(password);
    	System.out.println("after fill passward name...");

		safeClick(btnLogin);
    	return new MainPage(driver).loadPage();
	} 
	
	public void fillUserName(String name){
    	safeSendKeys(userName, name);
    }
	
	public void fillContrasegna(String passward){
    	safeSendKeys(password, passward);
    }

}
