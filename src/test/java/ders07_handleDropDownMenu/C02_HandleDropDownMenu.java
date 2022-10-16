package ders07_handleDropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_HandleDropDownMenu {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void dropDownTest() {
        driver.get("https://amazon.com");
        WebElement dropdownWebElement= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropdownWebElement);
        int options=select.getOptions().size();
        Assert.assertEquals(27, options);


    }

    @After
    public void tearDown(){
          driver.close();
    }
}