package com.praxis.siho.test.pages.main.actividades;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_CAPTURA_ACTIVIDADES;

import org.openqa.selenium.WebDriver;

import com.praxis.siho.test.pages.Page;

public class CapturaActividadesPage extends Page<CapturaActividadesPage> {

	public CapturaActividadesPage(WebDriver driver) {
		super(driver, PAGE_CAPTURA_ACTIVIDADES);
	}
}
