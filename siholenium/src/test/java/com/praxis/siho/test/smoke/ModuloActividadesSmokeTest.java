package com.praxis.siho.test.smoke;
import static com.praxis.siho.test.common.constants.GroupsConstants.ACTIVIDADES;
import static com.praxis.siho.test.common.constants.GroupsConstants.SIGNON;
import static com.praxis.siho.test.common.constants.GroupsConstants.SMOKE;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.praxis.siho.test.WebDriverSetup;
import com.praxis.siho.test.dataprovider.SmokeTestDP;
import com.praxis.siho.test.pages.main.LogInPage;
import com.praxis.siho.test.pages.main.MainPage;
import com.praxis.siho.test.pages.main.actividades.CatalogoActividadesPage;

import javax.xml.bind.SchemaOutputResolver;

public class ModuloActividadesSmokeTest extends WebDriverSetup {

	final String randomCve   = "AE" + (int)(Math.random() * 100);
	final String randomCve2  = "EA" + (int)(Math.random() * 100);
	final String descripcion = "AAA"+randomCve;
	
	@Test(enabled = true, priority = 1, groups = {SMOKE, ACTIVIDADES}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
    public void signOn(String credential, String password) {
        LogInPage logInPage = new LogInPage(driver).refreshPage();
        System.out.println("after instanciating login page: " + logInPage);
        Assert.assertNotNull(logInPage);
        System.out.println("before method signon");
        MainPage mainPage = logInPage.signon(credential, password);
        Assert.assertNotNull(mainPage);       
    }
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, ACTIVIDADES})
	public void casoAgregarActividad() throws InterruptedException{
		MainPage mainPage = new MainPage(driver).refreshPage();
        System.out.println("casoAgregaractividad");
        CatalogoActividadesPage  catalogoActividadesPage = mainPage.linkToCatalogoActividades();
        Assert.assertNotNull(catalogoActividadesPage, "failed to load Catálogo de actividades");
        System.out.println("after catalogoActividadesPage**************");
        System.out.println("this will be the code: "+randomCve);
        catalogoActividadesPage.agregarActividad(randomCve, descripcion);
	}	
}
