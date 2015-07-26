package com.praxis.siho.test.pages.main;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_MAIN;

import com.praxis.siho.test.pages.main.horarios.*;
import com.praxis.siho.test.pages.main.proyectos.CatalogoProyectosPage;
import com.praxis.siho.test.pages.main.rentabilidad.ControlCambiosPage;
import com.praxis.siho.test.pages.main.rentabilidad.RentabilidadCursoPage;
import com.praxis.siho.test.pages.main.rentabilidad.RentabilidadProyectoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.praxis.siho.test.pages.Page;
import com.praxis.siho.test.pages.main.actividades.CatalogoActividadesPage;
import com.praxis.siho.test.pages.main.asignacion.AsignacionLineaTecnologicaPage;
import com.praxis.siho.test.pages.main.asignacion.ConsultaAsignacionesPage;
import com.praxis.siho.test.pages.main.asignacion.EstatusAsignacionPage;
import com.praxis.siho.test.pages.main.asignacion.ProximoDesasignarsePage;
import com.praxis.siho.test.pages.main.asignacion.RegistroDesasignacion;
import com.praxis.siho.test.pages.main.asignacion.TipoAsignacionPage;

public class MainPage extends Page<MainPage>{

	//MODULO ASIGNACIONES
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[1]/a")
	private WebElement parentNodeAsignaciones;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[1]/ul/li[3]/a")
	private WebElement nodeCatAsignaciones;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[1]/ul/li[1]/a")
	private WebElement asgRegistroDesasignaciones;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[1]/ul/li[2]/a")
	private WebElement asgConsultaAsignaciones; // Anchor

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[1]/ul/li[3]/ul/li[1]/a")
	private WebElement asgStatusAsignacion;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[1]/ul/li[3]/ul/li[2]/a")
	private WebElement asgTipoAsignacion;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[1]/ul/li[3]/ul/li[3]/a")
	private WebElement asgLineaTecnologica;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[1]/ul/li[4]/a")
	private WebElement asgProxDesasignarse;

	//MODULO ACTIVIDADES
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[2]/a")
	private WebElement rootNodeActividades;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[2]/ul/li[2]/a")
	private WebElement parentNodeAdmActividades;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[2]/ul/li[2]/ul/li/a")
	private WebElement catalogoActividades;

	//MODULO PROYECTOS
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[5]/a")
	private WebElement parentNodeCatalogoProyectos;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[5]/ul/li[1]/a")
	private WebElement catalogoGerentes;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[5]/ul/li[2]/a")
	private WebElement catalogoProyectos;

	//MODULO HORARIOS
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[3]/a")
	private WebElement parentNodeHorarios;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[3]/ul/li[1]/a")
	private WebElement registroHorarios;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[3]/ul/li[2]/a")
	private WebElement administracionHorarios;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[3]/ul/li[3]/a")
	private WebElement consultaHorarios;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[3]/ul/li[4]/a")
	private WebElement controlHorarios;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[3]/ul/li[5]/a")
	private WebElement putualidadAsistencia;

	//RENTABILIDAD
	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[7]/a")
	private WebElement parentNodeRentabilidad;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[7]/ul/li[1]/a")
	private WebElement controlCambios;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt20:j_idt22\"]/ul/li[7]/ul/li[2]/a")
	private WebElement rentabilidadPorCurso;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[7]/ul/li[2]/a")
	private WebElement rentabilidadPorProyecto;

	public MainPage(WebDriver driver) {
		super(driver, PAGE_MAIN);
	}

	public RegistroDesasignacion linkToRegistroDesasignaciones(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeAsignaciones).perform();
		action.moveToElement(asgRegistroDesasignaciones).click().perform();
		return new RegistroDesasignacion(driver).loadPage();
	}

	public ConsultaAsignacionesPage linkToConsultaAsignaciones(){
		Actions action = new Actions(driver);
		System.out.println("verifying the simple thing");
		action.moveToElement(parentNodeAsignaciones).perform();
		action.moveToElement(asgConsultaAsignaciones).click().perform();
		System.out.println("verifying the simple thing about to load");
		return new ConsultaAsignacionesPage(driver).loadPage();
	}

	public EstatusAsignacionPage linkToEstatusAsignacion(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeAsignaciones).perform();
		action.moveToElement(nodeCatAsignaciones).perform();
		action.moveToElement(asgStatusAsignacion).click().perform();
		return new EstatusAsignacionPage(driver).loadPage();
	}

	public TipoAsignacionPage linkToTipoAsignacion(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeAsignaciones).perform();
		action.moveToElement(nodeCatAsignaciones).perform();
		action.moveToElement(asgTipoAsignacion).click().perform();

		return new TipoAsignacionPage(driver).loadPage();
	}

	public AsignacionLineaTecnologicaPage linkToAsignacionLineaTecnologica(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeAsignaciones).perform();
		action.moveToElement(nodeCatAsignaciones).perform();
		action.moveToElement(asgLineaTecnologica).click().perform();
		return new AsignacionLineaTecnologicaPage(driver).loadPage();
	}

	public ProximoDesasignarsePage linkToProximoDesasignarse(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeAsignaciones).perform();
		action.moveToElement(asgProxDesasignarse).click().perform();
		return new ProximoDesasignarsePage(driver).loadPage();
	}

	public CatalogoActividadesPage linkToCatalogoActividades(){
		Actions action = new Actions(driver);
		action.moveToElement(rootNodeActividades).perform();
		action.moveToElement(parentNodeAdmActividades).perform();
		action.moveToElement(catalogoActividades).click().perform();
		return new CatalogoActividadesPage(driver).loadPage();
	}

	public CatalogoProyectosPage linkToCatalogoProyectos(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeCatalogoProyectos).perform();
		action.moveToElement(catalogoProyectos).click().perform();
		return new CatalogoProyectosPage(driver).loadPage();
	}
	public CatalogoProyectosPage linkToCatalogoGerentes(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeCatalogoProyectos).perform();
		action.moveToElement(catalogoGerentes).click().perform();
		return new CatalogoProyectosPage(driver).loadPage();
	}

	public RegistroHorariosPage linkToRegistroHorariosPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeHorarios).perform();
		action.moveToElement(registroHorarios).click().perform();
		return new RegistroHorariosPage(driver).loadPage();
	}

	public ControlHorariosPage linkToControlHorariosPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeHorarios).perform();
		action.moveToElement(controlHorarios).click().perform();
		return new ControlHorariosPage(driver).loadPage();
	}

	public AdministracionHorariosPage linkToAdministracionHorariosPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeHorarios).perform();
		action.moveToElement(administracionHorarios).click().perform();
		return new AdministracionHorariosPage(driver).loadPage();
	}

	public ConsultaHorariosPage linkToConsultaHorariosPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeHorarios).perform();
		action.moveToElement(consultaHorarios).click().perform();
		return new ConsultaHorariosPage(driver).loadPage();
	}

	public PuntualidadAsistenciaPage linkToPuntualidadAsistenciaPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeHorarios).perform();
		action.moveToElement(putualidadAsistencia).click().perform();
		return new PuntualidadAsistenciaPage(driver).loadPage();
	}

	public ControlCambiosPage linkToControlCambiosPage(){
		System.out.println("elink cmapios ");
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeRentabilidad).perform();
		System.out.println("passwed_=?");
		action.moveToElement(controlCambios).click().perform();
		System.out.println("yas it dad!");
		return new ControlCambiosPage(driver).loadPage();
	}

	public RentabilidadCursoPage linkToRentabilidadCursoPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeRentabilidad).perform();
		action.moveToElement(rentabilidadPorCurso).click().perform();
		return new RentabilidadCursoPage(driver).loadPage();
	}

	public RentabilidadProyectoPage linkToRentabilidadProyectoPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeRentabilidad).perform();
		action.moveToElement(rentabilidadPorProyecto).click().perform();
		return new RentabilidadProyectoPage(driver).loadPage();
	}
}