package com.praxis.siho.test.pages.main.psp;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.WebDriver;
import static com.praxis.siho.test.common.constants.PageURLsConstants.*;
/**
 * Created by administrativo on 30/07/15.
 */
public class ResumenPSPPage extends Page<ResumenPSPPage> {
    public ResumenPSPPage(WebDriver driver) {
        super(driver, PAGE_RESUMEN_PSP);
    }
}
