package com.praxis.siho.test.pages.main.horarios;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.List;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_CONSULTA_HORARIOS;
/**
 * Created by administrativo on 03/07/15.
 */
public class ConsultaHorariosPage extends Page<ConsultaHorariosPage> {
    @FindBy(how = How.ID, using = "j_idt22:selectOneMenuRecursos_label")
    private WebElement recursoLstLabel;

    @FindBy(how = How.XPATH, using = "//*[@id=\"j_idt22:selectOneMenuRecursos_panel\"]/div/ul/li[699]")
    private WebElement recursoLstOption;

    @FindBy(how = How.ID, using = "j_idt22:tableHorarios_data")
    private WebElement tbody;
    public ConsultaHorariosPage(WebDriver driver) {
        super(driver, PAGE_CONSULTA_HORARIOS);
    }

    public HashMap<String, String> consultarHorarios(String fechaParam){
        HashMap<String, String> locacionesAceptadas = new HashMap<String, String>();
        System.out.println("unblemished");
        safeSelectOptionOnPrimefacesList(recursoLstLabel, recursoLstOption);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> registros = getChildElements(tbody, "tr");
        System.out.println(this.getClass() +"------------------------------------------------------------------" +
                "\n registros size: \n" + registros.size());
        System.out.println("anybody: " + registros.get(0).getTagName());
        System.out.println("anybody: possible" + navigateForWebElement(registros.get(0), "td:8").getText());
        System.out.println("one " + fechaParam);
        for (WebElement registro : registros){
            String fecha = safeGetLabel(navigateForWebElement(registro, "td:0"));
            if (fecha != null && fecha.equals(fechaParam)){
                String validLocationText = safeGetLabel(navigateForWebElement(registro, "td:8")).trim();
                if (validLocationText.matches("(Si|No)")){
                    System.out.println("it did match the intended Scheiße, meine Freundin-------");
                    locacionesAceptadas.put("rangoEntrada", validLocationText);
                }
            }
        }
        return locacionesAceptadas;
    }
}
