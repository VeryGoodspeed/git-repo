package com.praxis.siho.test.pages.main.proyectos;

/**
 * Created by administrativo on 24/06/15.
 */
import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.ArrayList;
import java.util.List;
import static com.praxis.siho.test.common.util.Validator.isNaN;
import static com.praxis.siho.test.common.util.RandomData.generateRandomNumberFromAToZ;
import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_CATALOGO_PROYECTOS;
public class CatalogoProyectosPage extends Page<CatalogoProyectosPage>{

    @FindBy(how = How.XPATH, using = "//*[@id=\"formCatalogodeProyectos:j_idt39\"]/h3")
    private WebElement accordion;

    @FindBy(how = How.ID, using = "formCatalogodeProyectos:j_idt32:selectOneMenu3_label")
    private WebElement proyectoLstLabel;
    int random = generateRandomNumberFromAToZ(2, 90);
    private String projectOptionXpath = "//*[@id=\"formCatalogodeProyectos:j_idt32:selectOneMenu3_panel\"]/div/ul/li["+random+"]";

    @FindBy(how = How.ID, using = "formCatalogodeProyectos:j_idt27")
    private WebElement nuevoBtn;

    @FindBy(how = How.ID, using = "formCatalogodeProyectos:j_idt28")
    private WebElement eliminarBtn;

    @FindBy(how = How.ID, using = "formCatalogodeProyectos:table_data")
    private WebElement tbody;

    @FindBy(how = How.ID, using = "formCatalogoProyectos:calendar_fechaVig_input")
    private WebElement fechaVigenciaInputtxtReadonly;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]")
    private WebElement suspiciousLayer;
                                     //*[@id="formCatalogoProyectos:calendar_fechaVig"]/button/span[1]
    @FindBy(how = How.XPATH, using ="//*[@id=\"formCatalogoProyectos:calendar_fechaVig\"]/button/span[1]")
    private WebElement fechVigenciaCalendar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"j_idt23_modal\"]")
    private WebElement modalLayer;

    @FindBy(how = How.ID, using = "ui-datepicker-div")
    private WebElement datepicker;

    @FindBy(how = How.ID, using = "formCatalogoProyectos:j_idt73")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using =  "formCatalogoProyectos:messages")
    private WebElement successMsg;

    @FindBy(how = How.ID, using = "formCatalogoProyectos:selectOneMenu_gerente_label")
    private WebElement gerenteLstLabel;
    private String gerenteOptionXpath = "//*[@id=\"formCatalogoProyectos:selectOneMenu_gerente_panel\"]/div/ul/li["
                                      + generateRandomNumberFromAToZ(2, 123) + "]";

    @FindBy(how = How.ID, using = "formCatalogoProyectos:selectOneMenu_detalleTipoVenta_label")
    private WebElement detalleTipoVentaListlabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formCatalogoProyectos:selectOneMenu_detalleTipoVenta_panel\"]/div/ul/li[3]")
    private WebElement detalleTipoVentaOption;

    @FindBy(how = How.ID, using = "formCatalogoProyectos:selectOneMenu_tipoVenta_label")
    private WebElement tipoVentaListlabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formCatalogoProyectos:selectOneMenu_tipoVenta_panel\"]/div/ul/li[3]")
    private WebElement tipoVentaOption;

    @FindBy(how = How.ID, using = "formCatalogoProyectos:selectOneMenu_cuenta_label")
    private WebElement cuentaLstLabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formCatalogoProyectos:selectOneMenu_cuenta_panel\"]/div/ul/li[27]")
    private WebElement cuentaOption;

    @FindBy(how = How.ID, using = "formCatalogoProyectos:selectOneMenu_tAsignacion_label")
    private WebElement asignacionLstLabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formCatalogoProyectos:selectOneMenu_tAsignacion_panel\"]/div/ul/li[6]")
    private WebElement asignacionOption;

    @FindBy(how = How.ID, using = "formCatalogoProyectos:selectOneMenu_cataActividades_label")
    private WebElement actividadesLstLabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formCatalogoProyectos:selectOneMenu_cataActividades_panel\"]/div/ul/li[33]")
    private WebElement actividadesOption;

    @FindBy(how = How.ID, using = "formCatalogoProyectos:selectOneMenu_centroCosto_label")
    private WebElement centroCostoLstLabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formCatalogoProyectos:selectOneMenu_centroCosto_panel\"]/div/ul/li[7]")
    private WebElement centroCostoOption;

    @FindBy(how = How.ID, using = "formCatalogoProyectos:selectOneMenu_responsable_label")
    private WebElement responsableLstLabel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"formCatalogoProyectos:selectOneMenu_responsable_panel\"]/div/ul/li[10]")
    private WebElement responsableOption;

    @FindBy(how = How.ID, using = "formCatalogoProyectos:input_numRecurso")
    private WebElement numeroRecursosTxt;

    public CatalogoProyectosPage(WebDriver driver) {
        super(driver, PAGE_CATALOGO_PROYECTOS);
    }

    public List<WebElement> modificarFechaVigencia(){
        System.out.println("method: modificarFechaVigencia" );
        List<WebElement> msgLista = new ArrayList<WebElement>();
        safeClick(accordion);
        WebElement projectOption = driver.findElement(By.xpath(projectOptionXpath));
        safeSelectOptionOnPrimefacesList(proyectoLstLabel, projectOption);
        System.out.println("project selected successfully");
        WebElement editarBtn = getEditarButton();
        try {
            Thread.sleep(2000l);
            safeClick(editarBtn);
            safeClick(fechVigenciaCalendar);
            //WebElement datepickerCtrols = navigateForWebElement(datepicker, "div:0");
            WebElement datepickerTable = navigateForWebElement(datepicker, "table:0");
            List<WebElement> calendarButtons = getDayButtonsList(datepickerTable);

            for (int i = 0; i < calendarButtons.size(); i++) {
                if (calendarButtons.get(i).findElement(By.tagName("a")).getAttribute("class").endsWith("ui-state-active")){
                    System.out.println("the day selected is " + calendarButtons.get(i).getText());
                    Thread.sleep(500l);
                    if (i > 5)
                        calendarButtons.get(i-5).click();
                    else if (i > 4)
                        calendarButtons.get(i-3).click();
                    else
                        calendarButtons.get(i-1).click();
                    Thread.sleep(500l);
                    break;
                }
            }
            System.out.println("one");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            System.out.println("two");
            jse.executeScript("scroll(0,-255)");
            System.out.println("three");
            Thread.sleep(1000l);
            safeClick(guardarBtn);
            Thread.sleep(3000l);
            System.out.println("four");
            msgLista = navigateForWebElements(successMsg, "div:0", "ul:0", "li");
            System.out.println("five");
            for (int i = 0; i < msgLista.size() ; i++) {
                System.out.println("list element: " +msgLista.get(i).getText());
            }
            System.out.println("  what da fuuuuuuuuuuuuuuuuuck!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msgLista;
    }

    public void selectMissingOptions(List<WebElement> msgLista) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            if (!msgLista.isEmpty()){
                for (WebElement msg: msgLista){
                    System.out.println("Sonic fast!");
                    waitForWebElementDisplayed(msg);
                    if (msg.getText().equals("El campo Gerente es requerido.")){
                        //if (isLabelWithTextPresent(msg, "El campo Gerente es requerido.")){
                        System.out.println("inside el campo gerente requerido");
                        WebElement gerenteOption = driver.findElement(By.xpath(gerenteOptionXpath));
                        safeSelectOptionOnPrimefacesList(gerenteLstLabel, gerenteOption);
                    }
                    if (msg.getText().equals("El campo Detalle del Tipo de Venta es requerido.")){
                        //if (isLabelWithTextPresent(msg, "El campo Detalle del Tipo de Venta es requerido.")){
                        System.out.println("inside el campo detalle del tipo de venta requerido validation");
                        safeSelectOptionOnPrimefacesList(detalleTipoVentaListlabel, detalleTipoVentaOption);
                    }

                    if (msg.getText().equals("El campo Catálogo de Actividades es requerido.")){
                        //if (isLabelWithTextPresent(msg, "El campo Catálogo de Actividades es requerido.")){
                        System.out.println("inside el campo catalogo actividades requerido validation");
                        safeSelectOptionOnPrimefacesList(actividadesLstLabel,actividadesOption);
                    }

                    if (msg.getText().equals("El campo Centro de Costo es requerido.")){
                        //if (isLabelWithTextPresent(msg, "El campo Centro de Costo es requerido.")){
                        System.out.println("inside el campo centro de costo requerido validation");
                        safeSelectOptionOnPrimefacesList(centroCostoLstLabel,centroCostoOption);
                    }
                    if (msg.getText().equals("El campo Tipo de Venta es requerido.")){
                        //if (isLabelWithTextPresent(msg, "El campo Tipo de Venta es requerido.")){
                        System.out.println("inside el campo tipo de venta requerido validation");
                        safeSelectOptionOnPrimefacesList(tipoVentaListlabel, tipoVentaOption);
                    }
                    if (msg.getText().equals("El campo Cuenta es requerido.")){
                        //if (isLabelWithTextPresent(msg, "El campo Cuenta es requerido.")){
                        System.out.println("inside el campo cuenta requerido validation");
                        safeSelectOptionOnPrimefacesList(cuentaLstLabel, cuentaOption);
                    }
                    if (msg.getText().equals("El campo Responsable es requerido.")){
                        //if (isLabelWithTextPresent(msg, "El campo Responsable es requerido.")){
                        System.out.println("inside el campo responsable requerido validation");
                        safeSelectOptionOnPrimefacesList(responsableLstLabel, responsableOption);
                    }
                    if (msg.getText().equals("El campo Tipo de Asignación es requerido.")){
                        //if (isLabelWithTextPresent(msg, "El campo Tipo de Asignación es requerido.")){
                        System.out.println("inside el campo de tipo de asignacion requerido validation");
                        safeSelectOptionOnPrimefacesList(asignacionLstLabel, asignacionOption);
                    }
                    if (msg.getText().equals("El campo Número de Recursos es requerido.")){
                        //if (isLabelWithTextPresent(msg, "El campo Número de Recursos es requerido.")){
                        System.out.println("inside el campo numero de recursos es requerido validation");
                        safeSendKeys(numeroRecursosTxt, "3");
                        jse.executeScript("scroll(0,-255)");
                    }

                    if (msg.getText().equals("Registro actualizado correctamente.")){
                        //if (isLabelWithTextPresent(msg, "Registro actualizado correctamente.")){
                        System.out.println("Success!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                }
                System.out.println("got here really fast");
                System.out.println("befoar da fuckin button has been pressed if you're seeing this while processing an action then it would be a fucking mistake");
                Thread.sleep(1000);
                System.out.println("passed");
                safeClick(guardarBtn);
                System.out.println("done!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! moda fuckin nigga");
                Thread.sleep(4000);
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

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

    private WebElement getEditarButton(){
        System.out.println("get editar button");
        //TODO: remove this piece of scheiße
        waitForWebElementNotDisplayed(driver.findElement(By.xpath("//*[@id=\"j_idt24\"]")));
        /*try {
            Thread.sleep(1l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return navigateForWebElement(tbody, "tr:0", "td:5", "button:0");
    }
}
