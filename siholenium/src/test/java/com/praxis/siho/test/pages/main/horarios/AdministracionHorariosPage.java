package com.praxis.siho.test.pages.main.horarios;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.WebDriver;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_ADM_HORARIOS;
/**
 * Created by administrativo on 03/07/15.
 */
public class AdministracionHorariosPage extends Page<AdministracionHorariosPage>{
    public AdministracionHorariosPage(WebDriver driver) {
        super(driver, PAGE_ADM_HORARIOS);
    }
}
