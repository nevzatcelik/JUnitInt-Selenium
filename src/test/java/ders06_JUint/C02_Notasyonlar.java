package ders06_JUint;

import org.junit.*;

public class C02_Notasyonlar {

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class Calisti");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("After Class Calisti");
    }

    @Before
    public void setupMethod(){
        System.out.println("Before Calisti");
    }
    @After
    public void afterMethod(){
        System.out.println("after metnhod calisti");
    }
    @Test
    public void tes1(){
        System.out.println("Test1 Calisti");
    }
    @Test @Ignore
    public void test2() {
        System.out.println("Test2 Calisti");
    }
    @Test
    public void test3() {
        System.out.println("Test3 Calisti");
    }

}
