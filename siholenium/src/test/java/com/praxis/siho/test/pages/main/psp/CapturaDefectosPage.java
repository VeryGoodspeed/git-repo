package com.praxis.siho.test.pages.main.psp;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.praxis.siho.test.common.constants.PageURLsConstants.*;
/**
 * Created by administrativo on 30/07/15.
 */
public class CapturaDefectosPage extends Page<CapturaDefectosPage> {

    @FindBy(how = How.ID, using = "j_idt29:selecTipoDefecto_label")
    private WebElement tipoDefectoLstLabel;
    @FindBy(how = How.ID, using = "j_idt29:selecTipoDefecto_panel")
    private WebElement tipoDefectoLstPanel;

    @FindBy(how = How.XPATH, using = "//*[@id=\"j_idt29:calendarFecha\"]/button/span[1]")
    private WebElement datePickerStarter;

    @FindBy(how = How.ID, using = "ui-datepicker-div")
    private WebElement uiDatePickerDiv;

    @FindBy(how = How.ID, using = "j_idt29:descripcion")
    private WebElement descProblemaTxt;

    @FindBy(how = How.ID, using = "j_idt29:causaRaiz")
    private WebElement causaRaizTxt;

    @FindBy(how = How.ID, using = "j_idt29:j_idt59")
    private WebElement capturaBtn;

    @FindBy(how = How.ID, using = "j_idt29:cuentSoluciones")
    private WebElement cuantosDefectosIgualesTxt;

    @FindBy(how = How.ID, using = "j_idt29:selectInyectado_label")
    private WebElement inyeccionLstLabel;

    @FindBy(how = How.ID, using = "j_idt29:selectInyectado_panel")
    private WebElement inyeccionLstPanel;

    @FindBy(how = How.ID, using = "j_idt29:selectCompilacion_label")
    private WebElement remocionLstLabel;

    @FindBy(how = How.ID, using = "j_idt29:selectCompilacion_panel")
    private WebElement remocionLstPanel;

    @FindBy(how = How.ID, using = "j_idt29:MisProyectos_label")
    private WebElement proyectosLstLabel;

    @FindBy(how = How.ID, using = "j_idt29:MisProyectos_panel")
    private WebElement proyectosLstPanel;

    @FindBy(how = How.ID, using = "j_idt29:ciclo_label")
    private WebElement cicloLstLabel;

    @FindBy(how = How.ID, using = "j_idt29:ciclo_panel")
    private WebElement cicloLstPanel;

    @FindBy(how = How.ID, using = "j_idt29:fase_label")
    private WebElement faseLstLabel;

    @FindBy(how = How.ID, using = "j_idt29:fase_panel")
    private WebElement faseLstPanel;

    @FindBy(how = How.ID, using = "j_idt29:actividades_label")
    private WebElement actividadesLstLabel;

    @FindBy(how = How.ID, using = "j_idt29:actividades_panel")
    private WebElement actividadesLstPanel;

    @FindBy(how = How.ID, using = "j_idt29:j_idt34")
    private WebElement guardarBtn;

    @FindBy(how = How.LINK_TEXT, using = "Bitácora Defectos ")
    private WebElement bitacoraDefectosBtn;

    public CapturaDefectosPage(WebDriver driver) {
        super(driver, PAGE_CAPTURA_DEFECTOS);
    }
    public void capturarDefecto(String cicloPsp){
        selectValueOnPrimefacesList(tipoDefectoLstLabel, tipoDefectoLstPanel, "SINTAXIS");
       // setDateOnPicker(datePickerStarter, uiDatePickerDiv, "10", "8", "2015");

        selectValueOnPrimefacesListInLoop(proyectosLstLabel, proyectosLstPanel, 1);
        selectValueOnPrimefacesListInLoop(cicloLstLabel, cicloLstPanel, cicloPsp);
        selectValueOnPrimefacesListInLoop(faseLstLabel, faseLstPanel, 3);
        selectValueOnPrimefacesListInLoop(actividadesLstLabel, actividadesLstPanel, 1);

        safeSendKeys(descProblemaTxt, "error de compilador");
        safeSendKeys(causaRaizTxt, "explotó la máquina");
        safeSendKeys(cuantosDefectosIgualesTxt, "7");

        selectValueOnPrimefacesListInLoop(inyeccionLstLabel, inyeccionLstPanel, "3. CODIFICACIÓN");
        selectValueOnPrimefacesListInLoop(remocionLstLabel, remocionLstPanel, "4. COMPILACIÓN");
        scrollUpOrDown(-150);
        safeClick(guardarBtn);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
