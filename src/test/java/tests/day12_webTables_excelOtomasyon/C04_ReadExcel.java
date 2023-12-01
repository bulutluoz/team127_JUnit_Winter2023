package tests.day12_webTables_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {

        // ilgili ayarlamalari yapip, Sayfa2'yi acin

        String dosyaYolu = "src/test/java/tests/day12_webTables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2 = workbook.getSheet("Sayfa2");

        // sayfada son kullanilan satirin 26.satir oldugunu test edin

        int expectedSatirSayisi = 26;
        int actualSatirSayisi = sayfa2.getLastRowNum()+1;

        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        // sayfada reel olarak yazi yazilan satir sayisinin 12 oldugunu test edin

        int expectedFizikiKullanilanSatirSayisi = 12;
        int actualFizikiKullanilanSatirSayisi = sayfa2.getPhysicalNumberOfRows();

        Assert.assertEquals(expectedFizikiKullanilanSatirSayisi,actualFizikiKullanilanSatirSayisi);

    }
}
