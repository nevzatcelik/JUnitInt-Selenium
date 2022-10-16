package ders06_JUint;

import org.junit.Assert;
import org.junit.Test;

public class C07_Assertions {
    int sayi1 = 10;
    int sayi2 = 20;
    int sayi3 = 30;

    /*
    Junit de Asset clasindaki hazir methodlar gerceklesen sonuclarin beklentilerimize uygun olup olmadigini
    kontrol eder

    Expected result ile actual result ayni ise test Passed
    Expected result ile actual result farkli ise test Failed

    Genel olarak ifade etmek istersek;
    Test cumlesi olumlu ise assertTrue
    Test cumlesi olumsuz ise AssetFalse tercih edilir

    Assertion'nin failed oldugu satirda kodlarin calismasi durur
    o methodun icerisinde failed olan assertion dan sonraki satirlar CALISTIRILMAZ
     */

    @Test
    public void test1() {

        //sayi1 in sayi 2 den kucuk oldugunu test edin
       /*
       Assert clasinda cok kullanacagimiz 4 hazir method bulunur
       Assert.assertTrue
       Assert.assertFalse
       Assert.assertEquals
       Assert.assertNotEquals
        */
        Assert.assertTrue(sayi1 < sayi2);

        Assert.assertFalse(sayi1 > sayi2);

        Assert.assertEquals(sayi1, sayi2);

    }

    @Test
    public void test2() {
        Assert.assertEquals(sayi3, sayi1 + sayi2);
    }

    @Test
    public void test3() {
        Assert.assertNotEquals(sayi3, sayi2);
    }

    @Test
    public void test4() {
        Assert.assertTrue(sayi3 == sayi2); //FAILED
    }

    @Test
    public void test5() {
        Assert.assertFalse(sayi3 == sayi2); //PASSED
    }

    @Test
    public void test6() {
        Assert.assertNotEquals(sayi3, sayi2 + sayi1); //FAILED
    }

    @Test
    public void test7() {
        Assert.assertTrue(sayi3 < sayi2); //FAILED
    }

    @Test
    public void test8() {
        Assert.assertFalse(sayi3>sayi2); //FAILED
    }
}
