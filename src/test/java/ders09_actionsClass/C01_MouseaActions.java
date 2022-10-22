package ders09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_MouseaActions extends TestBase {



    @Test
    public void test01(){

        driver.get("https://amazon.com");


        //driver.findElement(By.xpath("(//a[@class='icp-button'])[2]"));

        /*
        Bir test gerceklestirilirken,mouse veya klavye ile ektra islemler yapmak gerekebilir
        ornegin create list linkini tiklayabilmek icin
        Account&List menusunun uzerinde beklemek gerekir

        Driver genellikle(web developer larin kullandiklari argumanlara gore degisebilir) gorebilidigi web
        elementleri kullanabilir

        Selenium mouse ve klavye ile yapabilecegimiz tum fonksiyonlari driver ile gerceklestirebilmek icin
        Actions class ini olusturmustur.

         */

        //  Actions class inin ozelliklerini kullanabilmek icin obje olusturalim
        Actions actions=new Actions(driver);
        WebElement accountListElemeti= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountListElemeti).perform();
        //(//span[@class='nav-text'])[1]

        //   driver.findElement(By.xpath("//span[text()=‘Create a List’]")).click();



    }


}
