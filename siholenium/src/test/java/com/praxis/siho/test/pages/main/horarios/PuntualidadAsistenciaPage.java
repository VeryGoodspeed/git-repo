package com.praxis.siho.test.pages.main.horarios;

import com.praxis.siho.test.common.util.RandomData;
import com.praxis.siho.test.pages.Page;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_PUNTUALIDAD_ASIST;
/**
 * Created by administrativo on 03/07/15.
 */
public class PuntualidadAsistenciaPage extends Page<PuntualidadAsistenciaPage> {
    public final String SUCCESS = "Registro actualizado correctamente.";

    private int random = RandomData.generateRandomNumberFromAToB(2,606);
    @FindBy(how = How.ID, using = "j_idt29:selectOneMenuRecursos_label")
    private WebElement recursoLstLabel;
    @FindBy(how = How.ID, using = "j_idt29:selectOneMenuRecursos_panel")
    private WebElement recursoLstPanel;

    @FindBy(how = How.ID, using = "j_idt29:tableHorarios")
    private  WebElement registryTable;

    @FindBy(how = How.ID, using = "j_idt29:tableHorarios_data")
    private WebElement registryTbody;

    @FindBy(how = How.ID, using = "j_idt29:messages")
    private WebElement responseMessage;

    public PuntualidadAsistenciaPage(WebDriver driver) {
        super(driver, PAGE_PUNTUALIDAD_ASIST);
    }

    public String modificarHorasRegistradas(){
        String msg = null;
        System.out.println("modificarHorasRegistradas, before waiting");
        selectValueOnPrimefacesListInLoop(recursoLstLabel, recursoLstPanel, 698); //688 - RALA
        waitForWebElementDisplayed(registryTable);
        System.out.println("after waiting");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForWebElementDisplayed(navigateForWebElement(registryTable,"table:0"));
        System.out.println(" get tag name " +registryTable.getTagName());
        System.out.println(" get tag name " +navigateForWebElement(registryTable, "div:1").getTagName());
        System.out.println(" get tag name " +navigateForWebElement(registryTable, "div:1", "table:0").getTagName());
        System.out.println(" get tag name tbody: " + registryTbody.getTagName());

        List<WebElement> registros = getChildElements(registryTbody, "tr");
        System.out.println(" registros size: " + registros.size());
        System.out.println("anybody: " + registros.get(3).getTagName());
        System.out.println("anybody: possible " + navigateForWebElement(registros.get(0), "td:10").getText());
        WebElement editarBtn = navigateForWebElement(registros.get(3), "td:10", "span:0");
        WebElement checkBtn  = navigateForWebElement(registros.get(3), "td:10", "span:1");

        System.out.println("one");
        System.out.println(editarBtn.getTagName());
        System.out.println(checkBtn.getTagName());
        WebElement cancelBtn = navigateForWebElement(registros.get(3), "td:10", "span:2");
        System.out.println("twot");
        for (WebElement registro : registros){
            System.out.println("fecha?: " + navigateForWebElement(registro, "td:0").getText());
            String fecha = safeGetLabel(navigateForWebElement(registro, "td:0"));
            if (fecha != null && fecha.equals("13/08/2015")){
                if (safeGetLabel(navigateForWebElement(registro, "td:9")).trim().matches("(Si|No|Aceptado)")){
                    System.out.println("it did match the intended Scheiße, meine Freundin");
                }
            }
        }
        WebElement entradaTxt = driver.findElement(By.id("j_idt29:tableHorarios:3:j_idt50"));
        System.out.println("two");
        WebElement salidaTxt  = driver.findElement(By.id("j_idt29:tableHorarios:3:j_idt55"));
        System.out.println("three");
        safeClick(editarBtn);
        System.out.println("before entering data in input fields");
        safeSendKeys(entradaTxt, "10:30");
        safeSendKeys(salidaTxt,  "18:30");
        System.out.println("before pressing the button check to save changes");
        safeClick(checkBtn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg = safeGetLabel(navigateForWebElement(responseMessage, "div:0", "ul:0", "li:0"));
        System.out.println("message to be returned: " + msg);
        return msg;
    }
}
