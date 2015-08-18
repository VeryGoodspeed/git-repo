package com.praxis.siho.test.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import com.google.common.base.Predicate;

public abstract class Page <T> extends BrowserBehaviour{
    
    protected final WebDriver driver;
    protected final String url;
    protected static Map<String, WebElement> menuNodes = new HashMap<String, WebElement>();
    public Page(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }
    
    @SuppressWarnings("unchecked")
    public T loadPage() {
        try {
            waitForPageToLoad();
            PageFactory.initElements(driver, this);
            return (T) this;
        } catch (Exception e) {
            return null;
        }
    }
    
    public T goToPage() {
        if (!url.equals(driver.getCurrentUrl())) {
            driver.get(url);
        }
        return loadPage();
    }
    
    public T refreshPage() {
        driver.get(url);      
        return loadPage();
    }
    
    public String getUrl() {
        return url;
    }
    
    protected void waitForPageToLoad() {
        waitForPageToLoad(MAX_TIME, POLLING_TIME);
    }
    
    private void waitForPageToLoad(long maxTime, long pollingTime) {
        new FluentWait<WebDriver>(driver).withTimeout(maxTime, TimeUnit.SECONDS).pollingEvery(pollingTime, TimeUnit.MILLISECONDS).until(pageLoadUrlCondition());
    }
    
    protected Predicate<WebDriver> pageLoadUrlCondition() {
        return new Predicate<WebDriver>() {
            public boolean apply(WebDriver driver) {
                return url.equals(driver.getCurrentUrl());
            }
        };
    }

    public void scrollUpOrDown(int offset){
        String move = String.valueOf(offset);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0," + move + ")");
    }
}
