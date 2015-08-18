package com.praxis.siho.test.pages.main.psp;

import com.gargoylesoftware.htmlunit.PromptHandler;
import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.FileHandler;

import static com.praxis.siho.test.common.constants.PageURLsConstants.*;
/**
 * Created by administrativo on 30/07/15.
 */
public class CatalogoPlantillasPage extends Page<CatalogoPlantillasPage> {

    @FindBy(how = How.ID, using = "formTabla:j_idt72")
    private WebElement nuevoBtn;

    @FindBy(how = How.ID, using = "formTabla:j_idt73")
    private WebElement eliminarBtn;

    @FindBy(how = How.ID, using = "formPlatillas:j_idt31")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formPlatillas:j_idt33")
    private WebElement atrasBtn;

    @FindBy(how = How.ID, using = "formPlatillas:nombrePlantilla")
    private WebElement nombrePlantillaTxt;

    @FindBy(how = How.ID, using = "formPlatillas:descripcionPlantilla")
    private WebElement descripcionTxt;

    @FindBy(how = How.ID, using = "formPlatillas:cboTipo_label")
    private WebElement tipoPlantillaLstLabel;
    @FindBy(how = How.ID, using = "formPlatillas:cboTipo_panel")
    private WebElement tipoPlantillaLstPanel;

    @FindBy(how = How.ID, using = "formPlatillas:cboNivel_label")
    private WebElement nivelLstLabel;
    @FindBy(how = How.ID, using = "formPlatillas:cboNivel_panel")
    private WebElement nivelLstPanel;

    @FindBy(how = How.ID, using = "formPlatillas:cboFases_label")
    private WebElement fasesLstLabel;
    @FindBy(how = How.ID, using = "formPlatillas:cboFases_panel")
    private WebElement fasesLstPanel;

    @FindBy(how = How.ID, using = "formPlatillas:cboActividad_label")
    private WebElement actividadLstLabel;
    @FindBy(how = How.ID, using = "formPlatillas:cboActividad_panel")
    private WebElement actividadLstPanel;

    @FindBy(how = How.ID, using = "formPlatillas:j_idt68:j_idt69_input")
    private WebElement seleccionarFile;

    @FindBy(how = How.ID, using = "formPlatillas:filefrm_content")
    private WebElement piper;
    public CatalogoPlantillasPage(WebDriver driver) {
        super(driver, PAGE_CAT_PLANTILLAS);
    }

    public void agregarPlantilla(){
        //TODO
        System.out.println("agregarPlantilla method");
        safeClick(nuevoBtn);
        System.out.println("zero");
        safeSendKeys(nombrePlantillaTxt, "sel nom Plantilla");
        System.out.println("one");
        safeSendKeys(descripcionTxt, "descripcion plantilla");
        System.out.println("twot");
        selectValueOnPrimefacesListInLoop(tipoPlantillaLstLabel, tipoPlantillaLstPanel, "Praxis");
        selectValueOnPrimefacesListInLoop(nivelLstLabel, nivelLstPanel, "Sel psp W169");
        System.out.println("three");
        selectValueOnPrimefacesListInLoop(fasesLstLabel, fasesLstPanel, "Sel fase Analisis C32");
        selectValueOnPrimefacesListInLoop(actividadLstLabel, actividadLstPanel, "Sel actividad J118");

        System.out.println("about to do crazy stuff");
        //getChildElements(seleccionarFile, "file").get(0).click();
        System.out.println(piper.getTagName());
        //WebElement file = getChildElements(seleccionarFile, "file").get(0);
        //System.out.println(file.getTagName());

        //safeClick(seleccionarFile);
        safeSendKeys(seleccionarFile, "/home/administrativo/Desktop/pdf4.pdf");
        safeClick(getChildElements(seleccionarFile, "button").get(0));
    }

}
