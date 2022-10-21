package PracAyseHocam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03_homework_hasNotFinished {
    WebDriver driver;
    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
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

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addCart= driver.findElement(By.xpath("//button[@onclick]"));
        int baslangic=0;
        int bitis=100;
        Thread.sleep(1000);

        for (int i=baslangic;i <=bitis ;addCart.click()){
            i++;
            Thread.sleep(0,5000);
        }




        WebElement deleteButton=driver.findElement(By.xpath("//div[@id='elements']"));
        int deleteNumber=40;

        for (int i = 0; deleteNumber <=40 ; deleteButton.click()) {
            deleteNumber--;
            Thread.sleep(1000);
        }



    }

    @After
    public void tearDown(){
        // driver.close();
    }

}

