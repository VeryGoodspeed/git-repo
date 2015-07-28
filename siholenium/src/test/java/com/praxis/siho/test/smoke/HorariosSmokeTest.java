package com.praxis.siho.test.smoke;

import com.praxis.siho.test.WebDriverSetup;
import com.praxis.siho.test.dataprovider.SmokeTestDP;
import com.praxis.siho.test.pages.main.LogInPage;
import com.praxis.siho.test.pages.main.MainPage;
import com.praxis.siho.test.pages.main.horarios.ConsultaHorariosPage;
import com.praxis.siho.test.pages.main.horarios.ControlHorariosPage;
import com.praxis.siho.test.pages.main.horarios.PuntualidadAsistenciaPage;
import com.praxis.siho.test.pages.main.horarios.RegistroHorariosPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.praxis.siho.test.common.constants.GroupsConstants.*;

/**
 * Created by administrativo on 03/07/15.
 */
public class HorariosSmokeTest extends WebDriverSetup {

    @Test(enabled = true, priority = 1, groups = {SMOKE, HORARIOS}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
    public void signOn(String credential, String password) {
        LogInPage logInPage = new LogInPage(driver).refreshPage();
        System.out.println("after instanciating login page: " + logInPage);
        Assert.assertNotNull(logInPage);
        System.out.println("before method signon");
        MainPage mainPage = logInPage.signon(credential, password);
        Assert.assertNotNull(mainPage);
    }
    @Test(enabled = true, priority = 2, groups = {SMOKE, HORARIOS})
    public void casoRegistrarHorario(){
        System.out.println("caso: casoRegistrarHorario_______________________________");
        MainPage mainPage = new MainPage(driver).refreshPage();
        RegistroHorariosPage registroHorariosPage = mainPage.linkToRegistroHorariosPage();
        Assert.assertNotNull(registroHorariosPage);
        Assert.assertEquals(registroHorariosPage.guardarHorarios(), registroHorariosPage.SUCCESS, "Error al guardar Horario");
        System.out.println("successful");
    }

    @Test(enabled = true, priority = 2, groups = {SMOKE, HORARIOS})
    public void casoModificarHorario(){
        System.out.println("Caso casoModificarHorario_______________________");
        boolean success = false;
        MainPage mainPage = new MainPage(driver).refreshPage();
        ControlHorariosPage controlHorariosPage = mainPage.linkToControlHorariosPage();
        Assert.assertNotNull(controlHorariosPage);
        String responseMessage = controlHorariosPage.modificarHorario();
        if (responseMessage != null && responseMessage.startsWith(controlHorariosPage.SUCCESS)){
            success = true;
        }
        Assert.assertTrue(success, "Error message: " + responseMessage);
    }
    @Test(enabled = true, priority = 2, groups = {SMOKE, HORARIOS})
    public void casoModificarHorasRegistradas(){
        System.out.println("caso ModificarHorasRegistradas_______________________________");
        boolean success = false;
        MainPage mainPage = new MainPage(driver).refreshPage();
        /*RegistroHorariosPage reghrsPage = mainPage.linkToRegistroHorariosPage();
        System.out.println("fecha:::::::::::::" +reghrsPage.obtenerFechaConGuardadoHorario().get("fecha"));*/
        PuntualidadAsistenciaPage puntualidadAsistenciaPage = mainPage.linkToPuntualidadAsistenciaPage();
        Assert.assertNotNull(puntualidadAsistenciaPage );

        Assert.assertEquals(puntualidadAsistenciaPage.modificarHorasRegistradas(), puntualidadAsistenciaPage.SUCCESS);
    }

    @Test(enabled = true, priority = 2, groups = {SMOKE, HORARIOS})
    public void casoConsultarHorarios() {
        System.out.println("caso ConsultarHorarios____________ØØÆÐ§ªÞÆ§ÐªÆØ§ÐªØÆ§ØÐÞªÆ§ÐÞØÆ§ÐÞªØÆ§ÐªÆÆ§ÐªÆ§Ðª");
        boolean success = false;
        MainPage mainPage = new MainPage(driver).refreshPage();
        RegistroHorariosPage reghrsPage = mainPage.linkToRegistroHorariosPage();
        String fecha = reghrsPage.obtenerFechaConGuardadoHorario().get("fecha");
        ConsultaHorariosPage consultarHorariosPage = mainPage.linkToConsultaHorariosPage();
        Assert.assertNotNull(consultarHorariosPage);
        consultarHorariosPage.consultarHorarios(fecha);
        //Assert.assertEquals(consultarHorariosPage.consultarHorarios(), consultarHorariosPage.SUCCESS);
    }
}
