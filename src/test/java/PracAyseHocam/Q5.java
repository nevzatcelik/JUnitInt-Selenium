package PracAyseHocam;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Q5 extends TestBase {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Contact Us' button
    5. Verify 'GET IN TOUCH' is visible
    6. Enter name, email, subject and message
    7. Upload file
    8. Click 'Submit' button
    9. Click OK button
    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test
    public void test01(){
       // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

      //  3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        assertEquals(expectedTitle,driver.getTitle());

        //  4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href=\"/contact_us\"]")).click();
      // WebElement contactUs= driver.findElement(By.xpath("//a[@href=\"/contact_us\"]"));
     //  Actions actions=new Actions(driver);
      // actions.moveToElement(contactUs).click().perform();



       // 5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch=driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        assertTrue(getInTouch.isDisplayed());


       // 6. Enter name, email, subject and message
        WebElement name= driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        name.sendKeys("Nevzat");

        WebElement mail= driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        mail.sendKeys("ali@gmail.com");

        WebElement subject= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        subject.sendKeys("Selenium");

        WebElement message=driver.findElement(By.xpath("//textarea[@name='message']"));
        message.sendKeys("Hello World");

       // 8. Click 'Submit' button
      //  driver.findElement(By.xpath("//input[@type='submit']")).click();

     //   driver.findElement(By.xpath("//h2[@class='title text-center']")).click();
        bekle(1);
        Actions actions=new Actions(driver);
    //    actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
           //     sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
       // driver.findElement(By.name("submit")).click();

     //9. Click OK button

        driver.switchTo().alert().accept();

     //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement message2= driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
      //  Assert.assertTrue(message2.isDisplayed());
        String expectedmessage="Success! Your details have been submitted successfully.";
        String actualmessage=message2.getText();
        assertEquals(expectedmessage,actualmessage);


     //  11. Click 'Home' button and verify that landed to home page successfully
        WebElement getHome=driver.findElement(By.xpath("//a[@class='btn btn-success']"));
       getHome.click();
      //  actions.click(getHome).perform();
      //  getHome.sendKeys(Keys.ENTER);





     // assertFalse(driver.findElement(By.xpath("(//a[@href='/'])[2]")).isSelected());

        //12.and verify that landed to home page successfully
       assertTrue(driver.findElement(By.xpath("(//div[@class=\"carousel-inner\"])[1]")).isDisplayed());

       // String expectedUrl="http://automationexercise.com";
       // String actualUrl= driver.getCurrentUrl();
       // assertEquals(expectedUrl,actualUrl);
        System.out.println(driver.getCurrentUrl());

        //  assertEquals(expectedTitle,driver.getTitle());



    }
}
