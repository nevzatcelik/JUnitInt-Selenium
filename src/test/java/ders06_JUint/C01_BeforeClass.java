package ders06_JUint;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass {
    /*

     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

        @Test
        public void testnutella() {

            driver.get("https://www.amazon.com");
            WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
            WebElement aramaSonucElementi=driver.findElement(By.xpath("//div[@class=‘a-section a-spacing-small a-spacing-top-small’]"));
            System.out.println(aramaSonucElementi.getText());
        }
         @Test
         public void testJava() {

          driver.get("https://www.amazon.com");
             WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
             aramaKutusu.sendKeys("Java"+ Keys.ENTER);
             WebElement aramaSonucElementi=driver.findElement(By.xpath("//div[@class=‘a-section a-spacing-small a-spacing-top-small’]"));
             System.out.println(aramaSonucElementi.getText());

    }
    @Test
    public void selenium() {

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Selenium"+ Keys.ENTER);
        WebElement aramaSonucElementi=driver.findElement(By.xpath("//div[@class=‘a-section a-spacing-small a-spacing-top-small’]"));
        System.out.println(aramaSonucElementi.getText());
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }


}
