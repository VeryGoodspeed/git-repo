package com.praxis.siho.test.pages.main.asignacion;

import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_LINEA_TECNOLOGICA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.praxis.siho.test.pages.Page;
import com.praxis.siho.test.pages.cruds.CommonCRUDS;

public class AsignacionLineaTecnologicaPage extends Page<AsignacionLineaTecnologicaPage> {

	private CommonCRUDS cruds = new CommonCRUDS();
	@FindBy(how = How.ID, using = "formTabla:j_idt52")
	private WebElement nuevoBtn;
	
	@FindBy(how = How.ID, using = "formTabla:j_idt53")
	private WebElement eliminarBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formTabla:tableData:j_idt48\"]/div/div[2]/span")
	private WebElement selectAllCheckBox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"panelDatos_content\"]/h1")
	private WebElement labelLineaTecAlta;   //@Deprecated
								//*[@id="panelDatos_content"]/h1
	@FindBy(how = How.XPATH, using = "//*[@id=\"formDatos\"]/h2")
	private WebElement labelLineaTecAlta2;
	
	@FindBy(how = How.ID, using = "formDatos:claveLineaT")
	private WebElement claveTxt;

	@FindBy(how = How.ID, using = "formDatos:descripcionLineaT")
	private WebElement descTxt;
	
	@FindBy(how = How.ID, using = "formDatos:j_idt32")
	private WebElement guardarBtn;

	@FindBy(how = How.ID, using = "formDatos:j_idt34")
	private WebElement atrasBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"messages\"]/div/ul/li/span")
	private WebElement altaExitoMsg; //"Registro almacenado correctamente."
	
	@FindBy(how = How.ID, using = "formDatos:j_idt33")
	private WebElement guardarEdicionBtn;

	@FindBy(how = How.ID, using = "formTabla:tableData_data")
	private WebElement tbody;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formTabla:tableData_paginator_top\"]/span[4]/span")
	private WebElement nextPage;

	public AsignacionLineaTecnologicaPage(WebDriver driver) {
		super(driver, PAGE_LINEA_TECNOLOGICA);
	}

	public String getResponseMsgFromAgregarLineaTecnologica(String clave, String descripcion) {
		String msg = null;
		safeClick(nuevoBtn);
		waitForWebElementDisplayed(labelLineaTecAlta2);
		if (isLabelWithTextPresent(labelLineaTecAlta2, "Datos de la Línea Tecnológica")) {
			try {
				msg = cruds.getMessageFromAgregarRegistro(claveTxt, descTxt, guardarBtn, altaExitoMsg, clave, descripcion);
			} catch (Exception e) {
				System.out.println("error al intentar obtener mensaje al agregar Linea tecnologica");
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String getResponseMsgFromEditarLineaTecnologica(String clave, String descripcion){
		String msg = null;
		try {
			msg = cruds.getMessageFromEditarRegistro(labelLineaTecAlta2, claveTxt, descTxt, guardarEdicionBtn, altaExitoMsg, tbody, nextPage, clave, descripcion);
		} catch (Exception e) {
			System.out.println("error al editar linea tecnologica");
			e.printStackTrace();
		}
		return msg;
	}

	public boolean borrarLineaTecnologica(String clave){
		boolean success = cruds.borrarRegistro(claveTxt, descTxt, eliminarBtn, altaExitoMsg, tbody, nextPage, clave);
		return success;
	}

	@Deprecated
	public boolean agregarLineaTecnologica(String clave, String descripcion) {
		boolean success = false;
		safeClick(nuevoBtn);
		waitForWebElementDisplayed(labelLineaTecAlta2);
		if (isLabelWithTextPresent(labelLineaTecAlta2, "Datos de la Línea Tecnológica")) {
			try {
				success = cruds.agregarRegistro(claveTxt, descTxt, guardarBtn, altaExitoMsg, clave, descripcion);
			} catch (Exception e) {
				System.out.println("error al intentar agregar Linea tecnologica");
				e.printStackTrace();
			}
		}
		System.out.println("about to send: " + success);
		return success;
	}

	@Deprecated
	public boolean editarLineaTecnologica(String clave, String descripcion){
		boolean success = false;
		try {
			success = cruds.editarRegistro(labelLineaTecAlta2, claveTxt, descTxt, guardarEdicionBtn, altaExitoMsg, tbody, nextPage, clave, descripcion);
		} catch (Exception e) {
			System.out.println("error al editar linea tecnologica");
			e.printStackTrace();
		}
		return success;
	}
}
