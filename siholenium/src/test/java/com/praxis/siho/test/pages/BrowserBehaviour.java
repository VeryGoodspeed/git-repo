package com.praxis.siho.test.pages;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Predicate;

import static com.praxis.siho.test.common.util.Validator.isNaN;

public class BrowserBehaviour {

    WebDriver driver;
    public BrowserBehaviour(){}

    public BrowserBehaviour(WebDriver driver){
        this.driver = driver;
    }
    protected static final long POLLING_TIME = 500; //Milliseconds
    protected static final long MAX_TIME = 50; 		//Seconds
    protected static final int MAX_LOOP = 16;
	
    public String safeGetLabel(WebElement element) {
        try {
            waitForWebElementDisplayed(element);
            return element.getText();
        } catch (Exception e) {
            return null;
        }
    }
    public String safeGetInputText(WebElement element) {
        try {
            waitForWebElementDisplayed(element);
            return element.getAttribute("value");
        } catch (Exception e) {
            return null;
        }
    }
       
    public boolean areLabelsWithValuesPresent(Map<String, WebElement> labels, Properties values) {
        boolean flag = true;
        for (String key : labels.keySet()) {
            flag = flag & isLabelWithTextPresent(labels.get(key), (String) values.get(key));
        }
        return flag;
    }
    
    public boolean isLabelWithTextPresent(WebElement element, String text) {
        try {
            waitForWebElement(element, webElementWithSpecificTextCondition(text), 15, POLLING_TIME);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void safeSelectValue(WebElement element, String value) {    	
        if (value != null) {
            waitForWebElementDisplayed(element);
            new Select(element).selectByValue(value);
        }
    }

    public void safeSelectOptionOnPrimefacesList(WebElement labelFromList, WebElement optionFromList) {
    	safeClick(labelFromList);
        safeClick(optionFromList);
    }

    public void selectValueOnPrimefacesList(WebElement listLabelStarter, WebElement listOptionsPanel, String txtOption){
        selectValueOnPrimefacesList(listLabelStarter, listOptionsPanel, txtOption, 500);
    }
    public void selectValueOnPrimefacesList(WebElement listLabelStarter, WebElement listOptionsPanel, int index){
        selectValueOnPrimefacesList(listLabelStarter, listOptionsPanel, index, 500);
    }
    public void selectValueOnPrimefacesList(WebElement listLabelStarter, WebElement listOptionsPanel, String txtOption, int wait){
        try {
            Thread.sleep(wait);
            safeClick(listLabelStarter);
            List<WebElement> optionsSelection = navigateForWebElements(listOptionsPanel, "div:0", "ul:0", "li");
            for(WebElement option : optionsSelection){
                //System.out.println(option.getText() + " == " + txtOption + ": " + option.getText().matches("(" + txtOption + ")"));
                if (option.getText().trim().equals(txtOption.trim())) {
                    safeClick(option);
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectValueOnPrimefacesList(WebElement listLabelStarter, WebElement listOptionsPanel, int index, int wait){
        try {
            Thread.sleep(wait);
            safeClick(listLabelStarter);
            List<WebElement> optionsSelection = navigateForWebElements(listOptionsPanel, "div:0", "ul:0", "li");
            optionsSelection.get(index).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectValueOnPrimefacesListInLoop(WebElement listLabelStarter, WebElement listOptionsPanel, String txtOption){
        selectValueOnPrimefacesListInLoop(listLabelStarter, listOptionsPanel, txtOption, MAX_LOOP);
    }
    public void selectValueOnPrimefacesListInLoop(WebElement listLabelStarter, WebElement listOptionsPanel, String txtOption, int loop){
        waitForWebElementEnabled(listOptionsPanel);
        for (int i = 0; i < loop; i++) {
            try {
                int count = 0;
                safeClick(listLabelStarter);
                waitForWebElementEnabled(listOptionsPanel);
                while(!listOptionsPanel.isDisplayed()) {
                    count++;
                    safeClick(listLabelStarter);
                    if (count > loop){break;}
                }
                List<WebElement> optionsSelection = navigateForWebElements(listOptionsPanel, "div:0", "ul:0", "li");
                if (optionsSelection == null) {
                    System.out.println("navigateForWebElements returned null");
                } else {
                    for(WebElement option : optionsSelection){
                        //System.out.println(option.getText() + " == " + txtOption + ": " + option.getText().matches("(" + txtOption + ")"));
                        if (option.getText().trim().equals(txtOption.trim())) {
                            safeClick(option);
                            return;
                        }
                    }
                }
                safeClick(listLabelStarter);
            }catch (StaleElementReferenceException sere){ System.out.println("stale element prevented");}
        }
    }
    public void selectValueOnPrimefacesListInLoop(WebElement listLabelStarter, WebElement listOptionsPanel, int index){
        selectValueOnPrimefacesListInLoop(listLabelStarter, listOptionsPanel, index, MAX_LOOP);
    }
    public void selectValueOnPrimefacesListInLoop(WebElement listLabelStarter, WebElement listOptionsPanel, int index, int loop){
        waitForWebElementEnabled(listOptionsPanel);
        for (int i = 0; i < loop; i++) {
            try {
                int count = 0;
                safeClick(listLabelStarter);
                waitForWebElementEnabled(listOptionsPanel);
                while(!listOptionsPanel.isDisplayed()) {
                    count++;
                    safeClick(listLabelStarter);
                    if (count > loop){break;}
                }
                List<WebElement> optionsSelection = navigateForWebElements(listOptionsPanel, "div:0", "ul:0", "li");
                if (optionsSelection == null) {
                    System.out.println("navigateForWebElements returned null");
                } else if (optionsSelection.size() >= index) {
                    optionsSelection.get(index).click();
                    return;
                }
                safeClick(listLabelStarter);
            }catch (StaleElementReferenceException sere){ System.out.println("stale element prevented");}
        }
    }

    public List<String> getErrorMessagesFrom(WebElement responseMessageDiv){
        List<WebElement>responseList = navigateForWebElements(responseMessageDiv, "div:0", "ul:0", "li");
        List<String> responseMessages = new ArrayList<String>();
        for (WebElement message : responseList){
            responseMessages.add(message.getText());
        }
        return responseMessages;
    }
    public void safeSendKeys(WebElement element, String keys) {
        if (keys != null) {
            waitForWebElementDisplayed(element);
            element.clear();
            element.sendKeys(keys);
        }
    }
    
    public void safeClick(WebElement element) {
        waitForWebElementClickable(element);
        element.click();
    }
    
    public List<WebElement> getChildElements(WebElement parent, String tagName) {
        try {
            waitForWebElementDisplayed(parent);
            return parent.findElements(By.tagName(tagName));
        } catch (Exception e) {
            return null;
        }
    }
    
    public void waitForWebElementDisplayed(WebElement webElement) {
        waitForWebElement(webElement, webElementDisplayedCondition(), MAX_TIME, POLLING_TIME);
    }
    public void waitForWebElementTextChangedDisplayed(WebElement webElement, String text){
        waitForWebElement(webElement, webElementTextChangedDisplayedCondition(text), MAX_TIME, POLLING_TIME);
    }
    public void waitForWebElementTextDisplayed(WebElement webElement) {
        waitForWebElement(webElement, webElementTextDisplayedCondition(), MAX_TIME, POLLING_TIME);
    }
    public void waitForWebElementNotDisplayed(WebElement webElement) {
        waitForWebElement(webElement, webElementNotDisplayedCondition(), MAX_TIME, POLLING_TIME);
    }
    public void waitForWebElementEnabled(WebElement webElement) {
        waitForWebElement(webElement, webElementEnabledCondition(), MAX_TIME, POLLING_TIME);
    }
    public void waitForWebElementDisplayed(WebElement webElement, long maxTime, long poolingTime) {
        waitForWebElement(webElement, webElementDisplayedCondition(), maxTime, POLLING_TIME);
    }
    public void waitForWebElementClickable(WebElement webElement) {
        waitForWebElement(webElement, webElementClickableCondition(), MAX_TIME, POLLING_TIME);
    }
    public void waitForWebElementClickable(WebElement webElement, long maxTime, long poolingTime) {
        waitForWebElement(webElement, webElementClickableCondition(), maxTime, poolingTime);
    }
    public void waitForWebElement(WebElement webElement, Predicate<WebElement> condition, long maxTime, long pollingTime) {
        new FluentWait<WebElement>(webElement).pollingEvery(pollingTime, TimeUnit.MILLISECONDS).withTimeout(maxTime, TimeUnit.SECONDS)
                .ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class).until(condition);
    }
    @Deprecated
    protected Predicate<WebElement> webElementTextChangedDisplayedCondition(final String text) {
        return new Predicate<WebElement>() {
            public boolean apply(WebElement webElement) {
                waitForWebElementDisplayed(webElement);
                return webElement.isDisplayed() && webElement.isEnabled() && !webElement.getAttribute("value").equals("") && !webElement.getAttribute("value").equals(text);
            }
        };
    }
    protected Predicate<WebElement> webElementTextDisplayedCondition() {
        return new Predicate<WebElement>() {
            public boolean apply(WebElement webElement) {
                return webElement.isDisplayed() && webElement.isEnabled() && !webElement.getAttribute("value").equals("");
            }
        };
    }
    protected Predicate<WebElement> webElementDisplayedCondition() {
        return new Predicate<WebElement>() {
            public boolean apply(WebElement webElement) {            	
                return webElement.isDisplayed() && webElement.isEnabled();
            }
        };
    }
    protected Predicate<WebElement> webElementNotDisplayedCondition() {
        return new Predicate<WebElement>() {
            public boolean apply(WebElement webElement) {
                return !webElement.isDisplayed() && webElement.isEnabled();
            }
        };
    }
    protected Predicate<WebElement> webElementClickableCondition() {
        return new Predicate<WebElement>() {
            public boolean apply(WebElement webElement) {
                return webElement.isDisplayed() && webElement.isEnabled() && webElement.getSize().getHeight() > 0 && webElement.getSize().getWidth() > 0;
            }
        };
    }
    protected Predicate<WebElement> webElementEnabledCondition() {
        return new Predicate<WebElement>() {
            public boolean apply(WebElement webElement) {
                return webElement.isEnabled();
            }
        };
    }
    protected Predicate<WebElement> webElementWithSpecificTextCondition(final String text) {
        return new Predicate<WebElement>() {
            public boolean apply(WebElement webElement) {
                return webElement.isDisplayed() && webElement.getText().equals(text);
            }
        };
    }
    public List<WebElement> navigateForWebElements(WebElement webElement, String...tags_indexes){
        List<String> tagsIndexesList = new ArrayList<String>(Arrays.asList(tags_indexes));
        return fetchWebElements(webElement, tagsIndexesList);
    }
    public List<WebElement> riskyNavigationForWebElements(WebElement webElement, String...tags_indexes){
        List<String> tagsIndexesList = new ArrayList<String>(Arrays.asList(tags_indexes));
        System.out.println("before disaster");
        return riskyFetchWebElements(webElement, tagsIndexesList);
    }

    /**
     * It returns the WebElement specified at the end of the tags hierarchy passed as a string array with the format:<p />
     * <b>"tagName:indexNumber".</b> (e.g.: "table:0", "tbody:0", "tr:3", "td:5" [in this case the element to be returned
     * is the fifth &lt;td&gt; in the row defined as the third &lt;tr&gt;])
     * this navigation starts at the webElement passed as first argument.
     * @param webElement
     * @param tags_indexes
     * @return WebElement
     */
    public WebElement navigateForWebElement(WebElement webElement, String...tags_indexes) {
        //List<String> tagsIndexesList = new ArrayList<String>(Arrays.asList(tags_indexes));
        List<String> tagsIndexesList = new LinkedList<String>(Arrays.asList(tags_indexes));
        return fetchWebElement(webElement, tagsIndexesList);
    }
    private WebElement fetchWebElement(WebElement webElement, List<String> tagsIndexesList){
        if (!tagsIndexesList.isEmpty()){
            String [] tagIndex = tagsIndexesList.remove(0).split(":");
            String tag = tagIndex[0];
            int index = Integer.parseInt(tagIndex[1]);
            return fetchWebElement(getChildElements(webElement, tag).get(index), tagsIndexesList);
        } else {
            return webElement;
        }
    }

    /**
     *
     * @param webElement
     * @param tagsIndexesList
     * @return List<WebElement>
     */
    private List<WebElement> fetchWebElements(WebElement webElement, List<String> tagsIndexesList){
        if (!tagsIndexesList.isEmpty() && tagsIndexesList.size() == 1){
            String [] tagIndex = tagsIndexesList.remove(0).split(":");
            String tag = tagIndex[0];
            return getChildElements(webElement, tag);
        }else if (!tagsIndexesList.isEmpty()){
            String [] tagIndex = tagsIndexesList.remove(0).split(":");
            String tag = tagIndex[0];
            int index = Integer.parseInt(tagIndex[1]);
            return fetchWebElements(getChildElements(webElement, tag).get(index), tagsIndexesList);
        } else {
            return null;
        }
    }

    private List<WebElement> riskyFetchWebElements(WebElement webElement, List<String> tagsIndexesList){
        if (!tagsIndexesList.isEmpty() && tagsIndexesList.size() == 1){
            String [] tagIndex = tagsIndexesList.remove(0).split(":");
            String tag = tagIndex[0];
            return webElement.findElements(By.tagName(tag));
        }else if (!tagsIndexesList.isEmpty()){
            String [] tagIndex = tagsIndexesList.remove(0).split(":");
            String tag = tagIndex[0];
            int index = Integer.parseInt(tagIndex[1]);
            return riskyFetchWebElements(webElement.findElements(By.tagName(tag)).get(index), tagsIndexesList);
        } else {
            return null;
        }
    }

    /**
     * Handle datepicker widget generated by primefaces, passing on:
     * <ul>
     * <li>datePickerStarter: is the web component that is clicked on in order to display the calendar.</li>
     * <li>uiDatepickerDiv: is the web component assigned as the calendar's container (div tag)</li>
     * <li>day: is the day of the month that is to be selected</li>
     * <li>month: the month to be selected in numerical terms</li>
     * <li>year: the year to be selected</li>
     * </ul>
     * @param datePickerStarter
     * @param uiDatepickerDiv
     * @param day
     * @param month
     * @param year
     */
    public void setDateOnPicker(WebElement datePickerStarter, WebElement uiDatepickerDiv, String day, String month, String year){
        safeClick(datePickerStarter);
        WebElement selectMonth = navigateForWebElement(uiDatepickerDiv, "div:0", "div:0", "select:0");
        month = String.valueOf(Integer.parseInt(month)+1);
        safeSelectValue(selectMonth, month);
        WebElement selectYear = navigateForWebElement(uiDatepickerDiv, "div:0", "div:0", "select:1");
        safeSelectValue(selectYear, year);
        List<WebElement> calendarButtons = getDayButtonsList(uiDatepickerDiv);
        safeClick(calendarButtons.get(Integer.parseInt(day) - 1));
    }
    private List<WebElement> getDayButtonsList(WebElement table){
        List<WebElement> dayButtons = new ArrayList<WebElement>();
        List<WebElement> trs = navigateForWebElements(table, "tbody:0", "tr");
        for (WebElement tr : trs) {
            List<WebElement> tds = getChildElements(tr, "td");
            for (int i = 0; i < tds.size(); i++) {
                if (!isNaN(tds.get(i).getText())) {
                    tds.remove(tds.get(i));
                } else {
                    dayButtons.add(tds.get(i));
                }
            }
        }
        return dayButtons;
    }
}
