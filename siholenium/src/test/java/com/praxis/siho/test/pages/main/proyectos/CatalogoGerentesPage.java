package com.praxis.siho.test.pages.main.proyectos;

/**
 * Created by administrativo on 24/06/15.
 */


import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.WebDriver;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_CATALOGO_GERENTES;
public class CatalogoGerentesPage extends Page<CatalogoGerentesPage> {

    public CatalogoGerentesPage(WebDriver driver) {
        super(driver, PAGE_CATALOGO_GERENTES);
    }
}
