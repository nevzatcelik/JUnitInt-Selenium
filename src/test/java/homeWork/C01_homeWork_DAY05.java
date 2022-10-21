package homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_homeWork_DAY05 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
          /*
        1-C01_TekrarTesti isimli bir class olusturun
        2- https://www.google.com/ adresine gidin
        3- cookies uyarisini kabul ederek kapatin
        4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        5- Arama cubuguna “Nutella” yazip aratin
        6-Bulunan sonuc sayisini yazdirin
        7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        8-Sayfayi kapatin
                             Collapse
         */
        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        WebElement cerezler = driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]"));
        cerezler.click();


        if (driver.getTitle().contains("Google")) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }


        WebElement aramaMotoru = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaMotoru.sendKeys("Nutella" + Keys.ENTER);


        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));

        // Yaklaşık 147.000.000 sonuç bulundu (0,41 saniye)
        System.out.println(result.getText());
        String resultstr = result.getText();
        resultstr = resultstr.substring(
                (resultstr.indexOf(" ") + 1),
                (resultstr.indexOf("sonuç") - 1));
        System.out.println(resultstr); // 147000000

        resultstr = resultstr.replaceAll("\\.", "");
        System.out.println(resultstr); // 147000000

        if (Integer.parseInt(resultstr) > 10000000) {
            System.out.println("sonuc sayisi 10000000'den fazla test PASSED");
        } else {
            System.out.println("sonuc sayisi 10000000'den az test FAILED");
        }
    }


    @Test
    public void Test2() throws InterruptedException {
        /*
        1. “https://www.saucedemo.com” Adresine gidin
        2. Username kutusuna “standard_user” yazdirin
        3. Password kutusuna “secret_sauce” yazdirin
        4. Login tusuna basin
        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        6. Add to Cart butonuna basin
        7. Alisveris sepetine tiklayin
        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        9. Sayfayi kapatin
        /*

         */

        driver.get("https://www.saucedemo.com");
        WebElement usarname = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]"));

        usarname.sendKeys("standard_user");
        Thread.sleep(1000);


        WebElement password= driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]"));
        password.sendKeys("secret_sauce");
        Thread.sleep(1000);

        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();
        Thread.sleep(1000);

        WebElement ilkurunName=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        System.out.println("Product name= "+ilkurunName.getText());
        ilkurunName.click();
        Thread.sleep(1000);

        WebElement addCart=driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        addCart.click();

        WebElement alisverissepetine=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        alisverissepetine.click();

        WebElement sepeteEklendigin=driver.findElement(By.xpath("//div[@class='cart_item']"));
        if (sepeteEklendigin.isDisplayed()){
            System.out.println("Product added to Basket Test PASSED");
        }else {
            System.out.println("Product added to Basket Test FAILED");
        }

    }






    @After
    public void tearDown() {

        //driver.quit();
    }
}



