package tests.day13_excelOtomasyon_getScreenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ExceliMapeAktarma {

    @Test
    public void readExcelTesti() throws IOException {
        String dosyaYolu = "src/test/java/tests/day12_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // Ulkeler excel'indeki Turkce ulke isimleri ve
        // Turkce baskent isimlerini bir Map olarak kaydedin
        // Ulke isimleri key, baskent isimleri value olsun

        Map<String,String> ulkelerMap = new TreeMap<>();
        String satirdakiUlkeIsmi;
        String satirdakiBaskentIsmi;
        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatirIndex ; i++) {
            satirdakiUlkeIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString();
            satirdakiBaskentIsmi= workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(satirdakiUlkeIsmi,satirdakiBaskentIsmi);
        }

        // Rusya'nin baskentinin Moskova oldugunu test edelim

        String expectedBaskentIsmi= "Moskova";
        String actualBaskentIsmi = ulkelerMap.get("Rusya");
        Assert.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);

        // Listede baskenti San Marino olan bir ulke oldugunu test edelim

        Assert.assertTrue(ulkelerMap.containsValue("San Marino"));

        // Listede Filipinler'in oldugunu test edelim

        Assert.assertTrue(ulkelerMap.containsKey("Filipinler"));
    }
}
