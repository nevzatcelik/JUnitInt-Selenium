package PracAyseHocam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AyseHocamOdev {
    /*
  ...Exercise4...
  https://www.teknosa.com/ adresine gidiniz
  arama cubuguna oppo yazip enter deyiniz
  sonuc sayisini yazdiriniz
  cikan ilk urune tiklayiniz
  sepete ekleyiniz
  sepetime git e tiklayiniz
  consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
  Alisverisi tamamlayiniz
  son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
  driver i kapatiniz
  */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

    @Before
    public void beforeTest(){
        //https://www.teknosa.com/ adresine gidiniz
        driver.get("https://www.teknosa.com/");
    }
    @After
    public void afterTest(){

    }


    @Test
    public void test01() throws InterruptedException {
        //arama cubuguna oppo yazip enter deyiniz
        driver.findElement(By.xpath("//input[@id='search-input']"))
                .sendKeys("oppo" +Keys.ENTER);
        //sonuc sayisini yazdiriniz
        System.out.println("Sonuc Sayisi : " + driver.findElement(By.xpath("//div[@class='plp-info']")).getText());
        Thread.sleep(1000);

        //cikan ilk urune tiklayiniz
        driver.findElement(By.xpath("(//a[@class='prd-link'])[2]")).click();
        Thread.sleep(1000);
        //sepete ekleyiniz
        driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]")).click();
        Thread.sleep(1000);
        // sepetime git e tiklayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();
        Thread.sleep(1000);
        //consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        System.out.println("Siparis Özeti : "+driver.findElement(By.xpath("//div[@class='cart-sum-body']")).getText());
        Thread.sleep(1000);
        //Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        //son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        WebElement hosgeldinizYazisi= driver.findElement(By.xpath("//div[@class='lrp-title']"));
        System.out.println(hosgeldinizYazisi.getText());
    }

}