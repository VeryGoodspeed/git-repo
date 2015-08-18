package com.praxis.siho.test.pages.main.horarios;

import com.praxis.siho.test.common.util.RandomData;
import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.naming.ldap.Control;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_CONTROL_HORARIOS;
/**
 * Created by administrativo on 03/07/15.
 */
public class ControlHorariosPage extends Page<ControlHorariosPage>{
    public final String ERROR_HORA_ENTRADA_MENOR_A_SALIDA = "La hora de ingreso no debe ser mayor a la hora de salida";
    public final String SUCCESS = "Horarios establecidos";

    @FindBy(how = How.ID, using = "formControlHorarios:j_idt38")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formControlHorarios:j_idt39")
    private WebElement cancelarBtn;

    @FindBy(how = How.ID, using = "formControlHorarios:j_idt40")
    private WebElement restaurarBtn;

    private int random = RandomData.generateRandomNumberFromAToZ(2,606);
    @FindBy(how = How.ID, using = "formControlHorarios:cboRecursos_label")
    private WebElement recursoLstLabel;
    private String recursoXpath = "//*[@id=\"formControlHorarios:cboRecursos_panel\"]/div/ul/li["+random+"]";

    @FindBy(how = How.XPATH, using = "//*[@id=\"formControlHorarios:cmb_tipo\"]/tbody/tr/td[1]/div/div[2]")
    private WebElement recursoRadio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formControlHorarios:cmb_tipo\"]/tbody/tr/td[3]/div/div[2]/span")
    private WebElement proyectoRadio;

    private int firstRandomHour = RandomData.generateRandomNumberFromAToZ(2,6);
    @FindBy(how = How.ID, using = "formControlHorarios:cboHorasDe_label")
    private WebElement horarioDeLstLabel;
    private String horarioDeXpath = "//*[@id=\"formControlHorarios:cboHorasDe_panel\"]/div/ul/li["+firstRandomHour+"]" ;

    private int secondRandomHour = RandomData.generateRandomNumberFromAToZ(7,48);
    @FindBy(how = How.ID, using = "formControlHorarios:cboHorasA_label")
    private WebElement horarioALstLabel;
    private final String horarioAxPath = "//*[@id=\"formControlHorarios:cboHorasA_panel\"]/div/ul/li["+secondRandomHour+"]";

    @FindBy(how = How.XPATH, using = "//*[@id=\"formControlHorarios:calendarInicio\"]/button/span[1]")
    private WebElement apartirDeCalendarClickable;
    @FindBy(how = How.ID, using = "ui-datepicker-div")
    private WebElement apartirDeCalendar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formControlHorarios:calendarHasta\"]/button/span[1]")
    private WebElement hastaCalendarClickable;
    @FindBy(how = How.ID, using = "ui-datepicker-div")
    private WebElement desdeCalendar;

    @FindBy(how = How.ID, using = "messages")
    private WebElement responseMessage;

    public ControlHorariosPage(WebDriver driver) {
        super(driver, PAGE_CONTROL_HORARIOS);
    }

    public String modificarHorario(){
        String msg = null;
        safeSelectOptionOnPrimefacesList(recursoLstLabel,   driver.findElement(By.xpath(recursoXpath)));
        safeSelectOptionOnPrimefacesList(horarioDeLstLabel, driver.findElement(By.xpath(horarioDeXpath)));
        safeSelectOptionOnPrimefacesList(horarioALstLabel,  driver.findElement(By.xpath(horarioAxPath)));
        safeClick(guardarBtn);
        waitForWebElementDisplayed(responseMessage);
        msg = safeGetLabel(responseMessage);
        System.out.println("about to return : "+ msg);
        return msg;
    }

}

