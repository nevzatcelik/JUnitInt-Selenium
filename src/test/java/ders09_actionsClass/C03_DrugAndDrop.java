package ders09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_DrugAndDrop extends TestBase {

    /*
    Yeni bir class olusturalim: MouseActions2
    1- https://demoqa.com/droppable adresine gidelim
     2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
     3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */
    @Test
    public void test01(){
        driver.get("https://demoqa.com/droppable");
        WebElement dragMe= driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();

        WebElement dropped= driver.findElement(By.xpath("//p[text()='Dropped!']"));

        String expected="Dropped!";
        String actual=dropped.getText();

        Assert.assertEquals(expected,actual);
    }
}
