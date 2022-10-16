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

public class C04_CheckBoxTest {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if (checkBox1.isSelected()){
            System.out.println("Checkbox1 secili,Test FAILED");

        }else System.out.println("Checkbox1 secili degil,Test PASSED");

        if (checkBox2.isSelected()){
            System.out.println("Checkbox2 secili,Test PASSED");
        }else System.out.println("Checkbox2 secili degil,Test FAILED");
    }
    @After
    public void tearDown(){
        driver.close();
    }


}
