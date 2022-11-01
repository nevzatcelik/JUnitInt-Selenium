package AutomationExircise_Aurora;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C04_TestCase4 extends TestBase {
    /*
     1. Launch browser
     2. Navigate to url 'http://automationexercise.com'
     3. Verify that home page is visible successfully
     4. Click on 'Signup / Login' button
     5. Verify 'Login to your account' is visible
     6. Enter correct email address and password
     7. Click 'login' button
     8. Verify that 'Logged in as username' is visible
     9. Click 'Logout' button
     10. Verify that user is navigated to login page
     */

    @Test
    public void test01(){
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
       // 3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        assertEquals(expectedTitle,driver.getTitle());
        //  4. Click on 'Signup / Login' button
        WebElement signUpButton= driver.findElement(By.xpath("//a[@href='/login']"));
        signUpButton.click();
        //5. Verify 'Login to your account' is visible
        WebElement visibleTest= driver.findElement(By.xpath("//*[text()=\"Login to your account\"]"));
        String expectedvisible="Login to your account";
        String actualvisible=visibleTest.getText();
       // 6. Enter correct email address and password
       // 7. Click 'login' button
        Actions actions=new Actions(driver);
        WebElement email= driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        actions.sendKeys(email,"aurora@gmail.com").sendKeys(Keys.TAB).sendKeys("aurora").
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInAsUsarname= driver.findElement(By.xpath(" //*[text()=' Logged in as ']"));
        assertTrue(loggedInAsUsarname.isDisplayed());
        // 9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
       // 10. Verify that user is navigated to login page
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl=driver.getCurrentUrl();

        assertEquals(expectedUrl,actualUrl);
    }
}
