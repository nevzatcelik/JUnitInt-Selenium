package ders13_excel_screenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C05_Screenshot extends TestBase {

    @Test
    public void test01() throws IOException {
        // amazon ana sayfaya gidelim
        driver.get("https://amazon.com");

        // tum sayfanin resmini cekelim
        tumSayfaResimCek();


        // arama kutusuna nutella yazip fotografini cekelim
       WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
       aramakutusu.sendKeys("Nutella");
       webelementScreenshot(aramakutusu);
       aramakutusu.submit();
        //aramayi yapip sonucun nutella icerdigini test edin

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedkelime="Nutella";
        String actualYazi= sonucYaziElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedkelime));

        //ve sonuc yazisinin fotografini cekin
        webelementScreenshot(sonucYaziElementi);
    }
}
