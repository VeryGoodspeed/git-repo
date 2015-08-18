package com.praxis.siho.test.pages.cruds;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.praxis.siho.test.pages.BrowserBehaviour;

import static com.praxis.siho.test.common.util.RandomData.generateRandomNonZeroNumberUpTo;

public class CommonCRUDS extends BrowserBehaviour {


	public CommonCRUDS(){}
	@Deprecated
	public boolean agregarRegistro(WebElement claveTxt, WebElement descTxt, WebElement guardarBtn, WebElement altaExitoMsg, String clave, String descripcion) throws Exception {
		boolean ifIdExists = true;
		boolean success = false;
		String responseMessage = null;
		while(ifIdExists){
			responseMessage = getMessageFromAgregarRegistro(claveTxt, descTxt, guardarBtn, altaExitoMsg, clave, descripcion);
			if (responseMessage.equals("Registro almacenado correctamente.")){
				ifIdExists = !(success = true);
				return success;
			} else if (responseMessage.equals("El Id. ya existe, favor de validar.")) {
				System.out.println("la clave ingresada ya existe");
			} else{
				System.out.println("Error diferente a lo esperado");
				ifIdExists = false;
			}
			if (ifIdExists){
				System.out.println("changing cve");
				clave   = "WW" + generateRandomNonZeroNumberUpTo(100);
			}
		}
		return success;
	}
	@Deprecated
	public boolean editarRegistro(WebElement formLabel, WebElement claveTxt, WebElement descTxt, WebElement guardarEdicionBtn, WebElement altaExitoMsg, WebElement tbody, WebElement nextPage, String clave, String descripcion) throws Exception {
		boolean success = false;
		boolean ifIdExists = true;
		String responseMessage = null;
		while (ifIdExists){
			responseMessage = getMessageFromEditarRegistro(formLabel, claveTxt, descTxt, guardarEdicionBtn, altaExitoMsg, tbody, nextPage, clave, descripcion);
			if (responseMessage.equals("Registro actualizado correctamente.")) {
				ifIdExists = !(success = true);
			} else {
				System.out.println("Respuesta no exitosa para editar linea tecnologica");
				ifIdExists = false;
			}
		}
		return success;
	}

	public boolean borrarRegistro(WebElement claveTxt, WebElement descTxt, WebElement eliminarBtn,
								  WebElement successMsg, WebElement tbody, WebElement nextPage, String clave){
		String resultMessage = null;
		boolean success = false;
		WebElement check = getCheckBox(tbody, nextPage, clave);
		if (check != null) {
			waitForWebElementDisplayed(check);
			safeClick(check);
			safeClick(eliminarBtn);
			try {
				System.out.println("before waiting for web element in common cruds");
				waitForWebElementDisplayed(successMsg);
				System.out.println("before the apocalypse");
				successMsg.isDisplayed();
				System.out.println("after waiting and after success is displayed has been invoked");
				System.out.println("success message: " + successMsg);
				if(successMsg.getText().equals("Se ha eliminado correctamente.")){
					resultMessage = "";
					System.out.println("registro eliminado exitosamente");
					success = true;
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		return success;
	}

	public String getMessageFromAgregarRegistro(WebElement claveTxt, WebElement descTxt, WebElement guardarBtn, WebElement altaExitoMsg, String clave, String descripcion) throws Exception {
		String resultMessage = null;
		if (clave != null) {
			Thread.sleep(1000);
			safeSendKeys(claveTxt, clave);
		}
		if (descripcion != null) {
			safeSendKeys(descTxt, descripcion);
		}
		safeClick(guardarBtn);
		waitForWebElementDisplayed(altaExitoMsg);
		System.out.println("after waiting for success message");
		Thread.sleep(1000);
		resultMessage = safeGetLabel(altaExitoMsg);
		if (resultMessage == null || resultMessage.matches("([^\\w]|$)")){
			throw new Exception("error al recuperar respuesta del proceso de agregar Registro");
		}
		System.out.println("result message is this: " + resultMessage);
		return resultMessage;
	}

	public String getMessageFromEditarRegistro(WebElement formLabel, WebElement claveTxt, WebElement descTxt, WebElement guardarEdicionBtn, WebElement altaExitoMsg, WebElement tbody, WebElement nextPage, String clave, String descripcion) throws Exception {
		String resultMessage = null;
		WebElement openEditarButton = getButtonEditar(tbody, nextPage, clave);
		waitForWebElementClickable(openEditarButton);
		if (openEditarButton != null) {
			safeClick(openEditarButton);
			waitForWebElementDisplayed(formLabel);
			try {
				formLabel.isEnabled();
				safeSendKeys(descTxt, descripcion);
				safeClick(guardarEdicionBtn);
				waitForWebElementDisplayed(altaExitoMsg);
				resultMessage = safeGetLabel(altaExitoMsg);
				if (resultMessage == null || resultMessage.matches("([^\\w]|$)")){
					throw new Exception("error al recuperar respuesta del proceso de editar Registro");
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		return resultMessage;
	}

	private WebElement getButtonEditar(WebElement tbody, WebElement nextPage, String clave) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (WebElement tr : tbody.findElements(By.tagName("tr"))) {
			waitForWebElementDisplayed(tr);
			List<WebElement> tds = tr.findElements(By.tagName("td"));
			if (tds.get(1).getText().trim().equals(clave.trim())) {
				System.out.println("__________found!__________");
				return tds.get(3).findElement(By.tagName("button"));
			} else {
				System.out.println("not found yet");
			}
		}
		if (nextPage.isEnabled()) {
			safeClick(nextPage);
			return getButtonEditar(tbody, nextPage, clave);
		} else {
			return null;
		}
	}
	int count = 0;
	private WebElement getCheckBox(WebElement tbody, WebElement nextPage, String clave) {
		System.out.println("this is the occurrence: " + count++);
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (WebElement tr : tbody.findElements(By.tagName("tr"))) {
			waitForWebElementDisplayed(tbody);
			System.out.println("pbody side: "+tbody.findElements(By.tagName("tr")).size());
			System.out.println("tr contents " + tr.getText());
			List<WebElement> tds = tr.findElements(By.tagName("td"));
			System.out.println("tds : " + tds.size());
			System.out.println(tds.get(1).getText().trim() + " is it equals to: " + clave.trim());
			if (tds.get(1).getText().trim().equals(clave.trim())) {
				System.out.println("__________found!__________");
				return tds.get(0).findElement(By.tagName("span"));
			} else {
				System.out.println("chckbx not found yet");
			}
		}
		if (nextPage.isEnabled()) {
			System.out.println("another cycle");
			safeClick(nextPage);
			System.out.println("after clicking netxpage");
			return getCheckBox(tbody, nextPage, clave);
		} else {
			return null;
		}
	}
}
