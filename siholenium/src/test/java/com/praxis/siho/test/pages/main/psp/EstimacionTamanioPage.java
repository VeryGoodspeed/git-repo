package com.praxis.siho.test.pages.main.psp;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.praxis.siho.test.common.constants.PageURLsConstants.*;
/**
 * Created by administrativo on 30/07/15.
 */
public class EstimacionTamanioPage extends Page<EstimacionTamanioPage> {
    public static final String SUCCESS = "Registro almacenado correctamente.";
    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt39")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formEstimacionTamano:MisProyectos_label")
    private WebElement proyectosLstLabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:MisProyectos_panel\"]/div/ul/li[2]")
    private WebElement proyectosOption;

    @FindBy(how = How.ID, using = "formEstimacionTamano:ciclo_label")
    private WebElement cicloPspLstLabel;
    @FindBy(how = How.ID, using = "formEstimacionTamano:ciclo_panel")
    private WebElement cicloPspLstPanel;
    private String cicloPspOptionXpath = "//*[@id=\"formEstimacionTamano:ciclo_panel\"]/div/ul/li[8]";

    @FindBy(how = How.ID, using = "formEstimacionTamano:fase_label")
    private WebElement faseLstLabel;
    @FindBy(how = How.ID, using = "formEstimacionTamano:fase_panel")
    private WebElement faseLstPanel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:fase_panel\"]/div/ul/li[2]")
    private WebElement faseOption;

    @FindBy(how = How.ID, using = "formEstimacionTamano:actividades_label")
    private WebElement actividadesLstLabel;
    @FindBy(how = How.ID, using = "formEstimacionTamano:actividades_panel")
    private WebElement actividadesLstPanel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:actividades_panel\"]/div/ul/li[2]")
    private WebElement actividadesOption;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt74")
    private WebElement playCronometroBtn;

    @FindBy(how = How.ID, using = "formEstimacionTamano:cboTipMedida_label")
    private WebElement tipoMedidaLstLabel;
    @FindBy(how = How.ID, using = "formEstimacionTamano:cboTipMedida_panel")
    private WebElement tipoMedidaLstPanel;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:j_idt84")
    private WebElement partesBaseNuevoBtn;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:j_idt85")
    private WebElement partesBaseEliminarBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt150\"]/span[1]")
    private WebElement partesBaseEditar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt150\"]/span[2]")
    private WebElement partesBaseGuardar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt150\"]/span[3]")
    private WebElement partesBaseCancelar;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt107")
    private WebElement partesBaseNombreTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt112")
    private WebElement partesBaseEstBaseTxt;
    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt117")
    private WebElement partesBaseEstRemovidosTxt;
    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt122")
    private WebElement partesBaseEstModificadosTxt;
    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt127")
    private WebElement partesBaseEstAgregadasTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt132")
    private WebElement partesBaseRealesBaseTxt;
    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt137")
    private WebElement partesBaseRealesRemovidosTxt;
    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt142")
    private WebElement partesBaseRealesModificadosTxt;
    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesBase:0:j_idt147")
    private WebElement partesBaseRealesAgregadasTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:j_idt168")
    private WebElement partesAdicionalesNuevoBtn;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:j_idt169")
    private WebElement partesAdicionalesEliminarBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79:tablePartesAdicionales:0:j_idt235\"]/span[1]")
    private WebElement partesAdicionalesEditar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79:tablePartesAdicionales:0:j_idt235\"]/span[2]")
    private WebElement partesAdicionalesGuardar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79:tablePartesAdicionales:0:j_idt235\"]/span[3]")
    private WebElement partesAdicionalesCancelar;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesAdicionales:0:j_idt191")
    private WebElement partesAdicionalesNombreTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesAdicionales:0:j_idt202")
    private WebElement partesAdicionalesEstObjetosTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesAdicionales:0:j_idt221")
    private WebElement partesAdicionalesRealesTamanoTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesAdicionales:0:j_idt226")
    private WebElement partesAdicionalesRealesObjetosTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:j_idt248")
    private WebElement partesReutilizablesNuevoBtn;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:j_idt249")
    private WebElement partesReutilizablesEliminarBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79:tablePartesReutilizables:0:j_idt278\"]/span[1]")
    private WebElement partesReutilizablesEditar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79:tablePartesReutilizables:0:j_idt278\"]/span[2]")
    private WebElement partesReutilizablesGuardar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79:tablePartesReutilizables:0:j_idt278\"]/span[3]")
    private WebElement partesReutilizablesCancelar;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesReutilizables:0:j_idt265")
    private WebElement partesReutilizablesNombreTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesReutilizables:0:j_idt270")
    private WebElement partesReutilizablesEstTamanoTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesReutilizables:0:j_idt275")
    private WebElement partesReutilizablesRealesTamanoTxt;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79\"]/h3[2]")
    private WebElement partesAdicionalesAccordion;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:j_idt79\"]/h3[3]")
    private WebElement partesReutilizablesAccordion;

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesAdicionales:0:cboEstimadoTipo_label")
    private WebElement partesAdicionalesEstTipoLstLabel;
    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesAdicionales:0:cboEstimadoTipo_panel")
    private WebElement partesAdicionalesEstTipoLstPanel;
    private final String PROCESS = "PROCESS";

    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesAdicionales:0:cboEstimadoTamReal_label")
    private WebElement partesAdicionalesEstTamanoRelativoLstLabel;
    @FindBy(how = How.ID, using = "formEstimacionTamano:j_idt79:tablePartesAdicionales:0:cboEstimadoTamReal_panel")
    private WebElement partesAdicionalesEstTamanoRelativoLstPanel;
    private final String GRANDE = "GRANDE";

    @FindBy(how = How.ID, using = "formEstimacionTamano:messages")
    private WebElement responseMessageDiv;

    public EstimacionTamanioPage(WebDriver driver) {
        super(driver, PAGE_ESTIMACION_TAMANIO);
    }

    public String estimarTamanio(String cicloPsp){
        String responseMessage = null;
        safeSelectOptionOnPrimefacesList(proyectosLstLabel, proyectosOption);
        selectValueOnPrimefacesList(cicloPspLstLabel, cicloPspLstPanel, cicloPsp, 2500);
        selectValueOnPrimefacesList(faseLstLabel, faseLstPanel, "4. COMPILACIÓN", 2500);
        selectValueOnPrimefacesList(actividadesLstLabel, actividadesLstPanel, "1. COMPILAR EL PROGRAMA HASTA QUE NO HAYA ERRORES", 2000);
        selectValueOnPrimefacesList(tipoMedidaLstLabel, tipoMedidaLstPanel, "PUNTOS DE COMPLEJIDAD JAVA", 1500);
        llenarPartesBase();
        llenarPartesAdicionales();
        llenarPartesReutilizables();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,-150)", "");
        safeClick(guardarBtn);
        responseMessage = getErrorMessagesFrom(responseMessageDiv).get(0);
        System.out.println("about to send: " + responseMessage);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseMessage;
    }

    public void llenarPartesReutilizables(){
        safeClick(partesReutilizablesAccordion);
        try{
            Thread.sleep(2000);
            safeClick(partesReutilizablesNuevoBtn);
            safeClick(partesReutilizablesEditar);
            safeSendKeys(partesReutilizablesNombreTxt, "sel");
            safeSendKeys(partesReutilizablesEstTamanoTxt, "4");
            safeSendKeys(partesReutilizablesRealesTamanoTxt, "3");
            safeClick(partesReutilizablesGuardar);
        } catch (InterruptedException e) {}
    }
    public void llenarPartesAdicionales(){
        safeClick(partesAdicionalesAccordion);
        try{
            Thread.sleep(2000);
            safeClick(partesAdicionalesNuevoBtn);
            safeClick(partesAdicionalesEditar);
            safeSendKeys(partesAdicionalesNombreTxt, "sel");
            safeSendKeys(partesAdicionalesEstObjetosTxt, "4");
            selectValueOnPrimefacesList(partesAdicionalesEstTipoLstLabel, partesAdicionalesEstTipoLstPanel, PROCESS);
            selectValueOnPrimefacesList(partesAdicionalesEstTamanoRelativoLstLabel, partesAdicionalesEstTamanoRelativoLstPanel, GRANDE, 3000);
            safeSendKeys(partesAdicionalesRealesObjetosTxt, "3");
            safeSendKeys(partesAdicionalesRealesTamanoTxt, "3");
            safeClick(partesAdicionalesGuardar);
        } catch (InterruptedException e) {}
    }

    public void llenarPartesBase(){
        try {
            Thread.sleep(2000);
            safeClick(partesBaseNuevoBtn);
            safeClick(partesBaseEditar);
            safeSendKeys(partesBaseNombreTxt, "Sel");;
            safeSendKeys(partesBaseEstBaseTxt, "3");
            safeSendKeys(partesBaseEstRemovidosTxt, "3");
            safeSendKeys(partesBaseEstModificadosTxt, "3");
            safeSendKeys(partesBaseEstAgregadasTxt, "3");
            safeSendKeys(partesBaseRealesBaseTxt, "3");
            safeSendKeys(partesBaseRealesRemovidosTxt, "3");
            safeSendKeys(partesBaseRealesModificadosTxt, "3");
            safeSendKeys(partesBaseRealesAgregadasTxt, "3");
            safeClick(partesBaseGuardar);

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
