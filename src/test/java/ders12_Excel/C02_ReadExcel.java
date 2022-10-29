package ders12_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    /*
    7. Dosya yolunu bir String degiskene atayalim
    8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    10. WorkbookFactory.create(fileInputStream)
    11. Worksheet objesi olusturun workbook.getSheetAt(index)
    12. Row objesi olusturun sheet.getRow(index)
    13. Cell objesi olusturun row.getCell(index)
     */
    @Test
    public void readExcelTesti() throws IOException {
        String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\ulkeler.xlsx";
       

        System.out.println(dosyaYolu);

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook=WorkbookFactory.create(fis);

        Sheet sheet=workbook.getSheet("Sayfa1");

        Row row=sheet.getRow(13);

        Cell cell=row.getCell(2);

        String expectedIsim="Bahreyn";
        String actualIsim=cell.toString();

        Assert.assertEquals(expectedIsim,actualIsim);

    }
}
