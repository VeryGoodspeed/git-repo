package com.praxis.siho.test.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.praxis.siho.test.WebDriverSetup;
import com.praxis.siho.test.dataprovider.SmokeTestDP;
import com.praxis.siho.test.pages.main.LogInPage;
import com.praxis.siho.test.pages.main.MainPage;
import com.praxis.siho.test.pages.main.asignacion.AsignacionLineaTecnologicaPage;
import com.praxis.siho.test.pages.main.asignacion.ConsultaAsignacionesPage;
import com.praxis.siho.test.pages.main.asignacion.EstatusAsignacionPage;
import com.praxis.siho.test.pages.main.asignacion.ProximoDesasignarsePage;
import com.praxis.siho.test.pages.main.asignacion.RegistroDesasignacion;
import com.praxis.siho.test.pages.main.asignacion.TipoAsignacionPage;
import static com.praxis.siho.test.common.constants.GroupsConstants.LINKS;
import static com.praxis.siho.test.common.constants.GroupsConstants.SIGNON;
import static com.praxis.siho.test.common.constants.GroupsConstants.SMOKE;
public class SimpleSmokeTest extends WebDriverSetup{
	@Test(enabled = true, priority = 1, groups = {SMOKE, SIGNON}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
	public void signOn(String credential, String password) {
		LogInPage logInPage = new LogInPage(driver).refreshPage();
		System.out.println("after instanciating login page: " + logInPage);
		Assert.assertNotNull(logInPage);
		System.out.println("before method signon");
		MainPage mainPage = logInPage.signon(credential, password);
		Assert.assertNotNull(mainPage);
	}

	@Test(enabled = false, priority = 2, groups = {SMOKE, LINKS})
	public void openRegistroDesasignaciones(){
		MainPage mainPage = new MainPage(driver).loadPage();
		RegistroDesasignacion  registroDesasigPage = mainPage.linkToRegistroDesasignaciones();
		Assert.assertNotNull(registroDesasigPage, "failed to load registro desasignacion");
		System.out.println("after registro desasignacion");
	}

	@Test(enabled = true, priority = 2, groups = {SMOKE, LINKS})
	public void openConsultasAsignaciones(){
		MainPage mainPage = new MainPage(driver).loadPage();
		ConsultaAsignacionesPage  consultaAsignacionesPage = mainPage.linkToConsultaAsignaciones();
		Assert.assertNotNull(consultaAsignacionesPage, "failed to load consultaAsignaciones");
		System.out.println("after consulta asignaciones");
	}

	@Test(enabled = true, priority = 2, groups = {SMOKE, LINKS})
	public void openStatusAsignacion(){
		MainPage mainPage = new MainPage(driver).refreshPage();
		EstatusAsignacionPage  statusAsignacionPage = mainPage.linkToEstatusAsignacion();
		Assert.assertNotNull(statusAsignacionPage, "failed to load status asignacion");
		System.out.println("after status asignacion");
	}

	@Test(enabled = true, priority = 2, groups = {SMOKE, LINKS})
	public void openTipoAsignacion(){
		MainPage mainPage = new MainPage(driver).refreshPage();
		TipoAsignacionPage  tipoAsignacionPage = mainPage.linkToTipoAsignacion();
		Assert.assertNotNull(tipoAsignacionPage, "failed to load tipo asignacion");
		System.out.println("after tipo asignacion");
	}

	@Test(enabled = true, priority = 2, groups = {SMOKE, LINKS})
	public void openLineaTecnologica(){
		MainPage mainPage = new MainPage(driver).refreshPage();
		AsignacionLineaTecnologicaPage  asigLineaTecnologicaPage = mainPage.linkToAsignacionLineaTecnologica();
		Assert.assertNotNull(asigLineaTecnologicaPage, "failed to load linea tecnologica asignacion");
		System.out.println("after linea tecnologica asignacion");
	}

	@Test(enabled = true, priority = 2, groups = {SMOKE, LINKS})
	public void openProxDesasignarse(){
		MainPage mainPage = new MainPage(driver).refreshPage();
		ProximoDesasignarsePage  proxDesasignarsePage = mainPage.linkToProximoDesasignarse();
		Assert.assertNotNull(proxDesasignarsePage, "failed to load linea prox desasignacion");
		System.out.println("after linea prox desasignacion");
	}
}
 