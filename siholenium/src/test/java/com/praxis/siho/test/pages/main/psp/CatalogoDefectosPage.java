package com.praxis.siho.test.pages.main.psp;

import com.praxis.siho.test.pages.Page;
import com.praxis.siho.test.pages.main.proyectos.CatalogoProyectosPage;
import com.praxis.siho.test.pages.main.psp.common.usage.PSPCruds;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.praxis.siho.test.common.constants.PageURLsConstants.*;
/**
 * Created by administrativo on 30/07/15.
 */
public class CatalogoDefectosPage extends Page<CatalogoDefectosPage> {
    public String SUCCESS = "Registro almacenado correctamente.";
    PSPCruds cruds = new PSPCruds();

    @FindBy(how = How.ID, using = "formTablaCatDefectos:j_idt51")
    private WebElement nuevoBtn;
    @FindBy(how = How.ID, using = "formTablaCatDefectos:j_idt52")
    private WebElement eliminarBtn;

    @FindBy(how = How.ID, using = "formCatDefectos:clave")
    private WebElement claveTxt;

    @FindBy(how = How.ID, using = "formCatDefectos:nombre")
    private WebElement nombreTxt;

    @FindBy(how = How.ID, using = "formCatDefectos:desc")
    private WebElement descripcionTxt;

    @FindBy(how = How.ID, using = "formCatDefectos:j_idt31")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formCatDefectos:j_idt33")
    private WebElement atrasBtn;

    @FindBy(how = How.ID, using = "messages")
    private WebElement responseMessageDiv;

    public CatalogoDefectosPage(WebDriver driver) {
        super(driver, PAGE_CAT_DEFECTOS);
    }

    public List<String> agregarDefecto(String cveDefector, String nombreDefecto, String descDefecto){
        return cruds.agregarRegistro(nuevoBtn, claveTxt, nombreTxt, descripcionTxt, guardarBtn, responseMessageDiv, cveDefector, nombreDefecto, descDefecto);
    }
}
