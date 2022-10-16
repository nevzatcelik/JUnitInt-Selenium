package ders06_JUint;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButtonTest {
    /*
      JUnit otomatik olarak test sonuclarini passed veya failed olarak verir
       ANCAK,
       JUnit temel olarak kodun calisip, problemsiz olarak bittigini raporlar
       JUnit'de Assert class'i kullanilarak testleri yaparsak
       o zaman istedigimiz dogru test raporlarini verecektir.
     */

    // 1. Bir class oluşturun : RadioButtonTest
    // 2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // https://www.facebook.com adresine gidin
    // Cookies’i kabul edin
    // “Create an Account” button’una basin
    // “radio buttons” elementlerini locate edin
    // size uygun olan cinyet butonunun secili oldugunu test edin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void test01() throws InterruptedException {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //Cookies’i kabul edin
        WebElement cookiesButonu= driver.findElement(By.xpath("//button[@title='Sadece temel çerezlere izin ver']"));
        cookiesButonu.click();
        //“Create an Account” button’una basin
        WebElement yeniHesapButonu= driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        yeniHesapButonu.click();
        //“radio buttons” elementlerini locate edin
        WebElement cinsiyetRadioButtonu= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        // size uygun olan cinyet butonunun secili oldugunu test edin
        if (cinsiyetRadioButtonu.isSelected()){
            System.out.println("Cinsiyet butonu secili Test PASSED");
        } else {
            System.out.println("Cinsiyet Butonu Secili Degil Test FAILED");
        }
        Thread.sleep(5000);
    }
    @After
    public void teardown(){
        driver.close();
    }

}
