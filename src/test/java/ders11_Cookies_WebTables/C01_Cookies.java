package ders11_Cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Scanner;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//*[text()='Tümünü kabul et']")).click();

        Set<Cookie> cookieSeti=driver.manage().getCookies();
        for (Cookie eachCookie:cookieSeti
             ) {
            System.out.println(eachCookie);
        }

        System.out.println("============================================");

        Cookie cookie=new Cookie("En guzel cookie","bizim cookie");
        driver.manage().addCookie(cookie);
        System.out.println(cookie);
        bekle(5);


    }
}
