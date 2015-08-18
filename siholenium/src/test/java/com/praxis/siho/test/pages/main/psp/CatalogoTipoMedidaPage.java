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
public class CatalogoTipoMedidaPage extends Page<CatalogoTipoMedidaPage> {
    PSPCruds cruds = new PSPCruds();
    @FindBy(how = How.ID, using = "formTabla:j_idt42")
    private WebElement nuevoBtn;

    @FindBy(how = How.ID, using = "formTabla:j_idt43")
    private WebElement eliminarBtn;

    @FindBy(how = How.ID, using = "formMedida:j_idt31")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formMedida:j_idt33")
    private WebElement atrasBtn;

    @FindBy(how = How.ID, using = "formMedida:medida")
    private WebElement tipoMedidaTxt;

    @FindBy(how = How.ID, using = "messages")
    private WebElement responseMessagesDiv;

    public CatalogoTipoMedidaPage(WebDriver driver) {
        super(driver, PAGE_CAT_TIPO_MEDIDA);
    }

    public List<String> agregarTipoMedida(){
        return new PSPCruds.CatalogosEstimacionTamanio().agregarRegistro(nuevoBtn, tipoMedidaTxt, guardarBtn, responseMessagesDiv, "tipo medida");
    }

}

