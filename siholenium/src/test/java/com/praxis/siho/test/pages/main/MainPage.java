package com.praxis.siho.test.pages.main;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_MAIN;

import com.praxis.siho.test.pages.main.horarios.*;
import com.praxis.siho.test.pages.main.proyectos.CatalogoProyectosPage;
import com.praxis.siho.test.pages.main.psp.*;
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
	@FindBy(how = How.LINK_TEXT, using = "ASIGNACIONES")
	private WebElement parentNodeAsignaciones;

	@FindBy(how = How.LINK_TEXT, using = "Catálogo de Asignaciones")
	private WebElement nodeCatAsignaciones;

	@FindBy(how = How.LINK_TEXT, using = "Registro de Desasignaciones")
	private WebElement asgRegistroDesasignaciones;

	@FindBy(how = How.LINK_TEXT, using = "Consulta de Asignaciones")
	private WebElement asgConsultaAsignaciones; // Anchor

	@FindBy(how = How.LINK_TEXT, using = "Status de la Asignación")
	private WebElement asgStatusAsignacion;

	@FindBy(how = How.LINK_TEXT, using = "Tipo de Asignación")
	private WebElement asgTipoAsignacion;

	@FindBy(how = How.LINK_TEXT, using = "Línea Tecnológica")
	private WebElement asgLineaTecnologica;

	@FindBy(how = How.LINK_TEXT, using = "Próximos a Desasignarse")
	private WebElement asgProxDesasignarse;

	//MODULO ACTIVIDADES
	@FindBy(how = How.LINK_TEXT, using = "ACTIVIDADES")
	private WebElement rootNodeActividades;

	@FindBy(how = How.LINK_TEXT, using = "Captura de Actividades")
	private WebElement capturaActividades;

	@FindBy(how = How.LINK_TEXT, using = "Administración de Actividades")
	private WebElement parentNodeAdmActividades;

	@FindBy(how = How.LINK_TEXT, using = "Cátalogo")
	private WebElement catalogoActividades;

	@FindBy(how = How.LINK_TEXT, using = "Asignar Catálogo a Proyecto")
	private WebElement asignarCatProyecto;

	@FindBy(how = How.LINK_TEXT, using = "Bloqueo Mensual de Actividades")
	private WebElement bloqueoMensualActividades;

	//MODULO PROYECTOS
	@FindBy(how = How.LINK_TEXT, using = "PROYECTOS")
	private WebElement parentNodeCatalogoProyectos;

	@FindBy(how = How.LINK_TEXT, using = "Catálogo de Gerentes")
	private WebElement catalogoGerentes;

	@FindBy(how = How.LINK_TEXT, using = "Catálogo de Proyectos")
	private WebElement catalogoProyectos;

	//MODULO HORARIOS
	@FindBy(how = How.LINK_TEXT, using = "HORARIOS")
	private WebElement parentNodeHorarios;

	@FindBy(how = How.LINK_TEXT, using = "Registro de Horarios")
	private WebElement registroHorarios;

	@FindBy(how = How.LINK_TEXT, using = "Administración de Horarios")
	private WebElement administracionHorarios;

	@FindBy(how = How.LINK_TEXT, using = "Consulta de Horarios")
	private WebElement consultaHorarios;

	@FindBy(how = How.LINK_TEXT, using = "Control de Horarios")
	private WebElement controlHorarios;

	@FindBy(how = How.LINK_TEXT, using = "Puntualidad y asistencia")
	private WebElement putualidadAsistencia;

	//RENTABILIDAD
	@FindBy(how = How.LINK_TEXT, using = "RENTABILIDAD")
	private WebElement parentNodeRentabilidad;

	@FindBy(how = How.LINK_TEXT, using = "Control de Cambios")
	private WebElement controlCambios;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt20:j_idt22\"]/ul/li[7]/ul/li[2]/a")
	private WebElement rentabilidadPorCurso;

	@FindBy(how = How.LINK_TEXT, using = "Rentabilidad por Proyecto")
	private WebElement rentabilidadPorProyecto;

	//PSP
	@FindBy(how = How.LINK_TEXT, using = "PSP")
	private WebElement parentNodePSP;

	@FindBy(how = How.LINK_TEXT, using = "Catalogos Estimacion tamaño")
	private WebElement nodeEstimacionTamanio;

	@FindBy(how = How.LINK_TEXT, using = "Configuracion de Proyectos")
	private WebElement configuracionProyectos;

	@FindBy(how = How.LINK_TEXT, using = "Estimación de Tamaño")
	private WebElement estimacionTamanio;

	@FindBy(how = How.LINK_TEXT, using = "Asistente PROBE")
	private WebElement asistenteProbe;

	@FindBy(how = How.LINK_TEXT, using = "Planeacion de Actividades")
	private WebElement planeacionActividades;

	@FindBy(how = How.LINK_TEXT, using = "Captura de Defectos")
	private WebElement capturaDefectos;

	@FindBy(how = How.LINK_TEXT, using = "Bitacora de Defectos")
	private WebElement bitacoraDefectos;

	@FindBy(how = How.LINK_TEXT, using = "Resumen PSP")
	private WebElement resumenPSP;

	@FindBy(how = How.LINK_TEXT, using = "Catálogo Nivel, Fase y Act")
	private WebElement catNivelFaseAct;

	@FindBy(how = How.LINK_TEXT, using = "Catálogo de Plantillas")
	private WebElement catPlantillas;

	@FindBy(how = How.LINK_TEXT, using = "Catalogo de Defectos")
	private WebElement catDefectos;

	@FindBy(how = How.LINK_TEXT, using = "Catalogos")
	private WebElement nodeCatPSP;

	@FindBy(how = How.LINK_TEXT, using = "Catálogo Tipo de medida")
	private WebElement catTipoMedida;

	@FindBy(how = How.ID, using = "Catálogo Tipo de Funcionalidad")
	private WebElement catTipoFunc;

	@FindBy(how = How.XPATH, using = "//*[@id=\"j_idt13:j_idt15\"]/ul/li[8]/ul/li[11]/ul/li[3]/a")
	private WebElement catTamanioRelativo;


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
		action.moveToElement(parentNodeAsignaciones).perform();
		action.moveToElement(asgConsultaAsignaciones).click().perform();
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
		Actions action = new Actions(driver);
		action.moveToElement(parentNodeRentabilidad).perform();
		action.moveToElement(controlCambios).click().perform();
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

	public ConfiguracionProyectosPage linkToConfiguracionProyectosPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(configuracionProyectos).click().perform();
		return new ConfiguracionProyectosPage(driver).loadPage();
	}

	public EstimacionTamanioPage linkToEstimacionTamanioPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(estimacionTamanio).click().perform();
		return new EstimacionTamanioPage(driver).loadPage();
	}

	public AsistentePROBEPage linkToAsistentePROBEPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(asistenteProbe).click().perform();
		return new AsistentePROBEPage(driver).loadPage();
	}

	public PlaneacionActividadesPage linkToPlaneacionActividadesPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(planeacionActividades).click().perform();
		return new PlaneacionActividadesPage(driver).loadPage();
	}

	public CapturaDefectosPage linkToCapturaDefectosPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(capturaDefectos).click().perform();
		return new CapturaDefectosPage(driver).loadPage();
	}

	public BitacoraDefectosPage linkToBitacoraDefectosPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(bitacoraDefectos).click().perform();
		return new BitacoraDefectosPage(driver).loadPage();
	}

	public ResumenPSPPage linkToResumenPSPPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(resumenPSP).click().perform();
		return new ResumenPSPPage(driver).loadPage();
	}
	public CatalogoNivelFaseActPage linkToCatalogoNivelFaseActPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(nodeCatPSP).perform();
		action.moveToElement(catNivelFaseAct).click().perform();
		return new CatalogoNivelFaseActPage(driver).loadPage();
	}

	public CatalogoPlantillasPage linkToCatalogoPlantillasPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(nodeCatPSP).perform();
		action.moveToElement(catPlantillas).click().perform();
		return new CatalogoPlantillasPage(driver).loadPage();
	}

	public CatalogoDefectosPage linkToCatalogoDefectosPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(nodeCatPSP).perform();
		action.moveToElement(catDefectos).click().perform();
		return new CatalogoDefectosPage(driver).loadPage();
	}

	public CatalogoTipoMedidaPage linkToCatalogoTipoMedidaPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(nodeCatPSP).perform();
		action.moveToElement(nodeEstimacionTamanio).perform();
		action.moveToElement(catTipoMedida).click().perform();
		return new CatalogoTipoMedidaPage(driver).loadPage();
	}

	public CatalogoTipoFuncionalidadPage linkToCatalogoTipoFuncionalidadPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(nodeCatPSP).perform();
		action.moveToElement(nodeEstimacionTamanio).perform();
		action.moveToElement(catTipoFunc).click().perform();
		return new CatalogoTipoFuncionalidadPage(driver).loadPage();
	}

	public CatalogoTamanioRelativoPage linkToCatalogoTamanioRelativoPage(){
		Actions action = new Actions(driver);
		action.moveToElement(parentNodePSP).perform();
		action.moveToElement(nodeCatPSP).perform();
		action.moveToElement(catTamanioRelativo).click().perform();
		return new CatalogoTamanioRelativoPage(driver).loadPage();
	}
}