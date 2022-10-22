package ders09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_Facebook_Kayit extends TestBase {
    @Test
    public void test01(){

        driver.get("https://www.facebook.com");

        WebElement cookies=driver.findElement(By.xpath("(//button[@value='1'])[2]"));
        cookies.click();

        WebElement newAccount=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        newAccount.click();

        WebElement name= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.click(name).sendKeys("Nevzat").
                sendKeys(Keys.TAB).
                sendKeys("Celik").sendKeys(Keys.TAB).
                sendKeys("fatih@gmail.com").sendKeys(Keys.TAB).
                sendKeys("fatih@gmail.com").sendKeys(Keys.TAB).
                sendKeys("1234556").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("13").sendKeys(Keys.TAB).
                sendKeys("Eki").sendKeys(Keys.TAB).
                sendKeys("1998").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }
}
