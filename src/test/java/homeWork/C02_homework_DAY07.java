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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_homework_DAY07 {
    WebDriver driver;
    /*
    1. http://zero.webappsecurity.com/ Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. “amount” kutusuna bir sayi girin
    10. “US Dollars” in secilmedigini test edin
    11. “Selected currency” butonunu secin
    12. “Calculate Costs” butonuna basin
    13.  sonra “purchase” butonuna basin
    14. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

     https://the-internet.herokuapp.com/javascript_alerts
     */

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() throws InterruptedException {
      //  1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
       //2. Sign in butonuna basin

        WebElement singInButton=driver.findElement(By.xpath("//button[@id='signin_button']"));
        singInButton.click();
        Thread.sleep(1000);
        //3. Login kutusuna “username” yazin

        WebElement username= driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("username");
        Thread.sleep(1000);

        // 4. Password kutusuna “password” yazin
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
       password.sendKeys("password"+ Keys.ENTER);
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        WebElement moreBankService= driver.findElement(By.xpath("//a[@id='online-banking']"));
        moreBankService.click();
        Thread.sleep(1000);

        //6.Pay Bills sayfasina gidin
        WebElement payBills=driver.findElement(By.xpath("(//span[@class='headers'])[4]"));
        payBills.click();
        Thread.sleep(1000);

        //  7. “Purchase Foreign Currency” tusuna basin
        WebElement purchaseForeignCurrency= driver.findElement(By.xpath("//a[@href=\"#ui-tabs-3\"]"));
        purchaseForeignCurrency.click();
        Thread.sleep(1000);

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement eurozone= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(eurozone);
        select.selectByVisibleText("Eurozone (euro)");
        Thread.sleep(1000);


        //9. “amount” kutusuna bir sayi girin
        WebElement amount= driver.findElement(By.xpath("(//input[@type='text'])[5]"));
        amount.sendKeys("1000");
        Thread.sleep(1000);

       // 10. “US Dollars” in secilmedigini test edin
        WebElement uSDollars=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        System.out.println(uSDollars.isSelected());
        Thread.sleep(1000);

       //11. “Selected currency” butonunu secin
        WebElement selectedCurrency=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        selectedCurrency.click();
        Thread.sleep(1000);

        //12. “Calculate Costs” butonuna basin
        WebElement calculateCost=driver.findElement(By.xpath("//input[@type='button']"));
        calculateCost.click();
        Thread.sleep(1000);
      //13 .sonra “purchase” butonuna basin
        WebElement purshase= driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        purshase.click();
        Thread.sleep(1000);

        //14. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement result=driver.findElement(By.xpath("//div[@id='alert_content']"));
        result.isDisplayed();

    }

     @After
    public void tearDown(){
         driver.close();
    }
}
