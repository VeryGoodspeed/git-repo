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
		System.out.println("filling user name");
		fillUserName(userName);
		System.out.println("filling password");
		fillContrasegna(password);
		System.out.println("click on login");
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
