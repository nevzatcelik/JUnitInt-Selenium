package ders09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MoveToElement extends TestBase {
    /*
    Yeni bir class olusturalim: MouseActions3
    1- https://www.amazon.com/ adresine gidelim
    2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
    3- “Create a list” butonuna basalim
    4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");
        Actions actions=new Actions(driver);
        WebElement accounandList=driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));
        actions.moveToElement(accounandList).perform();
        WebElement crateList=driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        crateList.click();

        bekle(5);

        WebElement yourList=driver.findElement(By.xpath("(//div[@role='heading'])[1]"));
        String expected="Your Lists";
        String actual=yourList.getText();
        Assert.assertEquals(expected,actual);

    }
}
