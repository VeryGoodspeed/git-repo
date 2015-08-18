package com.praxis.siho.test.pages.main.asignacion;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.praxis.siho.test.pages.Page;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_CONSULTA_ASIGNACIONES;
import static com.praxis.siho.test.common.util.RandomData.generateRandomNumberFromAToZ;

public class ConsultaAsignacionesPage extends Page<ConsultaAsignacionesPage> {
	private final int randomNumber = generateRandomNumberFromAToZ(2, 900);
	private String randomXpath = "//*[@id=\"formConsultaHorarios:cboRecursos_panel\"]/div/ul/li[" + randomNumber + "]";

	@FindBy(how = How.XPATH, using = "//*[@id=\"formConsultaHorarios:j_idt47\"]/h3")
	private WebElement busquedaAccordion;

	@FindBy(how = How.ID, using = "formConsultaHorarios:j_idt47:cboRecursos_label")
	private WebElement recursoLstLabel;
	@FindBy(how = How.ID, using = "formConsultaHorarios:j_idt47:cboRecursos_panel")
	private WebElement recursoLstPanel;

	//*[@id="formConsultaHorarios:cboRecursos_panel"]/div/ul/li[795]
	//*[@id="formConsultaHorarios:cboRecursos_panel"]/div/ul/li[605]
	@FindBy(how = How.XPATH, using = "//*[@id=\"formConsultaHorarios:cboRecursos_panel\"]/div/ul/li[795]")
	private WebElement option;

	@FindBy(how = How.ID, using = "formConsultaHorarios:j_idt47:cboEstatusRec_label")
	private WebElement estatusRecLabel; //list label

	@FindBy(how = How.ID, using = "formConsultaHorarios:j_idt47:cboEstatusRec_panel")
	private WebElement estatusRecPanel; //list selection → inactivo

	@FindBy(how = How.ID, using = "formConsultaHorarios:btonNuevo")
	private WebElement nuevoBtn;

	@FindBy(how = How.ID, using = "formConsultaHorarios:datos_data")
	private WebElement tbody;

	@FindBy(how = How.ID, using = "formConsultaHorarios:j_idt30")
	private WebElement img;

	@FindBy(how = How.ID, using = "formConsultaHorarios:j_idt37")
	private WebElement divMod;

	@FindBy(how = How.ID, using = "formContent:btnGuardar")
	private WebElement guardarBtn;

	@FindBy(how = How.ID, using = "formContent:j_idt29")
	private WebElement asignacionesBtn;

	@FindBy(how = How.ID, using = "formContent:btnAtras")
	private WebElement atrasBtn;

	@FindBy(how = How.ID, using = "formContent:cboProyecto_label")
	private WebElement proyectoLstLabel;

	@FindBy(how = How.ID, using = "formContent:proFechaInicio")
	private WebElement fechaIniProTxt;

	@FindBy(how = How.ID, using = "formContent:proFechaFin")
	private WebElement fechaFinProTxt;

	@FindBy(how = How.ID, using = "formContent:cboEstatusAsi_label")
	private WebElement estatusAsigLstLabel;
	@FindBy(how = How.XPATH, using = "//*[@id=\"formContent:cboEstatusAsi_panel\"]/div/ul/li[5]")
	private WebElement estatusAsigLstOption;

	@FindBy(how = How.ID, using = "formContent:cbotipPago_label")
	private WebElement tipoPagoLstLabel;
	@FindBy(how = How.XPATH, using = "//*[@id=\"formContent:cbotipPago_panel\"]/div/ul/li[2]")
	private WebElement tipoPagoLstOption;

	@FindBy(how = How.ID, using = "formContent:fechaInicio_input")
	private WebElement inicioAsignacionTxt;

	@FindBy(how = How.ID, using = "formContent:fechaFin_input")
	private WebElement finAsignacionTxt;

	@FindBy(how = How.ID, using = "formContent:j_idt32")
	private WebElement confirmacionBtn;

	@FindBy(how = How.ID, using = "formContent:j_idt32")
	private WebElement confirmacionPromptBtn;

	@FindBy(how = How.ID, using = "formContent:j_idt25")
	private WebElement cancelarBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formContent:messages\"]/div/ul/li/span")
	private WebElement successMsg;

	public ConsultaAsignacionesPage(WebDriver driver) {
		super(driver, PAGE_CONSULTA_ASIGNACIONES);		
	}

	public Map seleccionarRecursoUtil(){
		Map<String, String> datosRecurso = new HashMap<String, String>();
		try {
			Thread.sleep(5000l);
			//randomRecursoOptionXpath = "//*[@id=\"formConsultaHorarios:cboRecursos_panel\"]/div/ul/li[8]";
			String randomRecursoOptionXpath = "//*[@id=\"formConsultaHorarios:cboRecursos_panel\"]/div/ul/li[" + generateRandomNumberFromAToZ(2, 222) + "]";
			//option = driver.findElement(By.xpath(randomRecursoOptionXpath));
			System.out.println("it is working so far");
			//safeSelectOptionOnPrimefacesList(recursoLstLabel, option);

			selectValueOnPrimefacesListInLoop(recursoLstLabel, recursoLstPanel, generateRandomNumberFromAToZ(2, 111));
			//get dates from relational table at the bottom of the page
			waitForWebElementNotDisplayed(divMod);
			Thread.sleep(1500l);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> trs = getChildElements(tbody, "tr");
		int count = 0;
		System.out.println(trs.size());
		String fechaIngresoRec = null;
		String fechaFinRec = null;
		for (WebElement tr : trs) {
			System.out.println("go elements " + count++);
			System.out.println("trs " + tr.getText());
			List<WebElement> tds = getChildElements(tr, "td");
			if (tds.size() == 1) {
				System.out.println("recurso has no registries");
				return seleccionarRecursoUtil();
			} else {
				System.out.println("tds: " + tds.size());// not good case when it is tds 1
				fechaIngresoRec = safeGetLabel(tds.get(12));
				fechaFinRec = safeGetLabel(tds.get(13));
				if (fechaIngresoRec.equals("") || fechaFinRec.equals("")) {
					return seleccionarRecursoUtil();
				} else {
					datosRecurso.put("fechaIngresoRec", fechaIngresoRec);
					datosRecurso.put("fechaFinRec",     fechaFinRec);
					System.out.println("about to return datos recurso: " + datosRecurso);
					return datosRecurso;
				}
			}
		}
		return datosRecurso;
	}
	public boolean seleccionarProyectoUtil(String fechaIngresoRec, String fechaFinRec){
		boolean success = false;
		//select project from list 'proyecto'
		String proyectoOptionRandomXpath = "//*[@id=\"formContent:cboProyecto_panel\"]/div/ul/li["+ generateRandomNumberFromAToZ(2, 222)+"]";
		option = driver.findElement(By.xpath(proyectoOptionRandomXpath));
		safeSelectOptionOnPrimefacesList(proyectoLstLabel, option);
		//check dates and compare them to resource dates
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date ingresoDate     = sdf.parse(fechaIngresoRec);
			Date finDate 		 = sdf.parse(fechaFinRec);
			String tempFechaIni = safeGetInputText(fechaIniProTxt);
			String tempFechaFin = safeGetInputText(fechaFinProTxt);
			/*System.out.println("temp fecha ini: " + tempFechaIni);
			System.out.println("temp fecha fin: " + tempFechaFin);*/
			if (!tempFechaIni.equals("") && !tempFechaFin.equals("")){
				System.out.println("not the first");
				//waitForWebElementTextChangedDisplayed(fechaIniProTxt, tempFechaIni);
				//waitForWebElementTextChangedDisplayed(fechaFinProTxt, tempFechaFin);
				try {
					Thread.sleep(4000l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(safeGetInputText(fechaIniProTxt));
			System.out.println(safeGetInputText(fechaFinProTxt));
			waitForWebElementTextDisplayed(fechaIniProTxt);
			waitForWebElementTextDisplayed(fechaFinProTxt);
			System.out.println(safeGetInputText(fechaIniProTxt));
			System.out.println(safeGetInputText(fechaFinProTxt));
			Date fechaIniProDate = sdf.parse(safeGetInputText(fechaIniProTxt));
			Date fechaFinProDate = sdf.parse(safeGetInputText(fechaFinProTxt));
			if (fechaIniProDate.before(finDate) || fechaIniProDate.equals(finDate)){
				String fechaAsignacion, fechaFinAsignacion;
				//→→→if dates are not within the range of the resource go bakc to select another project until it has been found
				//select 'estatus asig' as 'ASIGNADO COBRADO'
				safeSelectOptionOnPrimefacesList(estatusAsigLstLabel, estatusAsigLstOption);
				//select 'Tipo de pago' as 'COBRADO'
				safeSelectOptionOnPrimefacesList(tipoPagoLstLabel, tipoPagoLstOption);
				//enter dates for beginning and end
				if (fechaIniProDate.equals(finDate)){
					fechaAsignacion = fechaFinRec;
					fechaFinAsignacion = fechaFinRec;
				} else {
					if (finDate.before(fechaFinProDate) || finDate.equals(fechaFinProDate)) {
						System.out.println("finDate.before(fechaFinProDate) || finDate.equals(fechaFinProDate)");
						fechaFinAsignacion = fechaFinRec;
					} else {
						System.out.println("else of System.out.println(\"finDate.before(fechaFinProDate) || finDate.equals(fechaFinProDate)\");");
						fechaFinAsignacion = safeGetInputText(fechaFinProTxt);
					}
					if (ingresoDate.before(fechaIniProDate) || ingresoDate.equals(fechaIniProDate)){
						System.out.println("ingresoDate.before(fechaIniProDate) || ingresoDate.equals(fechaIniProDate)");
						fechaAsignacion = safeGetInputText(fechaIniProTxt);
					} else {
						System.out.println("else of ingresoDate.before(fechaIniProDate) || ingresoDate.equals(fechaIniProDate)");
						fechaAsignacion = fechaIngresoRec;
					}
				}
				safeSendKeys(inicioAsignacionTxt, fechaAsignacion);
				safeSendKeys(finAsignacionTxt, fechaFinAsignacion);

				//Click on 'guardar'
				safeClick(guardarBtn);
				//confirm transaction
				safeClick(confirmacionBtn);
				System.out.println("responseMessage: " + safeGetLabel(successMsg));
				if (isLabelWithTextPresent(successMsg, "La operación se efectuó con éxito.")){
					System.out.println("Successfully done");
					System.out.println("Great success ");
					success = true;
				} else {
					System.out.println("unattainable piece of code");
				}
				try {/// this can be deleted
					Thread.sleep(3000l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				// select another project
				System.out.printf("Not the good project!");
				success = seleccionarProyectoUtil(fechaIngresoRec, fechaFinRec);
			}
		}catch(ParseException parse){
			System.out.println("catch success : " + success);
			parse.printStackTrace();
		}
		System.out.println("Success : " + success);
		return success;
	}

	public boolean asignarCveProyectoARecurso() {
		boolean success = false;
		String fechaIngresoRec, fechaFinRec;
		//select 'inactivo' state from list 'estatus rec'
		waitForWebElementNotDisplayed(divMod);
		safeClick(busquedaAccordion);
		selectValueOnPrimefacesListInLoop(estatusRecLabel, estatusRecPanel, "Inactivo");
		//select resource from list 'recurso'
		waitForWebElementNotDisplayed(divMod);

		Map<String, String> recursoSeleccionado = seleccionarRecursoUtil();
		if (recursoSeleccionado.size() != 0){
			fechaIngresoRec = recursoSeleccionado.get("fechaIngresoRec");
			fechaFinRec = recursoSeleccionado.get("fechaFinRec");
			waitForWebElementNotDisplayed(divMod);
			//→→click on nuevo
			safeClick(nuevoBtn);
			success = seleccionarProyectoUtil(fechaIngresoRec, fechaFinRec);
			System.out.println(success);
		}
		return success;
	}

	public void asignarCveProyectoInactivoARecurso(){
		//know an inactive project and change its date of expiration
		//select inactivo state from list 'estatus rec'
		//select resource from list 'recurso'
		//get dates from relational table at the bottom
		//→→click on nuevo
		//select project from list 'proyecto'
		//check dates and compare them to resource dates
		//→→→if dates are not within the range of the resource go bakc to select another project until it has been found
		//select 'estatus asig' as 'ASIGNADO COBRADO'
		//select 'Tipo de pago' as 'COBRADO'
		//enter dates for beginning and end
		//Click on 'guardar'
		//confirm transaction
	}

	public static class Recurso{

	}
}
