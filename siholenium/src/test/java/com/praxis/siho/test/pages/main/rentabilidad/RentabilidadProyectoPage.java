package com.praxis.siho.test.pages.main.rentabilidad;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_RENTABILIDAD_PROYECTO;
/**
 * Created by administrativo on 07/07/15.
 */
public class RentabilidadProyectoPage extends Page<RentabilidadProyectoPage>{

    @FindBy(how = How.ID, using = "formDatos:autocompleteProyectos_input")
    private WebElement cveProyectoTxt;

    @FindBy(how = How.ID, using = "formDatos:txtTipoVenta")
    private WebElement tipoVentaTxt;

    @FindBy(how = How.ID, using = "formDatos:txtNombreProyecto")
    private WebElement nombreProyectoTxt;

    @FindBy(how = How.ID, using = "formDatos:estatusProyecto_label")
    private WebElement estatusLstLabel;
    private String estatusSelectedXpath = "//*[@id=\"formDatos:estatusProyecto_panel\"]/div/ul/li[3]";

    @FindBy(how = How.ID, using = "formDatos:tableData:0:j_idt59")
    private WebElement editarRentabilidadProyecto;

    @FindBy(how = How.ID, using = "formRentabilidadProyecto:j_idt63")
    private WebElement divModalLayer;

    @FindBy(how = How.ID, using = "formRentabilidadProyecto:j_idt66")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formRentabilidadProyecto:j_idt67")
    private WebElement descargarBtn;

    @FindBy(how = How.ID, using = "formRentabilidadProyecto:j_idt68")
    private WebElement reporteOPBtn;

    @FindBy(how = How.ID, using = "formRentabilidadProyecto:j_idt71")
    private WebElement atrasBtn;

    @FindBy(how = How.ID, using = "formRentabilidadProyecto:tblAnalisisRentabilidad:1:j_idt249")
    private WebElement bcwsTxt;

    @FindBy(how = How.ID, using = "formRentabilidadProyecto:tblAnalisisRentabilidad:2:j_idt249")
    private WebElement bcwpsTxt;

    @FindBy(how = How.ID, using = "formRentabilidadProyecto:tblAnalisisRentabilidadMes:0:j_idt316")
    private WebElement programadoTxt;

    @FindBy(how = How.ID, using = "formRentabilidadProyecto:tblAnalisisRentabilidadMes:1:j_idt316")
    private WebElement terminadoTxt;

    @FindBy(how = How.ID, using = "messages")
    private WebElement responseMessage;

    @FindBy(how = How.ID, using = "formDatos:autocompleteProyectos_panel")
    private WebElement autoCompleteList;

    public RentabilidadProyectoPage(WebDriver driver) {
        super(driver, PAGE_RENTABILIDAD_PROYECTO);
    }

    public List<String> consultarRentabilidad(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        safeSendKeys(cveProyectoTxt, "PX1410");
        safeClick(navigateForWebElement(autoCompleteList, "ul:0", "li:0"));
        try {
            Thread.sleep(2000);
            safeClick(editarRentabilidadProyecto);
            //waitForWebElementNotDisplayed(divModalLayer);
            Thread.sleep(3000);
            jse.executeScript("scroll(0, 820);");
            System.out.println("three");
            safeClick(driver.findElement(By.id("formRentabilidadProyecto:tblAnalisisRentabilidad:1:j_idt247")));
            safeSendKeys(bcwsTxt, "6");
            System.out.println("five");
            safeClick(driver.findElement(By.id("formRentabilidadProyecto:tblAnalisisRentabilidad:2:j_idt247")));
            System.out.println("six");
            safeSendKeys(bcwpsTxt, "4");
            safeClick(driver.findElement(By.id("formRentabilidadProyecto:tblAnalisisRentabilidadMes:0:j_idt314")));
            safeSendKeys(programadoTxt, "5");
            safeClick(driver.findElement(By.id("formRentabilidadProyecto:tblAnalisisRentabilidadMes:1:j_idt314")));
            safeSendKeys(terminadoTxt,"7");
            jse.executeScript("scroll(0, -620);");
            safeClick(guardarBtn);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        safeClick(guardarBtn);
        List<String> msgs = new ArrayList<String>();
        List<WebElement> msgsList = navigateForWebElements(responseMessage, "div:0", "ul:0","li");
        for (WebElement list : msgsList){
            msgs.add(list.getText());
        }
        return msgs;
    }
}
