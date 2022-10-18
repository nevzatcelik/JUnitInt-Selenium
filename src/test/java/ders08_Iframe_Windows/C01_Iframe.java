package ders08_Iframe_Windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {
    WebDriver driver;

    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
     ○ Text Box’a “Merhaba Dunya!” yazin.
     ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
     */
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void iframe() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement anIframeYaziElemeti= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeYaziElemeti.isEnabled());
        System.out.printf(anIframeYaziElemeti.getText());

        WebElement iframeElemeti= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElemeti);

        WebElement yaziElemetiAlani= driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(1000);
        yaziElemetiAlani.clear();
        yaziElemetiAlani.sendKeys("Merhaba Dunya!");
        Thread.sleep(2000);


       driver.switchTo().defaultContent();
        WebElement elementalSelenium= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isEnabled());
        System.out.printf(elementalSelenium.getText());


    }

    @After
    public void tearDown(){
       driver.close();
    }
}

