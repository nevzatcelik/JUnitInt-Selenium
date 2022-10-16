package ders05_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C02_Before_After {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void amazonTest(){


        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void facebookTest(){
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());

    }




    @Test
    public void YoutubeTest(){
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());

    }

    @After
    public void  tearDown(){
        driver.close();
    }
}
