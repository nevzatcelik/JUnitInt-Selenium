package homeWork;

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

public class Soru {
    // 1. Launch browser
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void automation() throws InterruptedException {
        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement homepageGörünme= driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue(homepageGörünme.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignupElementiGörünme= driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignupElementiGörünme.isDisplayed());

        //6. Enter name and email address
        WebElement nameElementi= driver.findElement(By.xpath("//input[@placeholder='Name']"));
        nameElementi.sendKeys("Ilhan");
        WebElement eMailElementi= driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]"));
        eMailElementi.sendKeys("illkk@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountGörünürElementi=driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(enterAccountGörünürElementi.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        WebElement passwordElementi= driver.findElement(By.xpath("//input[@id='password']"));
        passwordElementi.sendKeys("123456");

        WebElement birtDayElementi=driver.findElement(By.xpath("//select[@data-qa='days']"));
        Select select=new Select(birtDayElementi);
        select.selectByValue("1");

        WebElement birtMonthElementi=driver.findElement(By.xpath("//select[@id='months']"));
        Select select1=new Select(birtMonthElementi);
        select1.selectByValue("3");

        WebElement birtYearElementi=driver.findElement(By.xpath("(//select[@id='years'])[1]"));
        Select select2=new Select(birtYearElementi);
        select2.selectByValue("2000");

        Thread.sleep(1000);
        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("(//input[@id='newsletter'])[1]")).click();
        Thread.sleep(1000);
        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstnameElementi= driver.findElement(By.xpath("//input[@id='first_name']"));
        firstnameElementi.sendKeys("Ilhan");

        WebElement lastnameElementi= driver.findElement(By.xpath("//input[@id='last_name']"));
        lastnameElementi.sendKeys("Benim");

        WebElement companyElementi= driver.findElement(By.xpath("//input[@id='company']"));
        companyElementi.sendKeys("Wise Quarter");

        WebElement adresElementi1= driver.findElement(By.xpath("//input[@id='address1']"));
        adresElementi1.sendKeys("Deuchland/ Word");

        WebElement countryElementi= driver.findElement(By.xpath("//select[@id='country']"));
        countryElementi.sendKeys("Almanya");
        Select select4=new Select(countryElementi);
        select4.selectByValue("India");

        WebElement stateElementi= driver.findElement(By.xpath("//input[@id='state']"));
        stateElementi.sendKeys("Hessen");

        WebElement cityElementi= driver.findElement(By.xpath("//input[@id='city']"));
        cityElementi.sendKeys("Frankfurt");

        WebElement zipCodeElementi= driver.findElement(By.xpath("//input[@id='zipcode']"));
        zipCodeElementi.sendKeys("60123");

        WebElement mobilNummerElementi= driver.findElement(By.xpath("//input[@id='mobile_number']"));
        mobilNummerElementi.sendKeys("+49123456789");


        //13. Click 'Create Account button'
        WebElement createAccountButonu=driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountButonu.click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedElementi=driver.findElement(By.xpath(" //*[@id=\"form\"]/div/div/div/h2/b "));
        Assert.assertTrue(accountCreatedElementi.isDisplayed());

        //15. Click 'Continue' button
        WebElement continueButonu=driver.findElement(By.id("//*[@id=\"form\"]/div/div/div/div/a"));
        continueButonu.click();
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }
    @After
    public void teardown(){
          driver.close();
    }

}