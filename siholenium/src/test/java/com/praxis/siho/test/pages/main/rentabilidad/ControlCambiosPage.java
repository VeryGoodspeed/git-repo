package com.praxis.siho.test.pages.main.rentabilidad;

import com.gargoylesoftware.htmlunit.WebWindowListener;
import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.ArrayList;
import java.util.List;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_CONTROL_CAMBIOS;
import static com.praxis.siho.test.common.util.Validator.isNaN;

/**
 * Created by administrativo on 07/07/15.
 */
public class ControlCambiosPage extends Page<ControlCambiosPage> {
    public final String SUCCESS = "Registro almacenado correctamente.";

    @FindBy(how = How.XPATH, using = "//*[@id=\"formConsultaControlCambios:j_idt42\"]/h3")
    private WebElement busquedaAccordion;

    @FindBy(how = How.ID, using = "formConsultaControlCambios:j_idt32")
    private WebElement nuevoBtn;

    @FindBy(how = How.ID, using = "formConsultaControlCambios:j_idt33")
    private  WebElement eliminarBtn;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:j_idt69")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:j_idt75")
    private WebElement atrasBtn;

    @FindBy(how = How.ID, using = "formConsultaControlCambios:j_idt42:selectOneMenu_Proyecto_input")
    private WebElement cveProyTxt;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:inputFase")
    private WebElement faseTxt;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_NombreSolicitante")
    private WebElement nombreTxt;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_Telefono")
    private WebElement telefonoTxt;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_Area")
    private WebElement areaTxt;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_Email")
    private WebElement emailTxt;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:text_Descripcion")
    private WebElement descripcionTxt;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:text_Justificacion")
    private WebElement justificacionTxt;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:checkbox_Tipo")
    private WebElement tipoCambio;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_ReqNuevos")
    private WebElement reqNumNuevos;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_ReqAfectados")
    private WebElement reqNumAfectados;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_ProdNuevos")
    private WebElement prodNumNuevos;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_ProdAfectados")
    private WebElement prodNumAfectados;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:j_idt182")
    private WebElement reqNuevoBtn;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:j_idt183")
    private WebElement reqEliminarBtn;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_HrsAdicionales")
    private WebElement hrsAdicionalesTxt;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_CostoHora")
    private WebElement costoHoraTxt;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formNuevoControlDeCambios:calendar_FechaProgramada\"]/button/span[1]")
    private WebElement pickCalendarStarter;
    @FindBy(how = How.ID, using = "ui-datepicker-div")
    private  WebElement uiDatepickerDiv;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_IngresoAdicional")
    private WebElement ingresoAdicionalTxt;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formNuevoControlDeCambios:selectOneRadio_Facturable\"]/tbody/tr/td[1]/div/div[2]/span")
    private WebElement factClSiRadio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formNuevoControlDeCambios:selectOneRadio_Facturable\"]/tbody/tr/td[3]/div/div[2]/span")
    private WebElement factClNoRadio;

    @FindBy(how = How.ID, using = "formNuevoControlDeCambios:input_DirectorGeneral")
    private WebElement directorGeneralTxt;

    @FindBy(how = How.ID, using = "messagesG")
    private WebElement responseMessage;

    @FindBy(how = How.ID, using = "j_idt24")
    private WebElement modalLayer;

    public ControlCambiosPage(WebDriver driver) {
        super(driver, PAGE_CONTROL_CAMBIOS);
    }

    public List<String> crearNuevoControlCambio(){
        System.out.println("crearNuevoControlCambio");
        List<String> msgs = new ArrayList<String>();
        System.out.println("before pressing neuvoButton");
        safeClick(busquedaAccordion);
        //safeClick(nuevoBtn);
        System.out.println("passed");

        waitForWebElementDisplayed(cveProyTxt);
        System.out.println("before sending cve");
        safeSendKeys(cveProyTxt, "PX1508-SIHO4");
        System.out.println("waiting for modal layer");
        waitForWebElementNotDisplayed(modalLayer);
        safeSendKeys(faseTxt,     "Sprint 2");
        safeSendKeys(nombreTxt,   "Susana Castañeda");
        safeSendKeys(areaTxt,     "SCVI");
        safeSendKeys(telefonoTxt, "50800048");
        safeSendKeys(emailTxt,    "cafl@praxis.com.mx");
        safeSendKeys(descripcionTxt,   "Se requiere agregar la funcionalidad del Módulo de Rentabilidad de Cursos Actualización al Catálogo de Proyectos para que pueda  capturarse la información necesaria para que opere  la Rentabilidad de Cursos");
        safeSendKeys(justificacionTxt, "En el catálogo de proyectos  se tiene actualmente la información de Proyectos y Cursos mezclada. Es necesario que a partir del  tipo de venta  se  genere la rentabilidad correspondiente.  Para ello es necesario agregar los campos   Curso, Tipo de curso, Total de horas, Participantes cobrados, Número de sesiones y Horas por sesión , así como desarrollar el módulo de Rentabilidad de Cursos..");

        System.out.println("before assigning webelements with checks");
        WebElement tecCheck        = navigateForWebElement(tipoCambio, "tbody:0", "tr:0", "td:0", "div:0", "div:1", "span:0");
        WebElement functionalCheck = navigateForWebElement(tipoCambio, "tbody:0", "tr:0", "td:2", "div:0", "div:1", "span:0");
        WebElement tiempoCheck     = navigateForWebElement(tipoCambio, "tbody:0", "tr:0", "td:4", "div:0", "div:1", "span:0");
        WebElement costoCheck      = navigateForWebElement(tipoCambio, "tbody:0", "tr:0", "td:6", "div:0", "div:1", "span:0");
        System.out.println("after assigning web elements to checks");
        safeClick(functionalCheck);
        System.out.println("after fucntional check");
        safeClick(costoCheck);
        System.out.println("after costoCheck");
        safeSendKeys(reqNumNuevos, "0");
        safeSendKeys(reqNumAfectados, "3");
        safeSendKeys(prodNumNuevos, "4");
        safeSendKeys(prodNumAfectados, "0");
        System.out.println("gouda");
        safeSendKeys(hrsAdicionalesTxt, "389.64");
        System.out.println("one");
        safeSendKeys(costoHoraTxt, "112.69");
        System.out.println("twot");
        safeSendKeys(ingresoAdicionalTxt, "43908.18");
        System.out.println("possible errrorrrr");
        safeClick(factClSiRadio);
        System.out.println("there were not errors");
        setDateOnPicker(pickCalendarStarter, uiDatepickerDiv, "20", "7", "2016");
        safeSendKeys(directorGeneralTxt, "Elsa Ramírez");
        System.out.println("before possible error");
        scrollUpOrDown(-250);
        System.out.println("after possible error");
        safeClick(guardarBtn);
        System.out.println("guardar button was pressed");
        List<WebElement> listNodes = navigateForWebElements(responseMessage, "div:0", "ul:0", "li");
        for (WebElement msg : listNodes) {
            msgs.add(safeGetLabel(msg));
            System.out.println("message to be returned: " + safeGetLabel(msg));
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msgs;
    }
}
