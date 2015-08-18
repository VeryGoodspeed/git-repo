package com.praxis.siho.test.smoke;

import com.praxis.siho.test.pages.main.proyectos.CatalogoProyectosPage;
import org.openqa.selenium.WebElement;
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
import com.praxis.siho.test.pages.main.asignacion.TipoAsignacionPage;
import java.util.List;
import static com.praxis.siho.test.common.constants.GroupsConstants.ASIGNACIONES;
import static com.praxis.siho.test.common.constants.GroupsConstants.SIGNON;
import static com.praxis.siho.test.common.constants.GroupsConstants.SMOKE;
import static com.praxis.siho.test.common.util.RandomData.generateRandomNonZeroNumberUpTo;

import static com.praxis.siho.test.common.util.RandomData.*;

public class ModuloAsignacionesSmokeTest extends WebDriverSetup {
	final String randomCve   = getRandomLetter(false) + getRandomLetter(true) + generateRandomNonZeroNumberUpTo(100);
	final String randomCve2  = getRandomLetter(false) + getRandomLetter(true) + generateRandomNonZeroNumberUpTo(100);
	final String descripcion = "A descripción";

	@Test(enabled = true, priority = 1, groups = {SMOKE, ASIGNACIONES}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
    public void signOn(String credential, String password) {
		testCase("signOn");
		LogInPage logInPage = new LogInPage(driver).refreshPage();
        Assert.assertNotNull(logInPage);
        MainPage mainPage = logInPage.signon(credential, password);
        Assert.assertNotNull(mainPage);       
    }
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, ASIGNACIONES})
	public void casoAgregarLineaTecnologica() {
		testCase("casoAgregarLineaTecnologica");
		MainPage mainPage = new MainPage(driver).refreshPage();
		AsignacionLineaTecnologicaPage  asigLineaTecnologicaPage = mainPage.linkToAsignacionLineaTecnologica();
        Assert.assertNotNull(asigLineaTecnologicaPage, "failed to load linea tecnologica asignacion");
        Assert.assertTrue(asigLineaTecnologicaPage.agregarLineaTecnologica(randomCve, descripcion), "error en el caso agregar linea tecnológica");
	}
	
	@Test(enabled = true, priority = 3, groups = {SMOKE, ASIGNACIONES})
	public void casoEditarLineaTecnologica() {
		testCase("casoEditarLineaTecnologica");
		MainPage mainPage = new MainPage(driver).refreshPage();
		AsignacionLineaTecnologicaPage  asigLineaTecnologicaPage = mainPage.linkToAsignacionLineaTecnologica();
		Assert.assertNotNull(asigLineaTecnologicaPage, "failed to load linea tecnologica asignacion");
       	asigLineaTecnologicaPage.editarLineaTecnologica(randomCve, descripcion + "A");                
	}
	
	@Test(enabled = true, priority = 4, groups = {SMOKE, ASIGNACIONES})
	public void casoBorrarLineaTecnologica() {
		testCase("casoBorrarLineaTecnologica");
		MainPage mainPage = new MainPage(driver).refreshPage();
		AsignacionLineaTecnologicaPage  asigLineaTecnologicaPage = mainPage.linkToAsignacionLineaTecnologica();
        Assert.assertNotNull(asigLineaTecnologicaPage, "failed to load linea tecnologica asignacion");        
       	System.out.println(" about to do logical deletion");
        asigLineaTecnologicaPage.agregarLineaTecnologica(randomCve2, descripcion);     
       	asigLineaTecnologicaPage.refreshPage();
       	asigLineaTecnologicaPage.borrarLineaTecnologica (randomCve2);
	}

	@Test(enabled = true, priority = 5, groups = {SMOKE, ASIGNACIONES})
	public void casoAgregarTipoAsignacion(){
		testCase("casoAgregarTipoAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		TipoAsignacionPage  asigTipoAsignacionPage = mainPage.linkToTipoAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load tipo asignacion");
        System.out.println("after tipo asignacion**************");                
        Assert.assertTrue(asigTipoAsignacionPage.agregarTipoAsignacion(randomCve, descripcion), "Error en el caso agregar tipo asignación");
	}
	
	@Test(enabled = true, priority = 6, groups = {SMOKE, ASIGNACIONES})
	public void casoEditarTipoAsignacion(){
		testCase("casoEditarTipoAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		TipoAsignacionPage  asigTipoAsignacionPage = mainPage.linkToTipoAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load tipo asignacion");
        System.out.println("after tipo asignacion**************");                
        asigTipoAsignacionPage.editarTipoAsignacion(randomCve, descripcion + " Mod");
	}

	@Test(enabled = true, priority = 4, groups = {SMOKE, ASIGNACIONES})
	public void casoBorrarTipoAsignacion() throws InterruptedException{
		testCase("casoBorrarTipoAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		TipoAsignacionPage  asigTipoAsignacionPage = mainPage.linkToTipoAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load tipo asignacion");
        System.out.println("after tipo asignacion**************");       
        asigTipoAsignacionPage.agregarTipoAsignacion(randomCve2, descripcion);
        asigTipoAsignacionPage.borrarTipoAsignacion(randomCve2);            
	}

	@Test(enabled = true, priority = 7, groups = {SMOKE, ASIGNACIONES})
	public void casoAgregarEstatusAsignacion(){
		testCase("casoAgregarEstatusAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		EstatusAsignacionPage  asigTipoAsignacionPage = mainPage.linkToEstatusAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load estatus asignacion");
        System.out.println("after estatus asignacion**************");                
        Assert.assertTrue(asigTipoAsignacionPage.agregarEstatusAsignacion(randomCve, "AAA"), "Error en el caso Agregar estatus Asignación");
	}
	
	@Test(enabled = true, priority = 8, groups = {SMOKE, ASIGNACIONES})
	public void casoEditarEstatusAsignacion(){
		testCase("casoEditarEstatusAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		EstatusAsignacionPage  asigTipoAsignacionPage = mainPage.linkToEstatusAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load estatus asignacion");
        System.out.println("after estatus asignacion**************");                
        asigTipoAsignacionPage.editarEstatusAsignacion(randomCve, descripcion + " Mod");
	}
	
	@Test(enabled = true, priority = 8, groups = {SMOKE, ASIGNACIONES})
	public void casoBorrarEstatusAsignacion(){
		testCase("casoBorrarEstatusAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		EstatusAsignacionPage  asigTipoAsignacionPage = mainPage.linkToEstatusAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load estatus asignacion");
        System.out.println("after estatus asignacion**************");
        asigTipoAsignacionPage.agregarEstatusAsignacion(randomCve2, "AAA");
        asigTipoAsignacionPage.borrarEstatusAsignacion(randomCve2);
	}
	
	@Test(enabled = true, priority = 9, groups = {SMOKE, ASIGNACIONES})
	public void casoConsultarProximosDesasignarse(){
		testCase("casoConsultarProximosDesasignarse");
		MainPage mainPage = new MainPage(driver).refreshPage();
		ProximoDesasignarsePage page = mainPage.linkToProximoDesasignarse();
		Assert.assertNotNull(page);
		System.out.println("about to run the heck");
		Assert.assertTrue(page.seleccionarRecursoAleatoriamente(), "Error para seleccionar recurso");
		Assert.assertTrue(page.mostrarDesasignacionAcordeADias(), "Error para mostrar dias de proxima desasignacion");
	}
	@Test(enabled = true, priority = 2, groups = {SMOKE, ASIGNACIONES})
	public void casoConsultasAsignacionesPorRecurso(){
		testCase("casoConsultasAsignacionesPorRecurso");
		MainPage mainPage = new MainPage(driver).loadPage();
		ConsultaAsignacionesPage  consultaAsignacionesPage = mainPage.linkToConsultaAsignaciones();
        Assert.assertNotNull(consultaAsignacionesPage, "failed to load consultaAsignaciones");
        System.out.println("after consulta asignaciones");
	}

	@Test(enabled = true, priority = 9, groups = {SMOKE, ASIGNACIONES})
	public void casoAsignarCveProyectoRecurso(){
		testCase("casoAsignarCveProyectoRecurso");
		MainPage mainPage = new MainPage(driver).refreshPage();
		ConsultaAsignacionesPage  consultaAsignacionesPage = mainPage.linkToConsultaAsignaciones();
		Assert.assertNotNull(consultaAsignacionesPage, "failed to load consultaAsignaciones");
		Assert.assertTrue(consultaAsignacionesPage.asignarCveProyectoARecurso(), "caso de prueba no exitoso");
	}

	@Test(enabled = true, priority = 9, groups = {SMOKE, ASIGNACIONES})
	public void casoModificarFechaProyecto(){
		testCase("casoModificarFechaProyecto");
		MainPage mainPage = new MainPage(driver).refreshPage();
		CatalogoProyectosPage catalogoProyectosPage = mainPage.linkToCatalogoProyectos();
		System.out.println("about to do modificar vigentcia");
		List<WebElement> msgList = catalogoProyectosPage.modificarFechaVigencia();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		catalogoProyectosPage.selectMissingOptions(msgList);
	}
	@Test(enabled = false, priority = 9, groups = {SMOKE, ASIGNACIONES})
	public void casoAsignarCveProyectoInactivoRecurso(){
		//TODO
		System.out.println("casosAsignarCveProyectoInactivoRecurso");
		MainPage mainPage = new MainPage(driver).loadPage();
		ConsultaAsignacionesPage  consultaAsignacionesPage = mainPage.linkToConsultaAsignaciones();
		Assert.assertNotNull(consultaAsignacionesPage, "failed to load consultaAsignaciones");
		consultaAsignacionesPage.asignarCveProyectoInactivoARecurso();
	}
}