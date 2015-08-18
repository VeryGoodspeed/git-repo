package com.praxis.siho.test.pages.main.horarios;
import com.praxis.siho.test.pages.Page;
import com.thoughtworks.selenium.SeleneseTestNgHelper;
import com.thoughtworks.selenium.Selenium;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_REGISTRO_HORARIO;
/**
 * Created by administrativo on 03/07/15.
 */
public class RegistroHorariosPage extends Page<RegistroHorariosPage> {

    public final String SUCCESS = "El Horario se guardó satisfactoriamente.";

    @FindBy(how = How.ID, using = "formRegHorarios:btnGuardar")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formRegHorarios:messages")
    private WebElement messageResponse;

    @FindBy(how = How.ID, using = "formRegHorarios:fecha")
    private WebElement fechaTxt;

    @FindBy(how = How.ID, using = "formRegHorarios:hrEntradas")
    private WebElement hrEntradaTxt;

    @FindBy(how = How.ID, using = "formRegHorarios:hrSalida")
    private WebElement hrSalidaTxt;


    public RegistroHorariosPage(WebDriver driver) {
        super(driver, PAGE_REGISTRO_HORARIO);
    }

    public String guardarHorarios(){
        waitForWebElementDisplayed(guardarBtn);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        safeClick(guardarBtn);
        waitForWebElementDisplayed(messageResponse);
        return safeGetLabel(navigateForWebElement(messageResponse, "div:0", "ul:0", "li:0"));
    }
    public HashMap<String, String> obtenerFechaConGuardadoHorario(){
        HashMap<String, String> txts = new HashMap<String,String>();
        waitForWebElementDisplayed(guardarBtn);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        txts.put("fecha", safeGetInputText(fechaTxt));
        txts.put("hrEntrada", safeGetInputText(hrEntradaTxt));
        txts.put("hrEntrada", safeGetInputText(hrSalidaTxt));
        safeClick(guardarBtn);
        waitForWebElementDisplayed(messageResponse);
        safeGetLabel(navigateForWebElement(messageResponse, "div:0", "ul:0", "li:0"));
        return txts;
    }
}
