package com.praxis.siho.test.smoke;

import com.praxis.siho.test.WebDriverSetup;
import com.praxis.siho.test.common.util.RandomData;
import com.praxis.siho.test.dataprovider.SmokeTestDP;
import com.praxis.siho.test.pages.main.LogInPage;
import com.praxis.siho.test.pages.main.MainPage;
import com.praxis.siho.test.pages.main.psp.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static com.praxis.siho.test.common.constants.GroupsConstants.PSP;
import static com.praxis.siho.test.common.constants.GroupsConstants.SIGNON;
import static com.praxis.siho.test.common.constants.GroupsConstants.SMOKE;

/*
 * Created by administrativo on 31/07/15.
 */
public class PspSmokeTest extends WebDriverSetup {

    String cicloPspRandomName = "Selenio " + RandomData.getRandomLetter(false) + RandomData.generateRandomNumberUpTo(100);
    String randomCatNivel     = "Sel psp " + RandomData.getRandomLetter(false) + RandomData.generateRandomNumberUpTo(222);
    String randomCatFase      = "Sel fase Analisis " + RandomData.getRandomLetter(false) + RandomData.generateRandomNumberUpTo(222);
    String randomCatAct       = "Sel actividad " + RandomData.getRandomLetter(false) + RandomData.generateRandomNumberUpTo(222);
    @Test(enabled = true, priority = 1, groups = {SMOKE, PSP}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
    public void signOn(String credential, String password) {
        System.out.println("____________________________________________________");
        System.out.println("[test case: signon]");
        LogInPage logInPage = new LogInPage(driver).refreshPage();
        Assert.assertNotNull(logInPage);
        MainPage mainPage = logInPage.signon(credential, password);
        Assert.assertNotNull(mainPage);
    }

    @Test(enabled = true, priority = 2, groups = {SMOKE, PSP})
    public void casoAgregarNuevaConfiguracionProyecto() {
        System.out.println("____________________________________________________");
        System.out.println("[test case: casoAgregarNuevaConfiguracionProyecto]");
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        ConfiguracionProyectosPage configuracionProyectosPage = mainPage.linkToConfiguracionProyectosPage();
        Assert.assertEquals(configuracionProyectosPage.agregarNuevaConfiguracionProyecto(cicloPspRandomName), configuracionProyectosPage.SUCCESS);
    }

    @Test(enabled = true, priority = 2, groups = {SMOKE, PSP})
    public void casoEstimacionDeTamanio() {
        System.out.println("____________________________________________________");
        System.out.println("[test case: casoEstimacionDeTamanio]");
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        EstimacionTamanioPage estimacionTamanioPage = mainPage.linkToEstimacionTamanioPage();
        Assert.assertEquals(estimacionTamanioPage.estimarTamanio(cicloPspRandomName), estimacionTamanioPage.SUCCESS);
    }

    @Test(enabled = true, priority = 2, groups = {SMOKE, PSP})
    public void casoAgregarACatalogoNivelFaseAct() {
        System.out.println("____________________________________________________");
        System.out.println("[test case: casoAgregarACatalogoNivelFaseAct]");
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        CatalogoNivelFaseActPage catalogoNivelFaseActPage = mainPage.linkToCatalogoNivelFaseActPage();
        catalogoNivelFaseActPage.agregarACatalogoNivelFaseActividades(randomCatNivel, randomCatFase, randomCatAct);
        //Assert.assertEquals(estimacionTamanioPage.estimarTamanio(), estimacionTamanioPage.SUCCESS);
    }

    @Test(enabled = true, priority = 3, groups = {SMOKE, PSP})
    public void casoBorrarDeCatalogoNivelFaseAct() {
        System.out.println("____________________________________________________");
        System.out.println("[test case: casoBorrarDeCatalogoNivelFaseAct]");
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        CatalogoNivelFaseActPage catalogoNivelFaseActPage = mainPage.linkToCatalogoNivelFaseActPage();
        Assert.assertTrue(catalogoNivelFaseActPage.borrarRegistroDeCatalogoNivelFaseActividades(randomCatNivel, randomCatFase, randomCatAct));
    }
    @Test(enabled = true, priority = 2, groups = {SMOKE, PSP})
    public void casoCapturarDefectos() {
        System.out.println("____________________________________________________");
        System.out.println("[test case: casoCapturarDefectos]");
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        CapturaDefectosPage capturaDefectosPage = mainPage.linkToCapturaDefectosPage();
        capturaDefectosPage.capturarDefecto(cicloPspRandomName);
        //Assert.assertTrue(capturaDefectosPage.capturarDefectos(randomCatNivel, randomCatFase, randomCatAct));
    }
    @Test(enabled = false, priority = 3, groups = {SMOKE, PSP})
    public void casoAgregarPlantilla() {
        //TODO: find a way to upload a file using selenium
        System.out.println("____________________________________________________");
        System.out.println("[test case: casoAgregarPlantilla]");
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        CatalogoPlantillasPage catalogoPlantillasPage = mainPage.linkToCatalogoPlantillasPage();
        catalogoPlantillasPage.agregarPlantilla();
        //Assert.assertTrue(capturaDefectosPage.capturarDefectos(randomCatNivel, randomCatFase, randomCatAct));
    }

    @Test(enabled = true, priority = 3, groups = {SMOKE, PSP})
    public void casoAgregarDefectos() {
        System.out.println("____________________________________________________");
        System.out.println("[test case: casoAgregarDefectos]");
        String cveDef    = String.valueOf(RandomData.generateRandomNumberUpTo(1000));
        String nombreDef = RandomData.getRandomLetter(false) + RandomData.getRandomLetter(true) + RandomData.generateRandomNumberUpTo(1234);
        String descDef   = "Descripción " + RandomData.getRandomLetter(false) + RandomData.getRandomLetter(true) + RandomData.generateRandomNumberUpTo(1234);
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        CatalogoDefectosPage catalogoDefectosPage= mainPage.linkToCatalogoDefectosPage();
        String response = catalogoDefectosPage.agregarDefecto(cveDef, nombreDef, descDef).get(0);
        System.out.println("About to send: " + response);
        Assert.assertEquals(response, catalogoDefectosPage.SUCCESS);
        //Assert.assertTrue(capturaDefectosPage.capturarDefectos(randomCatNivel, randomCatFase, randomCatAct));
    }

    @Test(enabled = false, priority = 3, groups = {SMOKE, PSP})
    public void casoAgregarTipoMedida() {
        //TODO: enable test after application has solved errors concerning dimensions of screen
        System.out.println("test: casoAgregarPlantilla()");
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        CatalogoTipoMedidaPage catalogoTipoMedidaPage = mainPage.linkToCatalogoTipoMedidaPage();
        System.out.println("about to start everything");
        System.out.println();
        catalogoTipoMedidaPage.agregarTipoMedida();
        //Assert.assertEquals(catalogoTipoMedidaPage.agregarTipoMedida().get(0), catalogoTipoMedidaPage.SUCCESS);
        //Assert.assertTrue(capturaDefectosPage.capturarDefectos(randomCatNivel, randomCatFase, randomCatAct));
    }
    @Test(enabled = false, priority = 3, groups = {SMOKE, PSP})
    public void casoAgregarTipoFuncionalidad() {
        //TODO: enable test after application has solved errors concerning dimensions of screen
        System.out.println("test: casoAgregarTipoFuncionalidad()");
        MainPage mainPage = new MainPage(driver).refreshPage();
        Assert.assertNotNull(mainPage);
        CatalogoTipoFuncionalidadPage catalogoTipoFuncionalidadPage = mainPage.linkToCatalogoTipoFuncionalidadPage();
        System.out.println(catalogoTipoFuncionalidadPage.agregarTipoFuncionalidad());
        //Assert.assertEquals(catalogoTipoMedidaPage.agregarTipoMedida().get(0), catalogoTipoMedidaPage.SUCCESS);
        //Assert.assertTrue(capturaDefectosPage.capturarDefectos(randomCatNivel, randomCatFase, randomCatAct));
    }
}
