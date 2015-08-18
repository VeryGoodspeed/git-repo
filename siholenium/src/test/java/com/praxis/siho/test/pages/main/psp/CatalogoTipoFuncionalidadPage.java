package com.praxis.siho.test.pages.main.psp;

import com.praxis.siho.test.pages.Page;
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
public class CatalogoTipoFuncionalidadPage extends Page<CatalogoTipoFuncionalidadPage> {

    @FindBy(how = How.ID, using = "formTabla:j_idt42")
    private WebElement nuevoBtn;

    @FindBy(how = How.ID, using = "formTabla:j_idt43")
    private WebElement eliminarBtn;

    @FindBy(how = How.ID, using = "formFuncionalidad:j_idt31")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formFuncionalidad:j_idt33")
    private WebElement atrasBtn;

    @FindBy(how = How.ID, using = "formFuncionalidad:funcionalidad")
    private WebElement tipoFuncionalidadTxt;

    @FindBy(how = How.ID, using = "messages")
    private WebElement responseMessagesDiv;

    public CatalogoTipoFuncionalidadPage(WebDriver driver) {
        super(driver, PAGE_CAT_TIPO_FUNC);
    }

    public List<String> agregarTipoFuncionalidad(){
        return new PSPCruds.CatalogosEstimacionTamanio().agregarRegistro(nuevoBtn, tipoFuncionalidadTxt, guardarBtn, responseMessagesDiv, "tipo funcionalidad");
    }
}
