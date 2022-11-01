package AutomationExircise_Aurora;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.IOException;

import static org.junit.Assert.*;

public class C01_TestCase1 extends TestBase {

        //     mail=aurora@gmail.com
        //     password=aurora


        /*
         1. Launch browser
         2. Navigate to url 'http://automationexercise.com'
         3. Verify that home page is visible successfully
         4. Click on 'Signup / Login' button
         5. Verify 'New User Signup!' is visible
         6. Enter name and email address
         7. Click 'Signup' button
         8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
         9. Fill details: Title, Name, Email, Password, Date of birth
        10. Select checkbox 'Sign up for our newsletter!'
        11. Select checkbox 'Receive special offers from our partners!'
        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        13. Click 'Create Account button'
        14. Verify that 'ACCOUNT CREATED!' is visible
        15. Click 'Continue' button
        16. Verify that 'Logged in as username' is visible
        17. Click 'Delete Account' button
        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
         */

    @Test
    public void test01() throws IOException {
        //   2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

       // 3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        assertEquals(expectedTitle,driver.getTitle());

       // 4. Click on 'Signup / Login' button
        WebElement loginSignup= driver.findElement(By.xpath("//a[@href='/login']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(loginSignup).click(loginSignup).perform();

       //5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp= driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        assertTrue(newUserSignUp.isDisplayed());
     //  String expected="New User Signup!";
    //  String actual=newUserSignUp.getText();
     //  assertEquals(expected,actual);

       // 6. Enter name and email address
        WebElement name= driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("Nevzat=-");
        bekle(2);
        WebElement email= driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        email.sendKeys("Nevzatcelik15@.gmail.com");
        bekle(2);
        WebElement submit= driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        submit.click();
        bekle(2);
        assertTrue(newUserSignUp.isDisplayed());  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        name.clear();
        email.clear();
        bekle(2);
        System.out.println("===============================================================================");
        name.sendKeys("Nevzat");
        bekle(1);

        email.sendKeys("Nevzatcelik15@gmailcom");
        submit.click();

        bekle(1);
      //  assertTrue(newUserSignUp.isDisplayed());


        // 7. Click 'Signup' button

        tumSayfaResimCek();
       // assertTrue(newUserSignUp.isDisplayed());  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        driver.navigate().back();
        // burada bir hata mevcut ve bu hatayi bulup screenShot alalim
        // Eger bir TestCase de;
        // Olumsuz bir testi kontrol etmek istediysek ayni sayfada kaliyor olmamiz gerekir


        bekle(2);
        name.clear();
        bekle(1);
        name.sendKeys("Nevzat");
        bekle(1);
        email.clear();
        email.sendKeys("Nevzatttt111@gmail.com");
        bekle(1);
        submit.click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformation= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
       assertTrue(enterAccountInformation.isDisplayed());

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        actions.click(title).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("123456").sendKeys(Keys.TAB).
                sendKeys("20").sendKeys(Keys.TAB).sendKeys("May").sendKeys(Keys.TAB).sendKeys("1998").sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN). sendKeys(Keys.ARROW_DOWN). sendKeys(Keys.ARROW_DOWN). sendKeys(Keys.ARROW_DOWN).perform();

        // 10. Select checkbox 'Sign up for our newsletter!'
        // 11. Select checkbox 'Receive special offers from our partners!'
        WebElement newsLatter= driver.findElement(By.xpath("//input[@name='newsletter']"));
        WebElement reciveSpecial= driver.findElement(By.xpath("//input[@name='optin']"));
        actions.moveToElement(newsLatter).click(newsLatter).moveToElement(reciveSpecial).click(reciveSpecial).
                sendKeys(Keys.TAB).perform();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        // 13. Click 'Create Account button'
        actions.sendKeys("Nevzat").sendKeys(Keys.TAB).sendKeys("Celik").sendKeys(Keys.TAB).sendKeys("ISVEC").
                sendKeys(Keys.TAB).sendKeys("huddinge/Stockholm").sendKeys(Keys.TAB).sendKeys("-").sendKeys(Keys.TAB)
                .sendKeys("New Zealand").sendKeys(Keys.TAB).sendKeys("-").sendKeys(Keys.TAB).sendKeys("Stockholm")
                .sendKeys(Keys.TAB).sendKeys("12321").sendKeys(Keys.TAB).sendKeys("+4623232323").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCrt=driver.findElement(By.xpath("//*[text()='Account Created!']"));
      //  assertTrue(accountCrt.isDisplayed());
        String expectedMessage="ACCOUNT CREATED!";
        String actualMessage=accountCrt.getText();
        assertEquals(expectedMessage,actualMessage);

      //  15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
      //   16. Verify that 'Logged in as username' is visible
        WebElement logged=driver.findElement(By.xpath("(//li//a)[10]"));
        assertTrue(logged.isDisplayed());
        // 17. Click 'Delete Account' button
        WebElement deleteAccount=driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccount.click();
       //  18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
          WebElement deleted=driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
       //   assertTrue(deleted.isDisplayed());
        String expectedMessage2="ACCOUNT DELETED!";
        String actualMessage2=deleted.getText();
        assertEquals(expectedMessage2,actualMessage2);

    }
}