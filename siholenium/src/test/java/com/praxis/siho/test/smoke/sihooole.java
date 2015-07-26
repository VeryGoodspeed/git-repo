package com.praxis.siho.test.smoke;

import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class sihooole extends SeleneseTestNgHelper {
    @Test
    public void testErgo() throws Exception {
        System.out.println("goddamit this shit actually worked!!");
        selenium.open("http://192.168.6.99:8080/sihoweb/login.xhtml");
        selenium.type("id=j_username", "RALA");
        selenium.type("id=j_password", "12345678");
        selenium.click("id=btnLogin");
        selenium.waitForPageToLoad("30000");
        selenium.click("//div[@id='j_idt13:j_idt15']/ul/li[3]/ul/li[3]/a/span");
        selenium.waitForPageToLoad("30000");
        selenium.click("//div[@id='j_idt22:selectOneMenuRecursos']/div[3]/span");
        selenium.click("//div[@id='j_idt13:j_idt15']/ul/li[3]/ul/li[5]/a/span");
        selenium.waitForPageToLoad("30000");
        selenium.click("id=j_idt22:selectOneMenuRecursos_label");
        selenium.click("css=span.ui-icon.ui-icon-pencil");
        selenium.type("id=j_idt22:tableHorarios:0:j_idt43", "04:30");
        selenium.type("id=j_idt22:tableHorarios:0:j_idt48", "20:30");
        selenium.click("css=span.ui-icon.ui-icon-check");
        selenium.getTitle();
        System.out.println("goddamit this shit actually worked right to the end!!");
    }
}