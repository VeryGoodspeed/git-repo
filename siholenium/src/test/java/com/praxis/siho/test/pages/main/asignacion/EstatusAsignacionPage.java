package com.praxis.siho.test.pages.main.asignacion;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_STATUS_ASIGNACION;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.praxis.siho.test.pages.Page;
import com.praxis.siho.test.pages.cruds.CommonCRUDS;
public class EstatusAsignacionPage extends Page<EstatusAsignacionPage> {
	
	CommonCRUDS cruds = new CommonCRUDS();
	
	@FindBy(how = How.ID, using = "formTabla:j_idt51")
	private WebElement nuevoBtn;
	
	@FindBy(how = How.ID, using = "formTabla:j_idt52")
	private WebElement eliminarBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formDatos\"]/h1")
	private WebElement estatusAsignacionLabel;
	
	@FindBy(how = How.ID, using = "formDatos:claveTipoAsig")
	private WebElement cveTxt;

	@FindBy(how = How.ID, using = "formDatos:descripcionTipoAsig")
	private WebElement descTxt;
	
	@FindBy(how = How.ID, using = "formDatos:j_idt31")
	private WebElement guardarBtn;

	@FindBy(how = How.ID, using = "formDatos:j_idt33")
	private WebElement atrasBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"messages\"]/div/ul/li/span")
	private WebElement successMsg;
	
	@FindBy(how = How.ID, using = "formDatos:j_idt32")
	private WebElement guardarEdicionBtn;

	@FindBy(how = How.ID, using = "formDatos:j_idt33")
	private WebElement cancelarEdicionBtn;

	@FindBy(how = How.ID, using = "formTabla:tableData_data")
	private WebElement tbody;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formTabla:tableData_paginator_top\"]/span[4]/span")
	private WebElement nextPage;
	
	public EstatusAsignacionPage(WebDriver driver) {
		super(driver, PAGE_STATUS_ASIGNACION);
	}

	public String getResponseMsgFromAgregarEstatusAsignacion(String clave, String descripcion){
		String msg = null;
		safeClick(nuevoBtn);
		waitForWebElementDisplayed(estatusAsignacionLabel);
		if (isLabelWithTextPresent(estatusAsignacionLabel, "Datos del Estatus de la Asignación")) {
			try {
				msg = cruds.getMessageFromAgregarRegistro(cveTxt, descTxt, guardarBtn, successMsg, clave, descripcion);
			} catch (Exception e) {
				System.out.println("Error al agregar Estatus asignacion");
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String getResponseMsgFromEditarEstatusAsignacion(String clave, String descripcion){
		String msg = null;
		try {
			msg = cruds.getMessageFromEditarRegistro(estatusAsignacionLabel, cveTxt, descTxt, guardarEdicionBtn, successMsg, tbody, nextPage, clave, descripcion);
		} catch (Exception e) {
			System.out.println("error al editar estatus asignación");
			e.printStackTrace();
		}
		return msg;
	}

	public boolean borrarEstatusAsignacion(String clave){
		boolean success = cruds.borrarRegistro(cveTxt, descTxt, eliminarBtn, successMsg, tbody, nextPage, clave);
		return success;
	}

	@Deprecated
	public boolean agregarEstatusAsignacion(String clave, String descripcion){
		System.out.println("____________________________________");
		System.out.println("agregarEstatusAsignacion method");
		boolean success = false;
		safeClick(nuevoBtn);
		waitForWebElementDisplayed(estatusAsignacionLabel);
		if (isLabelWithTextPresent(estatusAsignacionLabel, "Datos del Estatus de la Asignación")) {
			try {
				success = cruds.agregarRegistro(cveTxt, descTxt, guardarBtn, successMsg, clave, descripcion);
			} catch (Exception e) {
				System.out.println("Error al agregar Estatus asignacion");
				e.printStackTrace();
			}
		}
		System.out.println("Estatus asignacion success: " + success);
		System.out.println("____________________________________**************");
		return success;		
	}

	@Deprecated
	public boolean editarEstatusAsignacion(String clave, String descripcion){
		boolean success = false;
		try {
			success = cruds.editarRegistro(estatusAsignacionLabel, cveTxt, descTxt, guardarEdicionBtn, successMsg, tbody, nextPage, clave, descripcion);
		} catch (Exception e) {
			System.out.println("error al editar estatus asignación");
			e.printStackTrace();
		}
		return success;
	}
}
