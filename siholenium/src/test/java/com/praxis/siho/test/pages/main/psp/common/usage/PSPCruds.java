package com.praxis.siho.test.pages.main.psp.common.usage;

import com.praxis.siho.test.pages.BrowserBehaviour;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by administrativo on 11/08/15.
 */
public class PSPCruds extends BrowserBehaviour{
    public List<String> agregarRegistro(WebElement nuevoBtn, WebElement claveTxt, WebElement nombreTxt, WebElement descripcionTxt, WebElement guardarBtn, WebElement responseMessageDiv,
                                       String clave, String nombre, String descripcion) {
        safeClick(nuevoBtn);
        safeSendKeys(claveTxt, clave);
        safeSendKeys(nombreTxt, nombre);
        safeSendKeys(descripcionTxt, descripcion);
        safeClick(guardarBtn);
        return getErrorMessagesFrom(responseMessageDiv);
    }
    public static class CatalogosEstimacionTamanio extends BrowserBehaviour {

        public List<String> agregarRegistro(WebElement nuevoBtn, WebElement tipoTxt, WebElement guardarBtn, WebElement responseMessageDiv, String nombre) {
            safeClick(nuevoBtn);
            safeSendKeys(tipoTxt, nombre);
            safeClick(guardarBtn);
            return getErrorMessagesFrom(responseMessageDiv);
        }
    }
}
