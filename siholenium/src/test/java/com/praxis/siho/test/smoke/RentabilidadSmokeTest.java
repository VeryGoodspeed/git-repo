package com.praxis.siho.test.smoke;

import com.praxis.siho.test.WebDriverSetup;
import com.praxis.siho.test.dataprovider.SmokeTestDP;
import com.praxis.siho.test.pages.main.LogInPage;
import com.praxis.siho.test.pages.main.MainPage;
import com.praxis.siho.test.pages.main.rentabilidad.ControlCambiosPage;
import com.praxis.siho.test.pages.main.rentabilidad.RentabilidadProyectoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.praxis.siho.test.common.constants.GroupsConstants.*;

/**
 * Created by administrativo on 07/07/15.
 */
public class RentabilidadSmokeTest extends WebDriverSetup {

    @Test(enabled = true, priority = 1, groups = {SMOKE, RENTABILIDAD}, dataProviderClass = SmokeTestDP.class, dataProvider = "SIGNON_RENTABILIDAD")
    public void signOn(String credential, String password) {
        LogInPage logInPage = new LogInPage(driver).refreshPage();
        System.out.println("after instanciating login page: " + logInPage);
        Assert.assertNotNull(logInPage);
        System.out.println("before method signon");
        MainPage mainPage = logInPage.signon(credential, password);
        Assert.assertNotNull(mainPage);
    }

    @Test(enabled = true, priority = 2, groups = {SMOKE, RENTABILIDAD})
    public void casoAgregarControlCambios(){
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        System.out.println("foreigner");
        ControlCambiosPage ctrlCambiosPage = mainPage.linkToControlCambiosPage();
        System.out.println("gouden carolous");
        List<String> responseMessages = ctrlCambiosPage.crearNuevoControlCambio();
        if (responseMessages.isEmpty())
            Assert.fail("Error en el caso de prueba Agregar Control de cambios");
        Assert.assertEquals(responseMessages.get(0), ctrlCambiosPage.SUCCESS, "Error al dar de alta control de cambios");
    }
    @Test(enabled = false, priority = 2, groups = {SMOKE, RENTABILIDAD})
    public void casoConsultarRentabilidadProyecto(){
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        RentabilidadProyectoPage rentabilidadProyectoPage = mainPage.linkToRentabilidadProyectoPage();
        List<String> responseMessages = rentabilidadProyectoPage.consultarRentabilidad();
        System.out.println("passed successsfullly mate");
        for (String strong : responseMessages)
            System.out.println(strong);
        //if (responseMessages.isEmpty())
        //    Assert.fail("Error en el caso de prueba Agregar Control de cambios");
        //Assert.assertEquals(responseMessages.get(0), ctrlCambiosPage.SUCCESS, "Error al dar de alta control de cambios");
    }
}
