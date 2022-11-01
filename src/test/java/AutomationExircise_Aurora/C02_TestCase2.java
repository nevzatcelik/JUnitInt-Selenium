package AutomationExircise_Aurora;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C02_TestCase2 extends TestBase {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Delete Account' button
   10. Verify that 'ACCOUNT DELETED!' is visible
     */

    @Test
    public void test01(){
        //   2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        assertEquals(expectedTitle,driver.getTitle());
        // 4. Click on 'Signup / Login' button
        WebElement loginSignup= driver.findElement(By.xpath("//a[@href='/login']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(loginSignup).click(loginSignup).perform();
        //5. Verify 'Login to your account' is visible

       // 6. Enter correct email address and password


      //  7. Click 'login' button


       // 8. Verify that 'Logged in as username' is visible


      //  9. Click 'Delete Account' button
     driver.findElement(By.xpath("//span[text()='Kaydol']")).click();

      //  10. Verify that 'ACCOUNT DELETED!' is visible
    }
}
