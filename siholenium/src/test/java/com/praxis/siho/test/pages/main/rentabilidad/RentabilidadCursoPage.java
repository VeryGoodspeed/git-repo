package com.praxis.siho.test.pages.main.rentabilidad;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_RENTABILIDAD_CURSO;
/**
 * Created by administrativo on 07/07/15.
 */
public class RentabilidadCursoPage extends Page<RentabilidadCursoPage> {
    @FindBy(how = How.ID, using = "formConsultaRentabilidadCurso:autocompleteCurso_input")
    private WebElement cveCursoTxt;

    @FindBy(how = How.ID, using = "formConsultaRentabilidadCurso:txtTipoVenta")
    private WebElement tipoVentaTxt;

    @FindBy(how = How.ID, using = "formConsultaRentabilidadCurso:txtNombreCurso")
    private WebElement nombreCursoTxt;

    @FindBy(how = How.ID, using = "formConsultaRentabilidadCurso:estatusCurso_label")
    private WebElement estatusLstLabel;
    private String estatusSelectedXpath = "//*[@id=\"formConsultaRentabilidadCurso:estatusCurso_panel\"]/div/ul/li[3]";

    public RentabilidadCursoPage(WebDriver driver) {
        super(driver, PAGE_RENTABILIDAD_CURSO);
    }
}
