package ders09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions extends TestBase {

    /*
    1- Yeni bir class olusturalim: MouseActions1
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu
   test edelim.
5- Tamam diyerek alert’i kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement cizgiliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

        Thread.sleep(1000);
        String alert=driver.switchTo().alert().getText();

        Assert.assertTrue(alert.contains("You selected a context menu"));

        driver.switchTo().alert().accept();
         String ilksayfaHandleDegeri= driver.getWindowHandle();


        WebElement elementalSelenium= driver.findElement(By.xpath("//a[@target='_blank']"));
        elementalSelenium.click();
        Thread.sleep(1000);

        Set<String> hamndleDegerlerSeti=driver.getWindowHandles();
        String ikinciSayfaHandleDegeri="";

        for (String eachHandleDegeri: hamndleDegerlerSeti
             ) {
            if (!eachHandleDegeri.equals(ilksayfaHandleDegeri));
            ikinciSayfaHandleDegeri=eachHandleDegeri;
        }

        driver.switchTo().window(ikinciSayfaHandleDegeri);


        WebElement h1Yazi= driver.findElement(By.xpath("(//div[@class='large-12 columns text-center'])[1]"));
        h1Yazi.getText();
        Thread.sleep(1000);

        String expected="Elemental Selenium";
        String actual=h1Yazi.getText();

        Assert.assertEquals(expected,actual);





    }

}
