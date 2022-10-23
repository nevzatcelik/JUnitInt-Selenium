package ders10_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDowload_Testi extends TestBase {
    /*
    1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
2. https://the-internet.herokuapp.com/download adresine gidelim.
3. code.txt dosyasını indirelim
4. Dosyanın başarıyla indirilip indirilmediğini test edelim
     */


    @Test
    public void dowloadTesti(){
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement logoPgn= driver.findElement(By.xpath("//*[text()='logo.png']"));
        logoPgn.click();
       bekle(5);

        String dosyaYolu=System.getProperty("user.home")+"/Downloads/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
