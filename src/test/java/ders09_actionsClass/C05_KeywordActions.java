package ders09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeywordActions extends TestBase {


    @Test
    public void test01(){
        /*
        Klavye de cok fazla tus olsa da her bir tusla ilgili temel iki islem var.
        1- Tek seferlik basmak
        sendKeys(Keys.Enter)

        2-Uzun sureli basmak ve isimiz bitince tustan elimizi kaldirmak
           -Basmak icin keyDown()
           -Basili tusu birakmak icin keyUp()
         */
        // AMAZON ANA SAYFAYA GIDIN
        driver.get("https://www.amazon.com");
        // arama kutusuna nutella yazin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella");
        // aramayi yapmak icin enter tusuna basin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);


        WebElement aramaKutusu2= driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        aramaKutusu2.clear();
        // arama kutusuna actions class ini kullanarak SamsungA71 yazdirin
        Actions actions=new Actions(driver);
        bekle(1);
        actions.click(aramaKutusu2).
                keyDown(Keys.SHIFT).sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("amsung").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER)
                .perform();

        bekle(2);




    }
}
