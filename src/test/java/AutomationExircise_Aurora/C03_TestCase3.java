package AutomationExircise_Aurora;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_TestCase3 extends TestBase {

    /*
       1. Launch browser
       2. Navigate to url 'http://automationexercise.com'
       3. Verify that home page is visible successfully
       4. Click on 'Signup / Login' button
       5. Verify 'Login to your account' is visible
       6. Enter incorrect email address and password
       7. Click 'login' button
       8. Verify error 'Your email or password is incorrect!' is visible

     */



    @Test
    public void test01(){

        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

      //  3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("(//a[@href='/'])[2]")).isEnabled());
      //4. Click on 'Signup / Login' button
        WebElement signUpButton= driver.findElement(By.xpath("//a[@href='/login']"));
        signUpButton.click();
       // 5. Verify 'Login to your account' is visible
        WebElement visibleTest= driver.findElement(By.xpath("//*[text()=\"Login to your account\"]"));
        String expectedvisible="Login to your account";
        String actualvisible=visibleTest.getText();

        Assert.assertEquals(expectedvisible,actualvisible);
        //6. Enter incorrect email address and password
       // 7. Click 'login' button
        Actions actions=new Actions(driver);
        WebElement email= driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        actions.sendKeys(email,"nevzatcelik1@gmail.com").sendKeys(Keys.TAB).sendKeys("123456").
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
         //   8. Verify error 'Your email or password is incorrect!' is visible
         WebElement visibleTest2= driver.findElement(By.xpath(" //p[text()='Your email or password is incorrect!']"));
         String expectedvisible2="Your email or password is incorrect!";
         String actualvisible2=visibleTest2.getText();

         Assert.assertEquals(expectedvisible2,actualvisible2);



    }

}
