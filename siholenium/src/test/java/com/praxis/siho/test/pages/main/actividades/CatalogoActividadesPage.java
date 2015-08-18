package com.praxis.siho.test.pages.main.actividades;
import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_CAT_ACTIVIDADES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.praxis.siho.test.pages.Page;
import com.praxis.siho.test.pages.cruds.CommonCRUDS;
public class CatalogoActividadesPage extends Page<CatalogoActividadesPage> {

	private CommonCRUDS cruds = new CommonCRUDS();
	@FindBy(how = How.ID, using = "formActividades:j_idt31")
	private WebElement nuevoBtn;
	                                    //*[@id="j_idt40"]/div[1]/h1
	//@FindBy(how = How.XPATH, using = "//*[@id=\" j_idt40\"]/div[1]/h1")
	@FindBy(how = How.ID, using = "j_idt40:j_idt49")
	private WebElement altaLabel;
	
	@FindBy(how = How.ID, using = "j_idt40:insddput_Miercodddlxesl")
	private WebElement claveTxt;
	
    @FindBy(how = How.ID, using = "j_idt47:catDescripcion")
	private WebElement descTxt;
    
    @FindBy(how = How.ID, using = "j_idt47:j_idt50")
	private WebElement guardarBtn;
    
    @FindBy(how = How.ID, using = "j_idt47:j_idt52")
    private WebElement atrasBtn;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formActividades:messages\"]/div/ul/li/span")
	private WebElement successMsg;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"j_idt40:j_idt58\"]/div[2]/span")
    private WebElement catBaseChckBx;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"j_idt40:j_idt62\"]/div[2]/span")
    private WebElement copActividadesChckBx;
    
    @FindBy(how = How.ID, using  ="j_idt40:selecCatalogo_label")
    private WebElement ComboBox; //label
    
    @FindBy(how = How.ID, using = "j_idt40:j_idt44")
	private WebElement guardarEdicionBtn;
    
	@FindBy(how = How.ID, using = "formActividades:tableData_data")
	private WebElement tbody;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formActividades:tableData_paginator_top\"]/span[5]/span")
	private WebElement nextPage;
	
	@FindBy(how = How.ID, using = "formActividades:j_idt78")
	private WebElement eliminarBtn;
	
	public CatalogoActividadesPage(WebDriver driver){
		super(driver, PAGE_CAT_ACTIVIDADES);
	}
	
	public boolean agregarActividad(String clave, String descripcion){
		boolean success = false;
		safeClick(nuevoBtn);
		if (isLabelWithTextPresent(nuevoBtn, "Nuevo")){
			try {
				success = cruds.agregarRegistro(claveTxt, descTxt, guardarBtn, successMsg, null, descripcion);
			} catch (Exception e) {
				System.out.println("error al agregar actividad");
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean editarActividad(String clave, String descripcion){
		boolean success = false;
		try {
			success = cruds.editarRegistro(altaLabel, claveTxt, descTxt, guardarEdicionBtn, successMsg, tbody, nextPage, clave, descripcion);
		} catch (Exception e) {
			System.out.println("error al editar actividad");
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean borrarActividad(String clave){
		boolean success = cruds.borrarRegistro(claveTxt, descTxt, eliminarBtn, successMsg, tbody, nextPage, clave);
		return success;
	}

}
