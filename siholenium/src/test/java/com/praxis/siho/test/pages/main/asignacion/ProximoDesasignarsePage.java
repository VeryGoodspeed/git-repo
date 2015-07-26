package com.praxis.siho.test.pages.main.asignacion;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.praxis.siho.test.pages.Page;

import static com.praxis.siho.test.common.util.RandomData.generateRandomNonZeroNumberUpTo;
import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_PROX_DESASIGNARSE;

public class ProximoDesasignarsePage extends Page<ProximoDesasignarsePage> {

	@FindBy(how = How.XPATH, using = "//*[@id=\"formProximosAdesasignarse:radioTipoConsulta\"]/tbody/tr/td[1]/div/div[2]/span")
	private WebElement tipoConsultaRecurso;	//radio button

	@FindBy(how = How.XPATH, using = "//*[@id=\"formProximosAdesasignarse:radioTipoConsulta\"]/tbody/tr/td[3]/div/div[2]/span")
	private WebElement tipoConsultaDias; //radio button
	
	@FindBy(how = How.ID, using = "formProximosAdesasignarse:j_idt38")
	private WebElement consultaRecursoLabel; //label for list

	@FindBy(how = How.ID, using = "formProximosAdesasignarse:lblInputDias")
	private WebElement diasProxDesasigLabel; //input text
	
	@FindBy(how = How.ID, using = "formProximosAdesasignarse:cboRecursos_label")
	private WebElement recursosList;

	// resource from list panel
	private String randomRecursoXpath = "//*[@id=\"formProximosAdesasignarse:cboRecursos_panel\"]/div/ul/li["
			+ generateRandomNonZeroNumberUpTo(798) + "]";
	
	@FindBy(how = How.ID, using = "formProximosAdesasignarse:inputDias")
	private WebElement diasInputTxt;
	
	@FindBy(how = How.ID, using = "formProximosAdesasignarse:j_idt46")
	private WebElement consultarBtn;
	
	public ProximoDesasignarsePage(WebDriver driver) {
		super(driver, PAGE_PROX_DESASIGNARSE);
	}

	public boolean seleccionarRecursoAleatoriamente(){
		boolean success = false;		
		try {
			safeClick(tipoConsultaRecurso);			
			if(isLabelWithTextPresent(consultaRecursoLabel, "Recurso:")){			
				safeSelectOptionOnPrimefacesList(recursosList, driver.findElement(By.xpath(randomRecursoXpath)));
				success = true;
			}
			return success;
		} catch (TimeoutException e) {
			System.out.println("seleccionarRecursoAleatoriamente " + e);
		}
		return success;
	}
	
	public boolean mostrarDesasignacionAcordeADias(){
		boolean success = false;
		try {
			safeClick(tipoConsultaDias);
			if(isLabelWithTextPresent(diasProxDesasigLabel, "Días próximos a desasignarse:*")){
				safeSendKeys(diasInputTxt, String.valueOf(generateRandomNonZeroNumberUpTo(10)));
				safeClick(consultarBtn);
				success = true;
			}
		} catch (TimeoutException e) {
			System.out.println("mostrarDesasignacionAcordeADias " + e);
		}
		return success;
	}
}
