package com.praxis.siho.test.pages.main.asignacion;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_TIPO_ASIGNACION;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.praxis.siho.test.pages.Page;
import com.praxis.siho.test.pages.cruds.CommonCRUDS;
public class TipoAsignacionPage extends Page<TipoAsignacionPage> {

	CommonCRUDS cruds = new CommonCRUDS();

	@FindBy(how = How.ID, using = "formTabla:j_idt55")
	private WebElement nuevoBtn;
	
	@FindBy(how = How.ID, using = "formTabla:j_idt56")
	private WebElement eliminarBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formDatos\"]/h1")
	private WebElement tipoAsignacionLabel;
	
	@FindBy(how = How.ID, using = "formDatos:claveTipoAsig")
	private WebElement cveTxt;

	@FindBy(how = How.ID, using = "formDatos:descripcionTipoAsig")
	private WebElement descTxt;
							
	@FindBy(how = How.ID, using = "formDatos:j_idt35")
	private WebElement guardarBtn;

	@FindBy(how = How.ID, using = "formDatos:j_idt37")
	private WebElement atrasBtn;
	
	@FindBy(how = How.ID, using = "formDatos:j_idt36")
	private WebElement guardarEdicionBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"messages\"]/div/ul/li/span")
	private WebElement successMsg;
	
	@FindBy(how = How.ID, using = "formTabla:tableData_data")
	private WebElement tbody;
	//*[@id="formTabla:tableData_paginator_top"]/span[4]
	@FindBy(how = How.XPATH, using = "//*[@id=\"formTabla:tableData_paginator_top\"]/span[4]")
	private WebElement nextPage;
	
	public TipoAsignacionPage(WebDriver driver) {
		super(driver, PAGE_TIPO_ASIGNACION);
	}

	public String getResponseMsgFromAgregarTipoAsignacion(String clave, String descripcion){
		String msg = null;
		safeClick(nuevoBtn);
		System.out.println("agregarTipo asignacion metodo");
		waitForWebElementDisplayed(tipoAsignacionLabel);
		if (isLabelWithTextPresent(tipoAsignacionLabel, "Datos del Tipo de Asignación")) {
			try {
				msg = cruds.getMessageFromAgregarRegistro(cveTxt, descTxt, guardarBtn, successMsg, clave, descripcion);
			} catch (Exception e) {
				System.out.println("error al agregar tipo asignación");
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String getResponseMsgFromEditarTipoAsignacion(String clave, String descripcion){
		String msg = null;
		try {
			msg = cruds.getMessageFromEditarRegistro(tipoAsignacionLabel, cveTxt, descTxt, guardarEdicionBtn, successMsg, tbody, nextPage, clave, descripcion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public boolean borrarTipoAsignacion(String clave){
		boolean success = cruds.borrarRegistro(cveTxt, descTxt, eliminarBtn, successMsg, tbody, nextPage, clave);
		return success;
	}

	@Deprecated
	public boolean agregarTipoAsignacion(String clave, String descripcion){
		boolean success = false;
		safeClick(nuevoBtn);
		waitForWebElementDisplayed(tipoAsignacionLabel);
		if (isLabelWithTextPresent(tipoAsignacionLabel, "Datos del Tipo de Asignación")) {
			try {
				success = cruds.agregarRegistro(cveTxt, descTxt, guardarBtn, successMsg, clave, descripcion);
			} catch (Exception e) {
				System.out.println("error al agregar tipo asignación");
				e.printStackTrace();
			}
		}
		return success;		
	}

	@Deprecated
	public boolean editarTipoAsignacion(String clave, String descripcion){
		boolean success = false;
		try {
			success = cruds.editarRegistro(tipoAsignacionLabel, cveTxt, descTxt, guardarEdicionBtn, successMsg, tbody, nextPage, clave, descripcion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
}
