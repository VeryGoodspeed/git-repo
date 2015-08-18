package com.praxis.siho.test.smoke;
import static com.praxis.siho.test.common.constants.GroupsConstants.ACTIVIDADES;
import static com.praxis.siho.test.common.constants.GroupsConstants.SIGNON;
import static com.praxis.siho.test.common.constants.GroupsConstants.SMOKE;

import com.praxis.siho.test.common.util.RandomData;
import org.eclipse.jetty.websocket.RandomMaskGen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.praxis.siho.test.WebDriverSetup;
import com.praxis.siho.test.dataprovider.SmokeTestDP;
import com.praxis.siho.test.pages.main.LogInPage;
import com.praxis.siho.test.pages.main.MainPage;
import com.praxis.siho.test.pages.main.actividades.CatalogoActividadesPage;

import static com.praxis.siho.test.common.util.RandomData.*;

public class ModuloActividadesSmokeTest extends WebDriverSetup {

	final String randomCve   = getRandomLetter(false) + getRandomLetter(true) + (int)(Math.random() * 100);
	final String descripcion = getRandomLetter(false) + getRandomLetter(true) + randomCve;
	
	@Test(enabled = true, priority = 1, groups = {SMOKE, ACTIVIDADES}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
    public void signOn(String credential, String password) {
        testCase("signOn");
        LogInPage logInPage = new LogInPage(driver).refreshPage();
        Assert.assertNotNull(logInPage);
        MainPage mainPage = logInPage.signon(credential, password);
        Assert.assertNotNull(mainPage);       
    }
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, ACTIVIDADES})
	public void casoAgregarActividad() throws InterruptedException{
        testCase("casoAgregarActividad");
		MainPage mainPage = new MainPage(driver).refreshPage();
        CatalogoActividadesPage  catalogoActividadesPage = mainPage.linkToCatalogoActividades();
        Assert.assertNotNull(catalogoActividadesPage, "failed to load Catálogo de actividades");
        catalogoActividadesPage.agregarActividad(randomCve, descripcion);
	}	
}
